package uniandes.edu.co.hotelAndes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;
import uniandes.edu.co.hotelAndes.modelo.Usuario;
import uniandes.edu.co.hotelAndes.repositorio.UsuarioRepository;

@Controller
public class UsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarioNuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario user) {
        usuarioRepository.insertarUsuario(user.getNombre(), user.getTipoDocumento(), user.getNumeroDocumento(), user.getRol(), user.getCorreo());
        return "redirect:/bares";
    }

    @GetMapping("/usuarios/{id}/edit")
    public String usuarioEditarForm(@PathVariable("id") String id, Model model) {
        Usuario usuario = usuarioRepository.darUsuario(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        } else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/usuarios/{id}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("id") String id, @ModelAttribute Usuario user) {
        usuarioRepository.actualizarUsuario( user.getNombre(), user.getTipoDocumento(), user.getNumeroDocumento(), user.getRol(), user.getCorreo());
        return "redirect:/usuarios";
    }








}
