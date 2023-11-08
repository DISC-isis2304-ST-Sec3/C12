package uniandes.edu.co.hotelAndes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.hotelAndes.modelo.Utensilio;
import uniandes.edu.co.hotelAndes.repositorio.UtensilioRepository;

@Controller
public class UtensiliosController {

    @Autowired
    private UtensilioRepository utensilioRepository;

    @GetMapping("/utensilios")
    public String utensilios(Model model) {
        model.addAttribute("utensilios", utensilioRepository.darUtensilios());
        return "utensilios";
    }

    @GetMapping("/utensilios/new")
    public String utensilioForm(Model model) {
        model.addAttribute("utensilio", new Utensilio());
        return "utensilioNuevo";
    }

    @PostMapping("/utensilios/new/save")
    public String utensilioGuardar(@ModelAttribute Utensilio utensilio) {
        utensilioRepository.save(utensilio);
        return "redirect:/utensilios";
    }

    @GetMapping("/utensilios/{id}/edit")
    public String utensilioEditarForm(@PathVariable("id") Long id, Model model) {
        Utensilio utensilio = utensilioRepository.findById(id).orElse(null);

        if (utensilio != null) {
            model.addAttribute("utensilio", utensilio);
            return "utensilioEditar";
        } else {
            return "redirect:/utensilios";
        }
    }

    @PostMapping("/utensilios/{id}/edit/save")
    public String utensilioEditarGuardar(@PathVariable("id") Long id, @ModelAttribute Utensilio utensilio) {
        Utensilio utensilioExistente = utensilioRepository.findById(id).orElse(null);

        if (utensilioExistente != null) {
            // Actualizar los atributos del utensilio existente con los nuevos valores
            utensilioExistente.setDevuelto(utensilio.getDevuelto());
            utensilioExistente.setEstado(utensilio.getEstado());

            // Guardar el utensilio actualizado en el repositorio
            utensilioRepository.save(utensilioExistente);
        }

        return "redirect:/utensilios";
    }

    @GetMapping("/utensilios/{id}/delete")
    public String utensilioBorrar(@PathVariable("id") Long id) {
        utensilioRepository.deleteById(id);
        return "redirect:/utensilios";
    }
}
