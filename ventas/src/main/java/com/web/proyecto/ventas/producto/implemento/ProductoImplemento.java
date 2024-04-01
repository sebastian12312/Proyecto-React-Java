package com.web.proyecto.ventas.producto.implemento;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.web.proyecto.ventas.producto.clases.Producto;
import com.web.proyecto.ventas.producto.repositorio.ProductoRepositorio;
import com.web.proyecto.ventas.producto.servicio.ProductoServicio;

import jakarta.annotation.PostConstruct;

@Service
public class ProductoImplemento implements ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepository;

    // lista producto
    @Override
    public ArrayList<Producto> listaProducto() {
        ArrayList<Producto> listaProducto = (ArrayList<Producto>) productoRepository.findAll();
        return listaProducto;
    }

    @Override
    public Producto buscarProducto(String id_producto) {
        Producto producto = new Producto();
        if (productoRepository.existsById(id_producto)) {
            Optional<Producto> prod = productoRepository.findById(id_producto);
            if (prod.isPresent()) {
                System.out.println(prod.get());
                return prod.get();
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    @Override
    public boolean eliminarProducto(String id_producto) {
        boolean validacion = productoRepository.existsById(id_producto);
        if (validacion == true) {
            productoRepository.deleteById(id_producto);
            if (productoRepository.existsById(id_producto) == true) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    @Override
    public boolean agregarProducto(Producto producto) {

       try {
        if (productoRepository.existsById(producto.getId_producto()) == true) {
            return false;
        } else {
            productoRepository.save(producto);
            if (productoRepository.existsById(producto.getId_producto())) {
                return true;
            } else {
                return false;
            }
        }
       } catch (DataAccessException e) {
            System.out.println(e);
           return false;
       }

    }
}
