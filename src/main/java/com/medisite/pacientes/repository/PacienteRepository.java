package com.medisite.pacientes.repository;


import com.medisite.pacientes.repository.entity.PacienteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PacienteRepository extends CrudRepository<PacienteEntity, Long> {
    public Optional<PacienteEntity> findByEmail(String email);
}
