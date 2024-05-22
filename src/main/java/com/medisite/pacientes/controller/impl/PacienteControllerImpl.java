package com.medisite.pacientes.controller.impl;

import com.medisite.pacientes.repository.entity.PacienteEntity;
import com.medisite.pacientes.model.Paciente;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.medisite.pacientes.service.PacienteService;
import com.medisite.pacientes.controller.PacienteController;

@RestController
public class PacienteControllerImpl implements PacienteController {
    @Autowired
    PacienteService pacienteService;

    @Override
    public Paciente createPaciente(@RequestBody PacienteEntity paciente){
        return pacienteService.createPaciente(paciente);
    }

    @Override
    public Paciente updatePaciente(@RequestBody PacienteEntity paciente, @PathVariable long id_paciente){
        paciente.setIdPaciente(id_paciente);
        return pacienteService.updatePaciente(paciente);
    }

    @Override
    public void deletePaciente(@PathVariable long id_paciente){
        pacienteService.deletePaciente(id_paciente);
    }

    @Override
    public Paciente getPacienteById(@PathVariable long id_paciente){
        return pacienteService.getPacienteById(id_paciente);
    }
}
