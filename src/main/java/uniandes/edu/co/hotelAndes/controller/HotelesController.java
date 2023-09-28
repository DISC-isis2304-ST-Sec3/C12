package uniandes.edu.co.hotelAndes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.hotelAndes.repositorio.HotelRepository;

@Controller
public class HotelesController {

    @Autowired
    private HotelRepository hotelRepository;


    @GetMapping("/hoteles")
    public String hoteles(Model model) {
        model.addAttribute("hoteles", hotelRepository.darHoteles());
        return "hoteles";
    }


}
