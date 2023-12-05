package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uniandes.edu.co.proyecto.modelo.Consumption;
import uniandes.edu.co.proyecto.modelo.RoomReservation;
import uniandes.edu.co.proyecto.repositorio.ConsumptionRepository;
import uniandes.edu.co.proyecto.repositorio.RoomReservationRepository;
import uniandes.edu.co.proyecto.repositorio.RoomReservationRepository.RespuestaGrupo;
import uniandes.edu.co.proyecto.repositorio.RoomReservationRepository.RespuestaGrupo2;
import uniandes.edu.co.proyecto.repositorio.RoomReservationRepository.datesDetail;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

@Controller
public class RoomReservationController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RoomReservationRepository roomReservationRepository;

    @Autowired
    private ConsumptionRepository consumptionRepository;

    @GetMapping("/roomsReservations")
    public String getRoomReservation(Model model) {
        model.addAttribute("roomsReservations", roomReservationRepository.findByRoomsReservations());
        model.addAttribute("consumptions", consumptionRepository.findAll());
        return "roomsReservations";
    }

    // RQF 1
    @GetMapping("/roomsDineroRecolectado")
    public String getRoomDineroRecolectado(Model model) {
        try {
            List<RespuestaGrupo2> informacionDineroRecolectado = roomReservationRepository
                    .findRoomConsumptionCostInLastYear();
            model.addAttribute("roomsDineroRecolectado", informacionDineroRecolectado);
            return "roomsDineroRecolectado";
        } catch (Exception e) {
            return "rooms";
        }

    }

    // RQFC2
    @GetMapping("/roomsOcupation")
    public String getRoomReservationOccupation(Model model) {
        // try{
        long millisecondsInOneYear = 365L * 24L * 60L * 60L * 1000L;
        long millisecondsInOneDay = 1000L * 60L * 60L * 24L;
        double multiplier = 100.0 / 365.0;

        // model.addAttribute("roomsOcupation",
        // roomReservationRepository.calculateRoomOccupancyRates(millisecondsInOneYear,
        // millisecondsInOneDay, multiplier));
        model.addAttribute("roomsOcupation", roomReservationRepository.calculateRoomOccupancyRates());

        // System.out.println(roomReservationRepository.calculateRoomOccupancyRates(millisecondsInOneYear,
        // millisecondsInOneDay, multiplier));

        return "roomsOcupation";
        // }catch (Exception e){
        // return "rooms";
        // }

    }

    // RQFC3
    @GetMapping("/consumoCliente")
    public String getConsumoCliente(Model model, String usuario, String fechaInicio, String fechaFinal) {
        // try{
        model.addAttribute("consumoCliente",
                roomReservationRepository.findCustomAggregation(usuario, fechaInicio, fechaFinal));
        return "consumoCliente";
        // } catch(Exception e){
        // return "consumptions";
        // }
    }

    @GetMapping("/roomsReservations/new")
    public String RoomReservationForm(Model model) {
        model.addAttribute("estaEditando", false);
        model.addAttribute("roomReservation", new RoomReservation());
        return "newRoomReservation";
    }

    @PostMapping("/roomsReservations/new/save")
    public String RoomReservationGuardar(@ModelAttribute RoomReservation roomReservation) {
        // verificar que no exista una reservacion para la misma habitacion en las
        // mismas fechas
        // si existe, no guardar

        List<RoomReservation> roomReservationInfo = roomReservationRepository.findByDateRange(
                roomReservation.getEntryDate(),
                roomReservation.getDepartureDate());
        Boolean existeRReserv = true;

        if (roomReservationInfo.size() != 0) {
            for (RoomReservation roomReservation2 : roomReservationInfo) {
                if (roomReservation2.getRoom().getId().equals(roomReservation.getRoom().getId())) {
                    existeRReserv = false;
                    break;
                }
            }
        }

        if (existeRReserv == true) {
            // roomReservation.setRoom(roomReservation.getRoom().getId());
            roomReservationRepository.save(roomReservation);
        }

        return "redirect:/roomsReservations";
    }

    @GetMapping("/roomsReservations/{id}/edit")
    public String RoomReservationEditarForm(@PathVariable("id") String id, Model model) {

        model.addAttribute("estaEditando", true);

        RoomReservation roomReservation = roomReservationRepository.findByRoomReservation(id);
        if (roomReservation != null) {
            model.addAttribute("roomReservation", roomReservation);
            return "editRoomsReservations";
        }
        return "redirect:/roomsReservations";
    }

    @GetMapping("/roomsReservations/{id}/edit/addConsumption")
    public String RoomReservationEditarConsumptionForm(@PathVariable("id") String id, Model model) {

        model.addAttribute("consumptions", consumptionRepository.findAll());

        RoomReservation roomReservation = roomReservationRepository.findByRoomReservation(id);
        if (roomReservation != null) {
            model.addAttribute("roomReservation", roomReservation);
            return "addConsumoRoomsReservations";
        }
        return "redirect:/roomsReservations";
    }

    @PostMapping("/roomsReservations/{id}/edit/save")
    public String RoomReservationEditar(@PathVariable("id") String id,
            @ModelAttribute RoomReservation roomReservation) {
        RoomReservation existingRoomReservation = roomReservationRepository.findById(id).orElse(null);

        if (existingRoomReservation != null) {
            existingRoomReservation.setEntryDate(roomReservation.getEntryDate());
            existingRoomReservation.setDepartureDate(roomReservation.getDepartureDate());
            existingRoomReservation.setNumPeople(roomReservation.getNumPeople());
            existingRoomReservation.setCheckIn(roomReservation.getCheckIn());
            existingRoomReservation.setCheckOut(roomReservation.getCheckOut());
            existingRoomReservation.setRoom(roomReservation.getRoom());
            existingRoomReservation.setUser(roomReservation.getUser());
            existingRoomReservation.setConsumptions(roomReservation.getConsumptions());

            List<RoomReservation> roomReservationInfo = roomReservationRepository.findByDateRange(
                    roomReservation.getEntryDate(),
                    roomReservation.getDepartureDate());
            Boolean existeRReserv = true;

            if (roomReservationInfo.size() != 0) {
                for (RoomReservation roomReservation2 : roomReservationInfo) {
                    if (roomReservation2.getRoom().getId().equals(roomReservation.getRoom().getId())) {
                        existeRReserv = false;
                        break;
                    }
                }
            }

            if (existeRReserv == true) {
                roomReservationRepository.save(roomReservation);
            }

        }

        return "redirect:/roomsReservations";
    }

    @PostMapping("/roomsReservations/{id}/edit/save/{consumptionId}")
    public String RoomReservationEditarConsunmption(@PathVariable("id") String id,
            @PathVariable("consumptionId") String consumptionId, @ModelAttribute RoomReservation roomReservation) {

        RoomReservation existingRoomReservation = roomReservationRepository.findById(id).orElse(null);
        Consumption consumption = consumptionRepository.findById(consumptionId).orElse(null);

        List<Consumption> consumptions = existingRoomReservation.getConsumptions();
        consumptions.add(consumption);

        if (existingRoomReservation != null) {
            existingRoomReservation.setConsumptions(consumptions);
            roomReservationRepository.save(existingRoomReservation);
        }

        return "redirect:/roomsReservations";

    }

    @GetMapping("/roomsReservations/{id}/delete")
    public String RoomReservationBorrar(@PathVariable("id") String id) {
        roomReservationRepository.deleteById(id);
        return "redirect:/roomsReservations";
    }

    @GetMapping("/datesDetail")
    public String RoomReservationDatesDetail(String id, Model model) {
        if (id == null || id.isEmpty()) {
            return "datesDetail";
        }
        datesDetail datesDetail = roomReservationRepository.findDatesById(new ObjectId(id));
        model.addAttribute("datesDetail", datesDetail);
        return "datesDetail";
    }

    @RequestMapping("/updateDepartureDate")
    public String updateDepartureDate(String id, String newDepartureDate, Model model) {
        if (id == null || id.isEmpty()) {
            // Agregar mensajes o lógica si es necesario
            return "updateDepartureDate";
        }

        Optional<RoomReservation> reservationOptional = roomReservationRepository.findById(id);

        // Actualiza solo el campo departureDate
        Update update = new Update();
        update.set("departureDate", newDepartureDate);

        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.updateFirst(query, update, RoomReservation.class);

        // Agregar mensajes o datos al modelo si es necesario
        model.addAttribute("message", "Actualización exitosa");

        return "updateDepartureDate";
    }

    @RequestMapping("/updateEntryDate")
    public String updateEntryDate(String id, String newEntryDate, Model model) {
        if (id == null || id.isEmpty()) {
            // Agregar mensajes o lógica si es necesario
            return "updateEntryDate";
        }

        Optional<RoomReservation> reservationOptional = roomReservationRepository.findById(id);

        // Actualiza solo el campo departureDate
        Update update = new Update();
        update.set("entryDate", newEntryDate);

        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.updateFirst(query, update, RoomReservation.class);

        // Agregar mensajes o datos al modelo si es necesario
        model.addAttribute("message", "Actualización exitosa");

        return "updateEntryDate";
    }

}
