package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.entity.Material;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
}