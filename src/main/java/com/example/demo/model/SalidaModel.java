package com.example.demo.model;

import org.springframework.stereotype.Service;

import com.example.demo.bean.entity.Material;
import com.example.demo.bean.entity.Movimiento;
import com.example.demo.bean.entity.Salida;
import com.example.demo.persistence.MaterialRepository;
import com.example.demo.persistence.MovimientoRepository;
import com.example.demo.persistence.SalidaRepository;
import com.example.demo.usecase.SalidaUseCase;

import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class SalidaModel implements SalidaUseCase {

    private final SalidaRepository salidaRepository;

    private final MaterialRepository materialRepository;

    private final  MovimientoRepository movimientoRepository;
    
    @Transactional
    public Salida registrarSalida(Salida salida) {

        // 1. Obtener material desde BD
        Material material = materialRepository
                .findById(salida.getMaterial().getIdMaterial())
                .orElseThrow(() -> new RuntimeException("Material no encontrado"));

        // 2. Validación de stock
        if (material.getStockActual() < salida.getCantidad()) {
            throw new RuntimeException("Stock insuficiente");
        }

        // 3. Reducir stock
        material.setStockActual(material.getStockActual() - salida.getCantidad());

        // 4. Guardar material actualizado
        materialRepository.save(material);

        // 5. Asignar material completo
        salida.setMaterial(material);

        // 6. Guardar salida
        Salida salidaGuardada = salidaRepository.save(salida);

        // 7. CREAR MOVIMIENTO
        Movimiento mov = new Movimiento();
        mov.setMaterial(material);
        mov.setFecha(LocalDateTime.now());
        mov.setTipoMovimiento("Salida");
        mov.setCantidad(salida.getCantidad());
        mov.setStockResultante(material.getStockActual());
        mov.setObservaciones(salida.getObservaciones());

        movimientoRepository.save(mov);

        return salidaGuardada;
    }
}