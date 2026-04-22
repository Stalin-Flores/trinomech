package com.example.demo.model;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bean.entity.Movimiento;
import com.example.demo.persistence.MovimientoRepository;
import com.example.demo.usecase.MovimientoUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovimientoModel implements MovimientoUseCase{

	private final MovimientoRepository movimientoRepository;

	@Override
	public List<Movimiento> Listar() {
		return movimientoRepository.findAll();
	}

	@Override
	public Movimiento guardar(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movimiento obtenerPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
