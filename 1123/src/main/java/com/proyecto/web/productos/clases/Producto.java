package com.proyecto.web.productos.clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="producto")
public class Producto {
    @Id
    private String id_producto;
    private String codigo_barras;
    private String nombre_producto;
    private String descripcion;
    private int cantidad_stock;
    private float precio_unit;
    private int id_genero;
    private String url_img;
    private LocalDate fecha_creacion;
    private LocalTime hora_creacion;
    private String id_estado_general;
}
