package uniandes.edu.co.hotelAndes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.hotelAndes.modelo.Gimnasio;
import uniandes.edu.co.hotelAndes.repositorio.GimnasioRepository;

@Controller
public class GimnasiosController {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    @GetMapping("/gimnasios")
    public String gimnasios(Model model) {
        model.addAttribute("gimnasios", gimnasioRepository.darGimnasios());
        return "gimnasios";
    }

    @GetMapping("/gimnasios/new")
    public String gimnasioForm(Model model) {
        model.addAttribute("gimnasio", new Gimnasio());
        return "gimnasioNuevo";
    }

    @PostMapping("/gimnasios/new/save")
    public String gimnasioGuardar(@ModelAttribute Gimnasio gimnasio) {
        gimnasioRepository.save(gimnasio);
        return "redirect:/gimnasios";
    }

    @GetMapping("/gimnasios/{id}/edit")
    public String gimnasioEditarForm(@PathVariable("id") Long id, Model model) {
        Gimnasio gimnasio = gimnasioRepository.findById(id).orElse(null);

        if (gimnasio != null) {
            model.addAttribute("gimnasio", gimnasio);
            return "gimnasioEditar";
        } else {
            return "redirect:/gimnasios";
        }
    }

    @PostMapping("/gimnasios/{id}/edit/save")
    public String gimnasioEditarGuardar(@PathVariable("id") Long id, @ModelAttribute Gimnasio gimnasio) {
        Gimnasio gimnasioExistente = gimnasioRepository.findById(id).orElse(null);

        if (gimnasioExistente != null) {
            // Actualizar los atributos del gimnasio existente con los nuevos valores
            gimnasioExistente.setHorarioInicial(gimnasio.getHorarioInicial());
            gimnasioExistente.setHorarioFinal(gimnasio.getHorarioFinal());
            gimnasioExistente.setReserva_id(gimnasio.getReserva_id());
            gimnasioExistente.setNombre(gimnasio.getNombre());
            gimnasioExistente.setCosto(gimnasio.getCosto());
            gimnasioExistente.setCargado(gimnasio.getCargado());
            gimnasioExistente.setExiste(gimnasio.getExiste());
            gimnasioExistente.setCapacidad(gimnasio.getCapacidad());
            gimnasioExistente.setMaquinas(gimnasio.getMaquinas());
            gimnasioExistente.setHoraInicio(gimnasio.getHoraInicio());
            gimnasioExistente.setHoraFin(gimnasio.getHoraFin());

            // Guardar el gimnasio actualizado en el repositorio
            gimnasioRepository.save(gimnasioExistente);
        }

        return "redirect:/gimnasios";
    }

    @GetMapping("/gimnasios/{id}/delete")
    public String gimnasioBorrar(@PathVariable("id") Long id) {
        gimnasioRepository.deleteById(id);
        return "redirect:/gimnasios";
    }
}
