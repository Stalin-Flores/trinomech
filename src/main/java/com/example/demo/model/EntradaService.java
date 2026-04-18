package com.example.demo.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.entity.Entrada;
import com.example.demo.bean.entity.Material;
import com.example.demo.bean.entity.Movimiento;
import com.example.demo.persistence.EntradaRepository;
import com.example.demo.persistence.MaterialRepository;
import com.example.demo.persistence.MovimientoRepository;

import java.time.LocalDateTime;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;
    @Transactional
    public Entrada registrarEntrada(Entrada entrada) {
    	System.out.println(">>> LLEGÓ A ENTRADA SERVICE");
        Material material = materialRepository
                .findById(entrada.getMaterial().getIdMaterial())
                .orElseThrow(() -> new RuntimeException("Material no encontrado"));

        material.setStockActual(material.getStockActual() + entrada.getCantidad());

        materialRepository.save(material);

        entrada.setMaterial(material);

        Entrada entradaGuardada = entradaRepository.save(entrada);

        // 🔥 MOVIMIENTO
        Movimiento mov = new Movimiento();
        mov.setMaterial(material);
        mov.setFecha(LocalDateTime.now());
        mov.setTipoMovimiento("Entrada");
        mov.setCantidad(entrada.getCantidad());
        mov.setStockResultante(material.getStockActual());
        mov.setObservaciones(entrada.getObservaciones());
        System.out.println(">>> GUARDANDO MOVIMIENTO");
        movimientoRepository.save(mov);

        return entradaGuardada;
    }
}