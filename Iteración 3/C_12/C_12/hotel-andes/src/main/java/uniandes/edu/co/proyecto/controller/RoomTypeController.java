package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.RoomElement;
import uniandes.edu.co.proyecto.modelo.RoomType;
import uniandes.edu.co.proyecto.repositorio.RoomTypeRepository;

@Controller
public class RoomTypeController {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @GetMapping("/room_types")
    public String getRoomType(Model model) {
        model.addAttribute("roomsTypes", roomTypeRepository.findAllRoomTypes());
        return "roomsTypes";
    }

    @GetMapping("/room_types/new")
    public String RoomTypeForm(Model model) {
        model.addAttribute("roomType", new RoomType());
        return "roomTypeNuevo";
    }

    @PostMapping("/room_types/new/save")
    public String RoomTypeGuardar(@ModelAttribute RoomType roomType) {
        roomTypeRepository.save(roomType);
        return "redirect:/room_types";
    }

    @GetMapping("/room_types/{id}/edit")
    public String RoomTypeEditarForm(@PathVariable("id") String id, Model model) {
        RoomType roomType = roomTypeRepository.findById(id).orElse(null);
        if (roomType != null) {
            model.addAttribute("roomType", roomType);
            return "roomTypeEditar";
        }
        return "redirect:/room_types";
    }

    @PostMapping("/room_types/{id}/edit/save")
    public String RoomTypeEditar(@PathVariable("id") String id, @ModelAttribute RoomType roomType) {
    RoomType existingRoomType = roomTypeRepository.findById(id).orElse(null);

    if (existingRoomType != null) {
        existingRoomType.setName(roomType.getName());
        existingRoomType.setCapacity(roomType.getCapacity());
        existingRoomType.setPriceNight(roomType.getPriceNight());
        existingRoomType.setRoomElements(roomType.getRoomElements());

        roomTypeRepository.save(existingRoomType);
    }

    return "redirect:/room_types";
}


  @GetMapping("/room_types/{id}/add_element")
    public String RoomTypeAgregarElementoForm(@PathVariable("id") String id, Model model) {
        RoomType roomType = roomTypeRepository.findById(id).orElse(null);
        if (roomType != null) {
            model.addAttribute("roomType", roomType);
            model.addAttribute("roomElement", new RoomElement());
            return "roomTypeAgregarElemento";
        }
        return "redirect:/room_types";
    }

    @PostMapping("/room_types/{id}/add_element/save")
public String RoomTypeAgregarElemento(@PathVariable("id") String id, @ModelAttribute RoomElement roomElement) {
    RoomType existingRoomType = roomTypeRepository.findById(id).orElse(null);

    if (existingRoomType != null) {
        roomTypeRepository.aniadirBebidaABar(id, roomElement.getName(), roomElement.getCost());
    }

    return "redirect:/room_types";
}


    @GetMapping("/room_types/{id}/delete")
    public String RoomTypeBorrar(@PathVariable("id") String id) {
        roomTypeRepository.deleteById(id);
        return "redirect:/room_types";
    }
    
}
