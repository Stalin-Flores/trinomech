package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.entity.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
}