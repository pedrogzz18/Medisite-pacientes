package com.medisite.pacientes.repository;


import com.medisite.pacientes.repository.entity.PacienteEntity;
import com.medisite.pacientes.model.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<PacienteEntity, Long> {
}
