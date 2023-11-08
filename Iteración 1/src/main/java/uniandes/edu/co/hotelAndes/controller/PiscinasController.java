package uniandes.edu.co.hotelAndes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.hotelAndes.modelo.Piscina;
import uniandes.edu.co.hotelAndes.repositorio.PiscinaRepository;

@Controller
public class PiscinasController {

    @Autowired
    private PiscinaRepository piscinaRepository;

    @GetMapping("/piscinas")
    public String piscinas(Model model) {
        model.addAttribute("piscinas", piscinaRepository.darPiscinas());
        return "piscinas";
    }

    @GetMapping("/piscinas/new")
    public String piscinaForm(Model model) {
        model.addAttribute("piscina", new Piscina());
        return "piscinaNuevo";
    }

    @PostMapping("/piscinas/new/save")
    public String piscinaGuardar(@ModelAttribute Piscina piscina) {
        piscinaRepository.save(piscina);
        return "redirect:/piscinas";
    }

    @GetMapping("/piscinas/{id}/edit")
    public String piscinaEditarForm(@PathVariable("id") Long id, Model model) {
        Piscina piscina = piscinaRepository.findById(id).orElse(null);

        if (piscina != null) {
            model.addAttribute("piscina", piscina);
            return "piscinaEditar";
        } else {
            return "redirect:/piscinas";
        }
    }

    @PostMapping("/piscinas/{id}/edit/save")
    public String piscinaEditarGuardar(@PathVariable("id") Long id, @ModelAttribute Piscina piscina) {
        Piscina piscinaExistente = piscinaRepository.findById(id).orElse(null);

        if (piscinaExistente != null) {
            // Actualizar los atributos de la piscina existente con los nuevos valores
            piscinaExistente.setHorarioInicial(piscina.getHorarioInicial());
            piscinaExistente.setHorarioFinal(piscina.getHorarioFinal());
            piscinaExistente.setReserva_id(piscina.getReserva_id());
            piscinaExistente.setNombre(piscina.getNombre());
            piscinaExistente.setCosto(piscina.getCosto());
            piscinaExistente.setCargado(piscina.getCargado());
            piscinaExistente.setExiste(piscina.getExiste());
            piscinaExistente.setCapacidad(piscina.getCapacidad());
            piscinaExistente.setProfundidad(piscina.getProfundidad());
            piscinaExistente.setHoraInicio(piscina.getHoraInicio());
            piscinaExistente.setHoraFin(piscina.getHoraFin());

            // Guardar la piscina actualizada en el repositorio
            piscinaRepository.save(piscinaExistente);
        }

        return "redirect:/piscinas";
    }

    @GetMapping("/piscinas/{id}/delete")
    public String piscinaBorrar(@PathVariable("id") Long id) {
        piscinaRepository.deleteById(id);
        return "redirect:/piscinas";
    }
}
