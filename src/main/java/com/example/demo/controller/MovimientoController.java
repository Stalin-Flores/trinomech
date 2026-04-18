package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.demo.bean.entity.Movimiento;
import com.example.demo.persistence.MovimientoRepository;

@RestController
@RequestMapping("/api/movimientos")
@CrossOrigin("*")
public class MovimientoController {

    @Autowired
    private MovimientoRepository repository;

    @GetMapping
    public List<Movimiento> listar() {
        return repository.findAll();
    }
}
