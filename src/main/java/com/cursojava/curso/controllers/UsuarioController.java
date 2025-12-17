package com.cursojava.curso.controllers;

import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(123L);
        usuario.setNombre("Mateo");
        usuario.setApellido("Gomez");
        usuario.setEmail("asdasd@gmail.com");
        usuario.setTelefono("3423452341");
        usuario.setPassword("123456789a");

        Usuario usuario2 = new Usuario();
        usuario2.setId(127L);
        usuario2.setNombre("Martin");
        usuario2.setApellido("Gomez");
        usuario2.setEmail("qweqwe@gmail.com");
        usuario2.setTelefono("3423452221");
        usuario2.setPassword("834587asasd");

        Usuario usuario3 = new Usuario();
        usuario3.setId(131L);
        usuario3.setNombre("Ricardo");
        usuario3.setApellido("Gomez");
        usuario3.setEmail("qweq123123we@gmail.com");
        usuario3.setTelefono("311112321");
        usuario3.setPassword("asdsfgga");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        return usuarios;
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
