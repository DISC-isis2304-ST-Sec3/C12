package uniandes.edu.co.hotelAndes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.hotelAndes.modelo.SPA;
import uniandes.edu.co.hotelAndes.repositorio.SPARepository;

@Controller
public class SPAsController {

    @Autowired
    private SPARepository spaRepository;

    @GetMapping("/spas")
    public String spas(Model model) {
        model.addAttribute("spas", spaRepository.darSPAs());
        return "spas";
    }

    @GetMapping("/spas/new")
    public String spaForm(Model model) {
        model.addAttribute("spa", new SPA());
        return "spaNuevo";
    }

    @PostMapping("/spas/new/save")
    public String spaGuardar(@ModelAttribute SPA spa) {
        spaRepository.save(spa);
        return "redirect:/spas";
    }

    @GetMapping("/spas/{id}/edit")
    public String spaEditarForm(@PathVariable("id") Long id, Model model) {
        SPA spa = spaRepository.findById(id).orElse(null);

        if (spa != null) {
            model.addAttribute("spa", spa);
            return "spaEditar";
        } else {
            return "redirect:/spas";
        }
    }

    @PostMapping("/spas/{id}/edit/save")
    public String spaEditarGuardar(@PathVariable("id") Long id, @ModelAttribute SPA spa) {
        SPA spaExistente = spaRepository.findById(id).orElse(null);

        if (spaExistente != null) {
            // Actualizar los atributos del SPA existente con los nuevos valores
            spaExistente.setHorarioInicial(spa.getHorarioInicial());
            spaExistente.setHorarioFinal(spa.getHorarioFinal());
            spaExistente.setReserva_id(spa.getReserva_id());
            spaExistente.setNombre(spa.getNombre());
            spaExistente.setCosto(spa.getCosto());
            spaExistente.setCargado(spa.getCargado());
            spaExistente.setExiste(spa.getExiste());
            spaExistente.setCapacidad(spa.getCapacidad());

            // Guardar el SPA actualizado en el repositorio
            spaRepository.save(spaExistente);
        }

        return "redirect:/spas";
    }

    @GetMapping("/spas/{id}/delete")
    public String spaBorrar(@PathVariable("id") Long id) {
        spaRepository.deleteById(id);
        return "redirect:/spas";
    }
}
