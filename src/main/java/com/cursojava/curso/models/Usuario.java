package com.cursojava.curso.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Usuarios")
@Data
public class Usuario {
    @Column(name="Id")
    @Id
    private Long id;

    @Column(name="Nombre")
    private String nombre;

    @Column(name="Apellido")
    private String apellido;

    @Column(name="Telefono")
    private String telefono;

    @Column(name="Email")
    private String email;

    @Column(name="Password")
    private String password;
}
