package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.bean.entity.Usuario;
import com.example.demo.persistence.UsuarioRepository;
import com.example.demo.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody Usuario request) {

        Usuario user = usuarioRepository
                .findByNombreUsuario(request.getNombreUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        // Validación simple (luego mejoramos con hash)
        if (!user.getContrasena().equals(request.getContrasena())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        // Generar token
        return jwtUtil.generateToken(user.getNombreUsuario(), user.getRol());
    }
}