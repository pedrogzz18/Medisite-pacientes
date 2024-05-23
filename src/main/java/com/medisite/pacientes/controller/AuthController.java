package com.medisite.pacientes.controller;

import com.medisite.pacientes.DTO.LoginResponse;
import com.medisite.pacientes.DTO.PacienteDTO;
import com.medisite.pacientes.DTO.PacienteLoginDTO;
import com.medisite.pacientes.repository.entity.PacienteEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pacientes/auth")
public interface AuthController {
    @PostMapping("/signup")
    public ResponseEntity<PacienteDTO> signup(@RequestBody PacienteEntity paciente);

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody PacienteLoginDTO pacienteLoginDTO);
}
