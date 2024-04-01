package com.web.proyecto.ventas.producto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.proyecto.ventas.producto.clases.Producto;

@Repository
public interface ProductoRepositorio   extends JpaRepository<Producto, String>{
    
}
