package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.bean.entity.Material;
import com.example.demo.model.MaterialService;

@RestController
@RequestMapping("/api/materiales")
@CrossOrigin("*")
public class MaterialController {

    @Autowired
    private MaterialService service;

    @GetMapping
    public List<Material> listar() {
        return service.listar();
    }

    @PostMapping
    public Material guardar(@RequestBody Material material) {
        return service.guardar(material);
    }

    @GetMapping("/{id}")
    public Material obtener(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
