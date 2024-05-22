package com.medisite.pacientes.service;

import com.medisite.pacientes.repository.PacienteRepository;
import com.medisite.pacientes.repository.entity.PacienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class PacienteDetailService implements UserDetailsService {

    @Autowired
    private PacienteRepository pacienteRepository;

    private PacienteEntity pacienteDetails;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        pacienteDetails = pacienteRepository.findByEmail(username).get();
        if(!Objects.isNull(pacienteDetails)){
            return new User(pacienteDetails.getEmail(), pacienteDetails.getContraseña(), new ArrayList<>());
        } else{
            throw new UsernameNotFoundException("Paciente no encontrado");
        }
    }

    public PacienteEntity getPacienteDetails(){
        return pacienteDetails;
    }
}
