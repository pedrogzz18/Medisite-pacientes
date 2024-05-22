package com.medisite.pacientes.service.Impl;

import com.medisite.pacientes.repository.entity.PacienteEntity;
import com.medisite.pacientes.utils.PacienteMapper;
import com.medisite.pacientes.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import com.medisite.pacientes.repository.PacienteRepository;
import com.medisite.pacientes.service.PacienteService;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;
    public Paciente createPaciente(PacienteEntity paciente){
        return PacienteMapper.PacienteEntityToPaciente(pacienteRepository.save(paciente));
    }

    public void deletePaciente(long id_paciente){
        pacienteRepository.deleteById(id_paciente);
    }

    public Paciente updatePaciente(PacienteEntity paciente){

        return PacienteMapper.PacienteEntityToPaciente(pacienteRepository.save(paciente));
    }

    public Paciente getPacienteById(long id_paciente){

        return PacienteMapper.PacienteEntityToPaciente(pacienteRepository.findById(id_paciente).get());
    }
}
