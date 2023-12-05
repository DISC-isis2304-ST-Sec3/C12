package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.proyecto.repositorio.UserRepository;
import uniandes.edu.co.proyecto.repositorio.UserRepository.RespuestaServicioUsers;


@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;


   @GetMapping("/usersServicio")
    public String getInformacionUsersPorServicio(Model model, String idServicio, String fechaInicio, String fechaFinal, String sort) {
        Collection<RespuestaServicioUsers> usersServicio;
        if ("asc".equals(sort)) {
            usersServicio = userRepository.darInformacionUsersPorServicioAsc(idServicio, fechaInicio, fechaFinal);
        } else if ("desc".equals(sort)) {
            usersServicio = userRepository.darInformacionUsersPorServicioDesc(idServicio, fechaInicio, fechaFinal);
        } else if ("ascU".equals(sort)) {
            usersServicio = userRepository.darInformacionUsersPorServicioUsuarioAsc(idServicio, fechaInicio, fechaFinal);
        } else if ("descU".equals(sort)) {
            usersServicio = userRepository.darInformacionUsersPorServicioUsuarioDesc(idServicio, fechaInicio, fechaFinal);
        } else if ("ascF".equals(sort)) {
            usersServicio = userRepository.darInformacionUsersPorServicioFechaAsc(idServicio, fechaInicio, fechaFinal);
        } else if ("descF".equals(sort)) {
            usersServicio = userRepository.darInformacionUsersPorServicioFechaDesc(idServicio, fechaInicio, fechaFinal);
        }
        else {
            usersServicio = userRepository.darInformacionUsersPorServicio(idServicio, fechaInicio, fechaFinal);
        }
        model.addAttribute("usersServicio", usersServicio);
        return "usersServicio";
    }
    
}
