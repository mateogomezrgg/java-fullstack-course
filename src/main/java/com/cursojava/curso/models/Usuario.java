package com.cursojava.curso.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Usuarios")
@Data
public class Usuario {
    @Column(name="Id")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
