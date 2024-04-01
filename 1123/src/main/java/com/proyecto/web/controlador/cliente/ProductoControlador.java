package com.proyecto.web.controlador.cliente;

import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.productos.clases.Producto;
import com.proyecto.web.productos.implement.ProductoImplement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController // La anotación @RestController debe estar en la clase
@RequestMapping("/controlador/usuario") // Esto especifica la ruta base para todas las solicitudes manejadas por este controlador
public class ProductoControlador {

    @Autowired 
    private ProductoImplement productoImplement; // Asumiendo que ProductoImplement es una clase válida para obtener los productos

    @GetMapping("/producto") // Esto especifica la ruta para las solicitudes GET a /controlador/usuario/producto
    public ArrayList<Producto> listaProducto() {
        ArrayList<Producto> listaProducto = (ArrayList<Producto>) productoImplement.listaProducto(); // Asumiendo que listaProducto() retorna una lista de Producto
        return  listaProducto;
    }
}
