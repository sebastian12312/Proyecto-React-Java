package com.web.proyecto.ventas.controlador.cliente;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.proyecto.ventas.producto.clases.Producto;
import com.web.proyecto.ventas.producto.implemento.ProductoImplemento;


@RequestMapping("/controlador/producto")
@RestController

public class ClienteControladorProducto {
        @Autowired 
    private ProductoImplemento productoImplement; // Asumiendo que ProductoImplement es una clase válida para obtener los productos

    @GetMapping("/listar") // Esto especifica la ruta para las solicitudes GET a /controlador/usuario/producto
    public ArrayList<Producto> listaProducto() {
        ArrayList<Producto> listaProducto = (ArrayList) productoImplement.listaProducto(); // Asumiendo que listaProducto() retorna una lista de Producto
        return  listaProducto;
    }
}
