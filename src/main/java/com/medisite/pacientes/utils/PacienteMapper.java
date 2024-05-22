package com.medisite.pacientes.utils;
import com.medisite.pacientes.repository.entity.PacienteEntity;
import com.medisite.pacientes.DTO.PacienteDTO;

public class PacienteMapper {
    public static PacienteDTO PacienteEntityToPaciente(PacienteEntity paciente_entity){
        PacienteDTO pacienteDTO = new PacienteDTO(paciente_entity.getIdPaciente(),
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
        return pacienteDTO;
    }
}
