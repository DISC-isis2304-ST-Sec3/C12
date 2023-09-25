package uniandes.edu.co.hotelAndes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelAndesController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
