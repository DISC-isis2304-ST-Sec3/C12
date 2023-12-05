package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Consumption;
import uniandes.edu.co.proyecto.modelo.Product;
import uniandes.edu.co.proyecto.repositorio.ConsumptionRepository;
import uniandes.edu.co.proyecto.repositorio.ProductRepository;

// @RestController
@Controller
public class ConsumptionController {

    @Autowired
    private ConsumptionRepository consumptionRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/consumptions")
    public String consumptions(Model model) {
        model.addAttribute("consumptions", consumptionRepository.findAll());
        return "consumptions";
    }

    @GetMapping("/consumptions/new")
    public String consuumptionForm(Model model) {
        model.addAttribute("consumption", new Consumption());
        return "newConsumption";
    }

    @PostMapping("/consumptions/new/save")
    public String ConsumptionGuardar(@ModelAttribute Consumption consumption) {
        consumptionRepository.save(consumption);
        return "redirect:/consumptions";
    }

    @GetMapping("/consumptions/{id}/edit")
    public String consumptionEditarForm(@PathVariable("id") String id, Model model) {
        Consumption consumption = consumptionRepository.findByid(id);
        if (consumption != null) {
            model.addAttribute("consumption", consumption);
            return "editConsumption";
        }
        return "redirect:/consumptions";
    }

    @PostMapping("/consumptions/{id}/edit/save")
    public String ConsumptionEditar(@PathVariable("id") String id, @ModelAttribute Consumption consumption) {
        Consumption existingConsumption = consumptionRepository.findById(id).orElse(null);

        if (existingConsumption != null) {
            existingConsumption.setCost(consumption.getCost());
            existingConsumption.setDate(consumption.getDate());
            existingConsumption.setProducts(consumption.getProducts());

            consumptionRepository.save(existingConsumption);
        }

        return "redirect:/consumptions";
    }

    @GetMapping("/consumptions/{id}/edit/addProd")
    public String consumptioneEditarProdForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("products", productRepository.findAllProducts());
        Consumption consumption = consumptionRepository.findByid(id);
        if (consumption != null) {
            model.addAttribute("consumption", consumption);
            return "addProdConsumption";
        }
        return "redirect:/consumptions";
    }

    @PostMapping("/consumptions/{id}/edit/save/{prodName}")
    public String consumptionEditarProd(@PathVariable("id") String id, @PathVariable("prodName") String prodName,
            @ModelAttribute Consumption consumption, Model model) {
        Consumption existingConsumption = consumptionRepository.findById(id).orElse(null);
        Product product = productRepository.findByName(prodName);

        List<Product> products = existingConsumption.getProducts();
        products.add(product);

        if (existingConsumption != null) {
            existingConsumption.setProducts(products);

            consumptionRepository.save(existingConsumption);
        }

        return "redirect:/consumptions";
    }

    @GetMapping("/consumptions/{id}/delete")
    public String ConsumptionBorrar(@PathVariable("id") String id) {
        consumptionRepository.deleteByid(id);
        return "redirect:/consumptions";
    }

}
