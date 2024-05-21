package com.medisite.pacientes.repository.impl;

import com.medisite.pacientes.repository.entity.PacienteEntity;
import jakarta.persistence.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.medisite.pacientes.model.Paciente;
import com.medisite.pacientes.repository.PacienteRepository;

@Repository
public class PacienteRepositoryImpl implements PacienteRepository {

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public PacienteEntity createPaciente(PacienteEntity paciente){
        em.persist(paciente);
        return paciente;
    }

    @Override
    public PacienteEntity getPacienteById(long id_paciente){
        return em.find(PacienteEntity.class, id_paciente);
    }

    @Override
    public void deletePaciente(long id_paciente){
        em.remove(getPacienteById(id_paciente));
    }

    @Transactional
    public PacienteEntity updatePaciente(PacienteEntity paciente){
        return em.merge(paciente);
    }

}
