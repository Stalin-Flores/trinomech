package com.example.demo.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component // 👈 SUFICIENTE
public class JwtFilter implements Filter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI();

        // 🔓 PERMITIR LOGIN SIN TOKEN
        if (path.contains("/api/auth")) {
            chain.doFilter(request, response);
            return;
        }

        String authHeader = req.getHeader("Authorization");

        // 🔐 VALIDAR TOKEN
        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            try {
                String username = jwtUtil.extractUsername(token);
                String rol = jwtUtil.extractRol(token);

                System.out.println("Usuario: " + username + " | Rol: " + rol);

                // 🔥 VALIDACIÓN DE ROL (EJEMPLO)
                if (req.getMethod().equals("POST") && !"ADMIN".equals(rol)) {
                    res.sendError(403, "No autorizado");
                    return;
                }

            } catch (Exception e) {
                res.sendError(401, "Token inválido");
                return;
            }

        } else {
            res.sendError(401, "Token requerido");
            return;
        }

        chain.doFilter(request, response);
    }
}