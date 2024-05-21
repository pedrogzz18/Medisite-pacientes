package com.medisite.pacientes.model;

import jakarta.persistence.Entity;
import lombok.*;
import java.sql.Date;

@Data
@AllArgsConstructor
public class Paciente {
    private long idPaciente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String email;

    private String telefono;

    private long idCiudad;

    private String colonia;

    private String Domicilio;

    private String cp;
}