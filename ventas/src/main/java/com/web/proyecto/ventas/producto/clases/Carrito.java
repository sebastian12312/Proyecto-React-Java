package com.web.proyecto.ventas.producto.clases;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Carrito {
    @Id
    private String id_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private double precio_producto;
    private int cantidad_compra;
    private double subTotal;
    private String img_url;
}
