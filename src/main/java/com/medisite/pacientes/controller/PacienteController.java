package com.medisite.pacientes.controller;

import com.medisite.pacientes.repository.entity.PacienteEntity;
import org.springframework.web.bind.annotation.*;
import com.medisite.pacientes.DTO.PacienteDTO;

@RequestMapping("/pacientes")
public interface PacienteController {
    @PostMapping("/create-paciente")
    public PacienteDTO createPaciente(@RequestBody PacienteEntity paciente);

    @PutMapping("/update-paciente/{id_paciente}")
    public PacienteDTO updatePaciente(@RequestBody PacienteEntity paciente, @PathVariable long id_paciente);

    @DeleteMapping("/delete-paciente/{id_paciente}")
    public void deletePaciente(@PathVariable long id_paciente);

    @GetMapping("/get-paciente/{id_paciente}")
    public PacienteDTO getPacienteById(@PathVariable long id_paciente);
}
