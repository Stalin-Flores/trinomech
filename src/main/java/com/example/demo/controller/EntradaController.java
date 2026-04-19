package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.bean.entity.Entrada;
import com.example.demo.model.EntradaModel;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/entradas")
@CrossOrigin("*")
public class EntradaController {

    private final EntradaModel service;

    @PostMapping
    public Entrada registrar(@RequestBody Entrada entrada) {
        return service.registrarEntrada(entrada);
    }
}
