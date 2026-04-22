package com.example.demo.bean.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "materiales", schema = "public")
public class Material {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material")
    private Integer idMaterial;

    @Column(name = "nombre_material")
    private String nombreMaterial;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    @Column(name = "stock_minimo")
    private Integer stockMinimo;

    @Column(name = "stock_actual")
    private Integer stockActual;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "proveedor")
    private String proveedor;

    @Column(name = "costo_unitario")
    private Double costoUnitario;

}

