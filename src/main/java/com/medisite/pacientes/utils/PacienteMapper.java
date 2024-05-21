package com.medisite.pacientes.utils;
import com.medisite.pacientes.repository.entity.PacienteEntity;
import com.medisite.pacientes.model.Paciente;

public class PacienteMapper {
    public static Paciente PacienteEntityToPaciente(PacienteEntity paciente_entity){
        Paciente paciente = new Paciente(paciente_entity.getIdPaciente(),
                paciente_entity.getNombre(),
                paciente_entity.getApellidoPaterno(),
                paciente_entity.getApellidoMaterno(),
                paciente_entity.getFechaNacimiento(),
                paciente_entity.getEmail(),
                paciente_entity.getTelefono(),
                paciente_entity.getIdCiudad(),
                paciente_entity.getColonia(),
                paciente_entity.getDomicilio(),
                paciente_entity.getCp()
                );
        return paciente;
    }
}
