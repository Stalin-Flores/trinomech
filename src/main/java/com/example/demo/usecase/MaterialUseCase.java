package com.example.demo.usecase;

import java.util.List;
import com.example.demo.bean.entity.Material;

public interface MaterialUseCase {

    List<Material> listar();

    Material guardar(Material material);

    Material obtenerPorId(Integer id);

    void eliminar(Integer id);
}