package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.entity.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
}
