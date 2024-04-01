package com.proyecto.web.productos.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.productos.clases.Producto;
import com.proyecto.web.productos.repository.ProductoRepository;
import com.proyecto.web.productos.service.ProductoService;

import jakarta.annotation.PostConstruct;

@Service
public class ProductoImplement implements  ProductoService {


    @Autowired
    private ProductoRepository productoRepository;
 

       @PostConstruct
    public void init() {
        // Llama al método listaProducto al iniciar la aplicación
        ArrayList<Producto> listaProducto = listaProducto();
        // Imprime la lista de productos
        System.out.println("Lista de productos:");
        for (Producto producto : listaProducto) {
            System.out.println(producto);
        }
    }
    //lista producto
    @Override
    public ArrayList<Producto> listaProducto() {
        ArrayList<Producto> listaProducto = (ArrayList<Producto>) productoRepository.findAll();
        System.out.println(listaProducto);
        return listaProducto;
    }

}
