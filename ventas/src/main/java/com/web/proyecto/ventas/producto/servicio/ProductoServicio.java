package com.web.proyecto.ventas.producto.servicio;

import java.util.ArrayList;
import java.util.Optional;

import com.web.proyecto.ventas.producto.clases.Producto;

public interface ProductoServicio {
     ArrayList<Producto> listaProducto();
     boolean eliminarProducto(String id_producto);
    Producto buscarProducto(String id_producto);
    boolean agregarProducto(Producto producto);
}
