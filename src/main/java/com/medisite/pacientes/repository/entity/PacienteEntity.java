package com.medisite.pacientes.repository.entity;
import lombok.*;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;

import java.sql.Date;
import java.sql.Time;

@Data
@Entity

@Table(name="paciente")
public class PacienteEntity {
    @Column(name="id_paciente")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPaciente;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido_paterno")
    private String apellidoPaterno;

    @Column(name="apellido_materno")
    private String apellidoMaterno;

    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name="email")
    private String email;

    @Column(name="telefono")
    private String telefono;

    @Column(name="contraseña")
    private String contraseña;

    @Column(name="id_ciudad")
    private long idCiudad;

    @Column(name="colonia")
    private String colonia;

    @Column(name="domicilio")
    private String domicilio;

    @Column(name="cp")
    private String cp;
}
