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
    public String getInformacionUsersPorServicio(Model model, String idServicio, String fechaInicio, String fechaFinal,
            String sort) {
        Collection<RespuestaServicioUsers> usersServicio;

        if ("asc".equals(sort)) {
            model.addAttribute("usersServicio",
                    userRepository.darInformacionUsersPorServicioAsc(fechaInicio, fechaFinal, idServicio));
        } else if ("desc".equals(sort)) {
            model.addAttribute("usersServicio",
                    userRepository.darInformacionUsersPorServicioDesc(fechaInicio, fechaFinal, idServicio));
        } else if ("ascU".equals(sort)) {
            model.addAttribute("usersServicio",
                    userRepository.darInformacionUsersPorServicioUsuarioAsc(fechaInicio, fechaFinal, idServicio));
        } else if ("descU".equals(sort)) {
            model.addAttribute("usersServicio",
                    userRepository.darInformacionUsersPorServicioUsuarioDesc(fechaInicio, fechaFinal, idServicio));
        } else if ("ascF".equals(sort)) {
            model.addAttribute("usersServicio",
                    userRepository.darInformacionUsersPorServicioFechaAsc(fechaInicio, fechaFinal, idServicio));
        } else if ("descF".equals(sort)) {
            model.addAttribute("usersServicio",
                    userRepository.darInformacionUsersPorServicioFechaDesc(fechaInicio, fechaFinal, idServicio));
        } else {
            model.addAttribute("usersServicio",
                    userRepository.darInformacionUsersPorServicio(fechaInicio, fechaFinal, idServicio));
        }
        return "usersServicio";
    }
}