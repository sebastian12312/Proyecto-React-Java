package com.web.proyecto.ventas.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.proyecto.ventas.usuarios.clases.UsuarioSaldo;

@Repository
public interface UsuarioSaldoRepositorio extends JpaRepository<UsuarioSaldo,String>{

    
    
}
