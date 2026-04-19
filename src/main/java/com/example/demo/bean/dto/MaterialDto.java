package com.example.demo.bean.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaterialDto {

    private String nombreMaterial;


    private String tipo;


    private String unidadMedida;


    private Integer stockMinimo;


    private Integer stockActual;


    private String ubicacion;


    private String proveedor;


    private Double costoUnitario;
}
