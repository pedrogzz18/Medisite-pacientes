package com.medisite.pacientes.service.Impl;

import com.medisite.pacientes.DTO.LoginResponse;
import com.medisite.pacientes.DTO.PacienteDTO;
import com.medisite.pacientes.DTO.PacienteLoginDTO;
import com.medisite.pacientes.repository.PacienteRepository;
import com.medisite.pacientes.repository.entity.PacienteEntity;
import com.medisite.pacientes.service.AuthenticationService;
import com.medisite.pacientes.service.JwtService;
import com.medisite.pacientes.service.PacienteService;
import com.medisite.pacientes.utils.PacienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;
    @Override
    public ResponseEntity<PacienteDTO> signup(PacienteEntity pacienteEntity){
        pacienteEntity.setContraseña(passwordEncoder.encode(pacienteEntity.getContraseña()));
        return ResponseEntity.ok(pacienteService.createPaciente(pacienteEntity));
    }

    @Override
    public ResponseEntity<LoginResponse> login(PacienteLoginDTO pacienteLoginDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                pacienteLoginDTO.getEmail(), pacienteLoginDTO.getPassword()));
        PacienteDTO pacienteDTO = PacienteMapper.PacienteEntityToPaciente(pacienteRepository.findByEmail(pacienteLoginDTO.getEmail()).get());
        String jwtToken = jwtService.generateToken(pacienteLoginDTO.getEmail(), "paciente", pacienteDTO.getIdPaciente());
        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getJwtExpiration(), pacienteDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
