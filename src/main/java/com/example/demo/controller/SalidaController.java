package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.bean.entity.Salida;
import com.example.demo.usecase.SalidaUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/salidas")
@CrossOrigin("*")
public class SalidaController {

    private final SalidaUseCase service;

    @PostMapping
    public Salida registrar(@RequestBody Salida salida) {
        return service.registrarSalida(salida);
    }
}
