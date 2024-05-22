package com.medisite.pacientes.service;

import com.medisite.pacientes.DTO.LoginResponse;
import com.medisite.pacientes.DTO.PacienteDTO;
import com.medisite.pacientes.DTO.PacienteLoginDTO;
import com.medisite.pacientes.repository.entity.PacienteEntity;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    public ResponseEntity<PacienteDTO> signup(PacienteEntity pacienteEntity);

    public ResponseEntity<LoginResponse> login(PacienteLoginDTO pacienteLoginDTO);

}
