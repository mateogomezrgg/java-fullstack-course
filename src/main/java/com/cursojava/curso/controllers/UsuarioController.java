package com.cursojava.curso.controllers;

import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @RequestMapping(value = "usuario")

    public Usuario getUsuario() {
        Usuario usuario = new Usuario();

        usuario.setNombre("Mateo");
        usuario.setApellido("Gomez");
        usuario.setEmail("asdasd@gmail.com");
        usuario.setTelefono("3423452341");
        usuario.setPassword("123456789a");

        return usuario;
    }
}
