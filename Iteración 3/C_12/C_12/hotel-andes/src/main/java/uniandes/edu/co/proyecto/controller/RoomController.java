package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Room;
import uniandes.edu.co.proyecto.repositorio.RoomRepository;
import uniandes.edu.co.proyecto.repositorio.RoomTypeRepository;
import uniandes.edu.co.proyecto.repositorio.RoomRepository.RespuestaGrupo;

@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

     @Autowired
    private RoomTypeRepository roomTypeRepository;

    @GetMapping("/rooms")
    public String getRoom(Model model) {
        model.addAttribute("rooms", roomRepository.findAllRooms());
        return "rooms";
    }

    //  @GetMapping("/roomsDineroRecolectado")
    // public String getRoomDineroRecolectado(Model model) {
    //     try{
    //         List<RespuestaGrupo> informacionDineroRecolectado = roomRepository.findRoomConsumptionCostInLastYear();
    //         model.addAttribute("roomsDineroRecolectado", informacionDineroRecolectado);
    //         return "roomsDineroRecolectado";
    //     }catch(Exception e){
    //         return "rooms";
    //     }
        
    // }

    @GetMapping("/rooms/new")
    public String RoomForm(Model model) {
        model.addAttribute("roomsTypes", roomTypeRepository.findAllRoomTypes());
        model.addAttribute("room", new Room());
        return "roomNuevo";
    }

    @PostMapping("/rooms/new/save")
    public String RoomGuardar(@ModelAttribute Room room) {
        roomRepository.save(room);
        return "redirect:/rooms";
    }

    @GetMapping("/rooms/{id}/edit")
    public String RoomEditarForm(@PathVariable("id") String id, Model model) {
        Room room = roomRepository.findById(id).orElse(null);
        if (room != null) {
            model.addAttribute("room", room);
            model.addAttribute("roomsTypes", roomTypeRepository.findAllRoomTypes());
            return "roomEditar";
        }
        
        return "redirect:/rooms";
    }

    @PostMapping("/rooms/{id}/edit/save")
    public String RoomEditar(@PathVariable("id") String id, @ModelAttribute Room room) {
    Room existingRoom = roomRepository.findById(id).orElse(null);
    if (existingRoom != null) {
        existingRoom.setDisponibility(room.getDisponibility());
        existingRoom.setType(room.getType());

        roomRepository.save(existingRoom);
    }

    return "redirect:/rooms";
}

    @GetMapping("/rooms/{id}/delete")
    public String RoomBorrar(@PathVariable("id") String id) {
        roomRepository.deleteByNumero(id);
        return "redirect:/rooms";
    }
    
}
