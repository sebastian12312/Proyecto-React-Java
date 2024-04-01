package com.web.proyecto.ventas.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.proyecto.ventas.usuarios.clases.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,String>{
        @Query("SELECT u FROM Usuario u WHERE u.numero_doc = :numero_doc and u.contrasena_usuario = :contrasena_usuario")
        Usuario findValidar(@Param("numero_doc") String numero_doc, @Param("contrasena_usuario") String contrasena_usuario);
}
