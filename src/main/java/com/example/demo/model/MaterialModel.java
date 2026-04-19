package com.example.demo.model;

import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.bean.entity.Material;
import com.example.demo.persistence.MaterialRepository;
import com.example.demo.usecase.MaterialUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MaterialModel implements MaterialUseCase {

    private final MaterialRepository repository;


    @Override
    public List<Material> listar() {
        return repository.findAll();
    }

    @Override
    public Material guardar(Material material) {
        return repository.save(material);
    }

    @Override
    public Material obtenerPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material no encontrado"));
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}