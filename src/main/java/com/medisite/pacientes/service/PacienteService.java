package com.medisite.pacientes.service;

import com.medisite.pacientes.repository.entity.PacienteEntity;
import com.medisite.pacientes.DTO.PacienteDTO;

public interface PacienteService {

    public PacienteDTO createPaciente(PacienteEntity paciente);

    public void deletePaciente(long id_paciente);

    public PacienteDTO updatePaciente(PacienteEntity paciente);

    public PacienteDTO getPacienteById(long id_paciente);
}
