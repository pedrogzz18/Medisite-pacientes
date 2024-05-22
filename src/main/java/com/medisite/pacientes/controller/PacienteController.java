package com.medisite.pacientes.controller;

import com.medisite.pacientes.repository.entity.PacienteEntity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.medisite.pacientes.DTO.PacienteDTO;

@RequestMapping("/pacientes")
public interface PacienteController {
    @PostMapping("/create-paciente")
    public ResponseEntity<?> createPaciente(HttpServletRequest request, @RequestBody PacienteEntity paciente);

    @PutMapping("/update-paciente/{id_paciente}")
    public ResponseEntity<?> updatePaciente(HttpServletRequest request, @RequestBody PacienteEntity paciente, @PathVariable long id_paciente);


    @DeleteMapping("/delete-paciente/{id_paciente}")
    ResponseEntity<?> deletePaciente(HttpServletRequest request, @PathVariable long id_paciente);

    @GetMapping("/get-paciente/{id_paciente}")
    ResponseEntity<?> getPacienteById(HttpServletRequest request, @PathVariable long id_paciente);
}
