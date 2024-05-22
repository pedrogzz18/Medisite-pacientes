package com.medisite.pacientes.controller.impl;

import com.medisite.pacientes.DTO.LoginResponse;
import com.medisite.pacientes.DTO.PacienteDTO;
import com.medisite.pacientes.DTO.PacienteLoginDTO;
import com.medisite.pacientes.controller.AuthController;
import com.medisite.pacientes.repository.entity.PacienteEntity;
import com.medisite.pacientes.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl implements AuthController {
    @Autowired
    private AuthenticationService authenticationService;
    @Override
    public ResponseEntity<PacienteDTO> signup(@RequestBody PacienteEntity paciente){
        return authenticationService.signup(paciente);
    }

    @Override
    public ResponseEntity<LoginResponse> login(@RequestBody PacienteLoginDTO pacienteLoginDTO){
        return authenticationService.login(pacienteLoginDTO);
    }
}
