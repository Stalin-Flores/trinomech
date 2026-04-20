package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.demo.bean.entity.Movimiento;
import com.example.demo.usecase.MovimientoUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movimientos")
@CrossOrigin("*")
public class MovimientoController {

    private final MovimientoUseCase movimientoUseCase;

    @GetMapping
    public List<Movimiento> Listar() {
        return movimientoUseCase.Listar();
    }
}
