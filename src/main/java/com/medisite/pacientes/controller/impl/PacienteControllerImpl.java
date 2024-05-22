package com.medisite.pacientes.controller.impl;

import com.medisite.pacientes.repository.entity.PacienteEntity;
import com.medisite.pacientes.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.medisite.pacientes.service.PacienteService;
import com.medisite.pacientes.controller.PacienteController;

@RestController
public class PacienteControllerImpl implements PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private JwtService jwtService;

    @Override
    public ResponseEntity<?> createPaciente(HttpServletRequest request, @RequestBody PacienteEntity paciente){
        String token = request.getHeader("Authorization").substring(7);
        if(jwtService.isAdmin(token)) {
            return ResponseEntity.ok(pacienteService.createPaciente(paciente));
        }
        return ResponseEntity.status(403).body("Not authorized");
    }

    @Override
    public ResponseEntity<?> updatePaciente(HttpServletRequest request, @RequestBody PacienteEntity paciente, @PathVariable long id_paciente){
        String token = request.getHeader("Authorization").substring(7);
        if((jwtService.isPaciente(token) && jwtService.validateIdInToken(token, id_paciente)) ||
                jwtService.isAdmin(token)) {
            paciente.setIdPaciente(id_paciente);
            return ResponseEntity.ok(pacienteService.updatePaciente(paciente));
        }
        return ResponseEntity.status(403).body("not authorized");
    }

    @Override
    public ResponseEntity<?> deletePaciente(HttpServletRequest request, @PathVariable long id_paciente){
        String token = request.getHeader("Authorization").substring(7);
        if((jwtService.isPaciente(token) && jwtService.validateIdInToken(token, id_paciente)) ||
                jwtService.isAdmin(token)) {
            pacienteService.deletePaciente(id_paciente);
            return ResponseEntity.ok().body("Paciente eliminado");
        }
        return ResponseEntity.status(403).body("not authorized");
    }

    @Override
    public ResponseEntity<?> getPacienteById(HttpServletRequest request, @PathVariable long id_paciente){
        String token = request.getHeader("Authorization").substring(7);
        if((jwtService.isPaciente(token) && jwtService.validateIdInToken(token, id_paciente)) ||
                jwtService.isAdmin(token) ||
                jwtService.isMedico(token)) {
            return ResponseEntity.ok().body(pacienteService.getPacienteById(id_paciente));
        }
        return ResponseEntity.status(403).body("not authorized");
    }
}
