package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.entity.Salida;

public interface SalidaRepository extends JpaRepository<Salida, Integer> {

}
