package com.example.demo.bean.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "movimientos", schema = "public")
public class Movimiento {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer idMovimiento;

    @ManyToOne
    @JoinColumn(name = "id_material")
    private Material material;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;
    
    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "stock_resultante")
    private Integer stockResultante;

    @Column(name = "observaciones")
    private String observaciones;

}