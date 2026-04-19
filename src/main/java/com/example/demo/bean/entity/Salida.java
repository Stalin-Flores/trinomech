package com.example.demo.bean.entity;

import java.time.LocalDate;

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
@Table(name = "salidas")
public class Salida {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salida")
    private Integer idSalida;

    @ManyToOne
    @JoinColumn(name = "id_material")
    private Material material;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "fecha_salida")
    private LocalDate fechaSalida;

    @Column(name = "destino")
    private String destino;

    @Column(name = "observaciones")
    private String observaciones;

}
