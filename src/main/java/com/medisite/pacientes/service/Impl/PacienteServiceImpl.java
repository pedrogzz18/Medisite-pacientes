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
        return PacienteMapper.PacienteEntityToPaciente(pacienteRepository.createPaciente(paciente));
    }

    public void deletePaciente(long id_paciente){
        pacienteRepository.deletePaciente(id_paciente);
    }

    public Paciente updatePaciente(PacienteEntity paciente){

        return PacienteMapper.PacienteEntityToPaciente(pacienteRepository.updatePaciente(paciente));
    }

    public Paciente getPacienteById(long id_paciente){

        return PacienteMapper.PacienteEntityToPaciente(pacienteRepository.getPacienteById(id_paciente));
    }
}
