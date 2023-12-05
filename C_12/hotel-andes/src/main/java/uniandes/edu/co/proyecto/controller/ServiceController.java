package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Product;
import uniandes.edu.co.proyecto.modelo.Service;
import uniandes.edu.co.proyecto.repositorio.ProductRepository;
import uniandes.edu.co.proyecto.repositorio.ServiceRepository;

@Controller
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("services", serviceRepository.findAllServices());
        model.addAttribute("products", productRepository.findAllProducts());
        return "services";
    }
 

    @GetMapping("/services/new")
    public String ServiceForm(Model model) {
        model.addAttribute("service", new Service());
        return "newService";
    }

    @PostMapping("/services/new/save")
    public String ServiceGuardar(@ModelAttribute Service service) {
        serviceRepository.save(service);
        return "redirect:/services";
    }

    @GetMapping("/services/{id}/edit")
    public String ServiceEditarForm(@PathVariable("id") String id, Model model) {
        Service service = serviceRepository.findByid(id);
        if (service != null) {
            model.addAttribute("service", service);
            return "editService";
        }
        return "redirect:/services";
    }

    @GetMapping("/services/{id}/edit/addProd")
    public String ServiceEditarProdForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("products", productRepository.findAllProducts());
        Service service = serviceRepository.findByid(id);
        if (service != null) {
            model.addAttribute("service", service);
            return "addProdService";
        }
        return "redirect:/services";
    }

    @PostMapping("/services/{id}/edit/save")
    public String ServiceEditar(@PathVariable("id") String id, @ModelAttribute Service service) {
        Service existingService = serviceRepository.findById(id).orElse(null);
    
        if (existingService != null) {
            existingService.setName(service.getName());
            existingService.setSchedule(service.getSchedule());
            existingService.setCapacity(service.getCapacity());
            existingService.setType(service.getType());
            existingService.setProducts(service.getProducts());
            existingService.setReservations(service.getReservations());
    
            serviceRepository.save(existingService);
        }
    
        return "redirect:/services";
    }


    @PostMapping("/services/{id}/edit/save/{prodName}")
    public String ServiceEditarProd(@PathVariable("id") String id, @PathVariable("prodName") String prodName, @ModelAttribute Service service, Model model) {
        Service existingService = serviceRepository.findById(id).orElse(null);
        Product product = productRepository.findByName(prodName);


        List<Product> products = existingService.getProducts();
        products.add(product);
    
        if (existingService != null) {
            existingService.setProducts(products);
    
            serviceRepository.save(existingService);
        }
    
        return "redirect:/services";
    }

    
    @GetMapping("/services/{id}/delete")
    public String ServiceBorrar(@PathVariable("id") String id) {
        serviceRepository.deleteByid(id);
        return "redirect:/services";
    }
    
}
