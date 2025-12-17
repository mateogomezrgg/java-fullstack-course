package com.cursojava.curso.controllers;

import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Mateo");
        usuario.setApellido("Gomez");
        usuario.setEmail("asdasd@gmail.com");
        usuario.setTelefono("3423452341");
        usuario.setPassword("123456789a");

        return usuario;
    }

    @RequestMapping(value = "usuario111")
    public Usuario editarUsuario() {
        Usuario usuario = new Usuario();

        usuario.setNombre("Mateo");
        usuario.setApellido("Gomez");
        usuario.setEmail("asdasd@gmail.com");
        usuario.setTelefono("3423452341");
        usuario.setPassword("123456789a");

        return usuario;
    }

    @RequestMapping(value = "usuario222")
    public Usuario eliminarUsuario() {
        Usuario usuario = new Usuario();

        usuario.setNombre("Mateo");
        usuario.setApellido("Gomez");
        usuario.setEmail("asdasd@gmail.com");
        usuario.setTelefono("3423452341");
        usuario.setPassword("123456789a");

        return usuario;
    }

    @RequestMapping(value = "usuario333")
    public Usuario crearNuevoUsuario() {
        Usuario usuario = new Usuario();

        usuario.setNombre("Mateo");
        usuario.setApellido("Gomez");
        usuario.setEmail("asdasd@gmail.com");
        usuario.setTelefono("3423452341");
        usuario.setPassword("123456789a");

        return usuario;
    }
}
