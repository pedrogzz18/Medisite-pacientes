package com.medisite.pacientes.service;

import com.medisite.pacientes.repository.entity.PacienteEntity;
import com.medisite.pacientes.model.Paciente;

public interface PacienteService {

    public Paciente createPaciente(PacienteEntity paciente);

    public void deletePaciente(long id_paciente);

    public Paciente updatePaciente(PacienteEntity paciente);

    public Paciente getPacienteById(long id_paciente);
}
