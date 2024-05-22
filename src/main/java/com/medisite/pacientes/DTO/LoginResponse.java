package com.medisite.pacientes.DTO;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class LoginResponse{
    private String token;
    private long expiresIn;

    private PacienteDTO pacienteDTO;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public PacienteDTO getPacienteDTO() {
        return pacienteDTO;
    }

    public void setPacienteDTO(PacienteDTO pacienteDTO) {
        this.pacienteDTO = pacienteDTO;
    }
}
