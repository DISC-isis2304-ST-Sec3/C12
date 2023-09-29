package uniandes.edu.co.hotelAndes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.hotelAndes.modelo.Hotel;
import uniandes.edu.co.hotelAndes.modelo.PlanConsumo;
import uniandes.edu.co.hotelAndes.repositorio.PlanesConsumoRepository;

@Controller
public class PlanesConsumoController {

    @Autowired
    private PlanesConsumoRepository planesConsumoRepository;

    @GetMapping("/planesConsumo")
    public String planesConsumo(Model model) {
        model.addAttribute("planesConsumo", planesConsumoRepository.darPlanesConsumo());
        return "planesConsumo";
    }

    @GetMapping("/planesConsumo/new")
    public String planConsumoForm(Model model) {
        model.addAttribute("planConsumo", new PlanConsumo());
        return "planConsumoNuevo";
    }

    @PostMapping("/planesConsumo/new/save")
    public String planConsumoGuardar(@ModelAttribute PlanConsumo plan) {

        planesConsumoRepository.insertarPlanConsumo(plan.getTipoplan(), plan.getDescuento(), plan.getHotel_id().getId(), plan.getDescuento1());

        return "redirect:/planesConsumo";
    }


}
