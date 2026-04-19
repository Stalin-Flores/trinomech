package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.demo.bean.entity.Movimiento;
import com.example.demo.persistence.MovimientoRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movimientos")
@CrossOrigin("*")
public class MovimientoController {

    private final MovimientoRepository repository;

    @GetMapping
    public List<Movimiento> listar() {
        return repository.findAll();
    }
}
