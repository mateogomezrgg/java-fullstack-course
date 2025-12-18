package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@RequestHeader(value="Authorization") String token, @PathVariable Long id) {
        if(validarToken(token)){ return null; }

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Mateo");
        usuario.setApellido("Gomez");
        usuario.setEmail("asdasd@gmail.com");
        usuario.setTelefono("3423452341");
        usuario.setPassword("123456789a");

        return usuario;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value="Authorization") String token) {
        if(validarToken(token)){ return null; }

        return usuarioDao.getUsuarios();
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId == null;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) {
        if(validarToken(token)){ return; }
        usuarioDao.eliminar(id);
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        // CORRECCIÓN: Usar .toCharArray()
        // Nota: (1, 1024, 1) son parámetros muy bajos (rápidos) para pruebas.
        // En producción real se usan valores más altos, pero para el curso está bien.
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword().toCharArray());

        usuario.setPassword(hash);

        usuarioDao.registrarUsuario(usuario);
    }
}
