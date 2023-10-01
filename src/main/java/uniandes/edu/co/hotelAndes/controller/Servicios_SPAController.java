package uniandes.edu.co.hotelAndes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.hotelAndes.modelo.Servicio_SPA;
import uniandes.edu.co.hotelAndes.repositorio.Servicio_SPARepository;

@Controller
public class Servicios_SPAController {

    @Autowired
    private Servicio_SPARepository servicioSPARepository;

    @GetMapping("/servicios_spa")
    public String serviciosSPA(Model model) {
        model.addAttribute("servicios_spa", servicioSPARepository.darServiciosSPA());
        return "servicios_spa";
    }

    @GetMapping("/servicios_spa/new")
    public String servicioSPAForm(Model model) {
        model.addAttribute("servicio_spa", new Servicio_SPA());
        return "servicio_spaNuevo";
    }

    @PostMapping("/servicios_spa/new/save")
    public String servicioSPAGuardar(@ModelAttribute Servicio_SPA servicioSPA) {
        servicioSPARepository.save(servicioSPA);
        return "redirect:/servicios_spa";
    }

    @GetMapping("/servicios_spa/{id}/edit")
    public String servicioSPAEditarForm(@PathVariable("id") Long id, Model model) {
        Servicio_SPA servicioSPA = servicioSPARepository.findById(id).orElse(null);

        if (servicioSPA != null) {
            model.addAttribute("servicio_spa", servicioSPA);
            return "servicio_spaEditar";
        } else {
            return "redirect:/servicios_spa";
        }
    }

    @PostMapping("/servicios_spa/{id}/edit/save")
    public String servicioSPAEditarGuardar(@PathVariable("id") Long id, @ModelAttribute Servicio_SPA servicioSPA) {
        Servicio_SPA servicioSPAExistente = servicioSPARepository.findById(id).orElse(null);

        if (servicioSPAExistente != null) {
            // Actualizar los atributos del Servicio_SPA existente con los nuevos valores
            servicioSPAExistente.setDuracion(servicioSPA.getDuracion());
            servicioSPAExistente.setCosto(servicioSPA.getCosto());
            servicioSPAExistente.setFecha(servicioSPA.getFecha());
            servicioSPAExistente.setHora(servicioSPA.getHora());

            // Guardar el Servicio_SPA actualizado en el repositorio
            servicioSPARepository.save(servicioSPAExistente);
        }

        return "redirect:/servicios_spa";
    }

    @GetMapping("/servicios_spa/{id}/delete")
    public String servicioSPABorrar(@PathVariable("id") Long id) {
        servicioSPARepository.deleteById(id);
        return "redirect:/servicios_spa";
    }
}
