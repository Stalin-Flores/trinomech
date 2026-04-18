package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.bean.entity.Entrada;
import com.example.demo.model.EntradaService;

@RestController
@RequestMapping("/api/entradas")
@CrossOrigin("*")
public class EntradaController {

    @Autowired
    private EntradaService service;

    @PostMapping
    public Entrada registrar(@RequestBody Entrada entrada) {
        return service.registrarEntrada(entrada);
    }
}
