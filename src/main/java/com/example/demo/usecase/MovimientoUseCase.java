package com.example.demo.usecase;

import java.util.List;

import com.example.demo.bean.entity.Movimiento;

public interface MovimientoUseCase {
    public List<Movimiento> Listar();

    public Movimiento guardar(Movimiento movimiento);

    public Movimiento obtenerPorId(Integer id);

    public void eliminar(Integer id);
}
