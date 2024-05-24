package com.medisite.pacientes.configs;

import com.medisite.pacientes.service.JwtService;
import com.medisite.pacientes.service.PacienteDetailService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private PacienteDetailService pacienteDetailService;

    private String username = null;
    private Claims claims = null;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getServletPath().matches("/pacientes/auth/login|/pacientes|/pacientes/auth/signup|(.*\\/swagger-ui\\/.*)|(.*\\/v3\\/.*)")){
            filterChain.doFilter(request, response);
        } else{
            String authorizationHeader = request.getHeader("Authorization");
            String token = null;

            if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
                token = authorizationHeader.substring(7);
                username = jwtService.extractUsername(token);
                claims = jwtService.extractAllClaims(token);
            }

            if(!jwtService.isTokenExpired(token) && (jwtService.isPaciente(token)
                    || jwtService.isAdmin(token)
                    || jwtService.isMedico(token))){
                UserDetails userDetails = new User(claims.getSubject(), "", Collections.emptyList());
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);
        }
    }

    public boolean isPaciente(){
        return "paciente".equals((String) claims.get("role"));
    }

    public boolean isAdmin(){
        return "admin".equals((String) claims.get("role"));
    }

    public String getUsername(){
        return username;
    }
}
