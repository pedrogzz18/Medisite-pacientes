package com.medisite.pacientes.repository;


import com.medisite.pacientes.repository.entity.PacienteEntity;
import com.medisite.pacientes.model.Paciente;

public interface PacienteRepository{
    public PacienteEntity createPaciente(PacienteEntity paciente);

    public void deletePaciente(long id_paciente);

    public PacienteEntity updatePaciente(PacienteEntity paciente);

    public PacienteEntity getPacienteById(long id_paciente);
}
