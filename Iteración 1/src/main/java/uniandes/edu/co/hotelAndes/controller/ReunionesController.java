package uniandes.edu.co.hotelAndes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.hotelAndes.modelo.Reunion;
import uniandes.edu.co.hotelAndes.repositorio.ReunionRepository;

@Controller
public class ReunionesController {

    @Autowired
    private ReunionRepository reunionRepository;

    @GetMapping("/reuniones")
    public String reuniones(Model model) {
        model.addAttribute("reuniones", reunionRepository.darReuniones());
        return "reuniones";
    }

    @GetMapping("/reuniones/new")
    public String reunionForm(Model model) {
        model.addAttribute("reunion", new Reunion());
        return "reunionNuevo";
    }

    @PostMapping("/reuniones/new/save")
    public String reunionGuardar(@ModelAttribute Reunion reunion) {
        reunionRepository.save(reunion);
        return "redirect:/reuniones";
    }

    @GetMapping("/reuniones/{id}/edit")
    public String reunionEditarForm(@PathVariable("id") Long id, Model model) {
        Reunion reunion = reunionRepository.findById(id).orElse(null);

        if (reunion != null) {
            model.addAttribute("reunion", reunion);
            return "reunionEditar";
        } else {
            return "redirect:/reuniones";
        }
    }

    @PostMapping("/reuniones/{id}/edit/save")
    public String reunionEditarGuardar(@PathVariable("id") Long id, @ModelAttribute Reunion reunion) {
        Reunion reunionExistente = reunionRepository.findById(id).orElse(null);

        if (reunionExistente != null) {
            // Actualizar los atributos de la Reunion existente con los nuevos valores
            reunionExistente.setCapacidad(reunion.getCapacidad());
            reunionExistente.setCostoAdicional(reunion.getCostoAdicional());
            reunionExistente.setFecha(reunion.getFecha());
            reunionExistente.setHora(reunion.getHora());
            reunionExistente.setDuracion(reunion.getDuracion());

            // Guardar la Reunion actualizada en el repositorio
            reunionRepository.save(reunionExistente);
        }

        return "redirect:/reuniones";
    }

    @GetMapping("/reuniones/{id}/delete")
    public String reunionBorrar(@PathVariable("id") Long id) {
        reunionRepository.deleteById(id);
        return "redirect:/reuniones";
    }
}
