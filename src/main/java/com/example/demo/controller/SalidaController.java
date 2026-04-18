package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.bean.entity.Salida;
import com.example.demo.model.SalidaService;

@RestController
@RequestMapping("/api/salidas")
@CrossOrigin("*")
public class SalidaController {

    @Autowired
    private SalidaService service;

    @PostMapping
    public Salida registrar(@RequestBody Salida salida) {
        return service.registrarSalida(salida);
    }
}
