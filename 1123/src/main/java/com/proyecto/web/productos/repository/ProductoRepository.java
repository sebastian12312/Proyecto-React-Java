package com.proyecto.web.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.web.productos.clases.Producto;

@Repository
public interface ProductoRepository  extends JpaRepository<Producto, String>{
    
    
    
}
