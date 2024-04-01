package com.web.proyecto.ventas.usuarios.implemento;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.web.proyecto.ventas.usuarios.clases.TipoDocumento;
import com.web.proyecto.ventas.usuarios.clases.Usuario;
import com.web.proyecto.ventas.usuarios.clases.UsuarioSaldo;
import com.web.proyecto.ventas.usuarios.repositorio.UsuarioRepositorio;
import com.web.proyecto.ventas.usuarios.repositorio.UsuarioSaldoRepositorio;
import com.web.proyecto.ventas.usuarios.servicio.UsuarioServicio;

@Service
public class UsuarioImplemento implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private UsuarioSaldoRepositorio usuarioSaldoRepositorio;
    @Override
    public ArrayList<Usuario> listaUsuario() {
        ArrayList<Usuario> listaUsuario = (ArrayList<Usuario>) usuarioRepositorio.findAll();
        if (!listaUsuario.isEmpty()) {
            return listaUsuario;
        } else {
            return null;
        }

    }

    @Override
    public Usuario buscarUsuario(String id_usuario) {
        try {
            Optional<Usuario> user = usuarioRepositorio.findById(id_usuario);
            if (user.isPresent()) {
                return user.get();
            } else {
                return null;
            }
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public boolean eliminarUsuario(String id_usuario) {
     try {
        if (usuarioRepositorio.existsById(id_usuario)) {
            usuarioSaldoRepositorio.deleteById(id_usuario);
            usuarioRepositorio.deleteById(id_usuario);          
            return true;
        } else {
            return false;
        }

     } catch (Exception e) {
        return false;
     }
    }

    @Override
    public Usuario autenticacioUsuario(String numero_doc, String contrasena_usuario) {
        Usuario user = usuarioRepositorio.findValidar(numero_doc, contrasena_usuario);
        try {
            if (usuarioRepositorio.existsById(user.getId_usuario())) {
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }

    /// documentos

    @Override
    public boolean agregarUsuario(Usuario usuario) {
        try {
            if(usuarioRepositorio.existsById(usuario.getId_usuario()) == true){
                return false;                
            }else{
                usuarioRepositorio.save(usuario);
                if (usuarioRepositorio.existsById(usuario.getId_usuario()) == true) {
                    UsuarioSaldo usuarioSaldo = new UsuarioSaldo();
                    usuarioSaldo.setId_usuario(usuario.getId_usuario());
                    usuarioSaldo.setSaldo_usuario(0.0);
                    usuarioSaldo.setId_moneda(1);
                    usuarioSaldoRepositorio.save(usuarioSaldo);
                    if(usuarioSaldoRepositorio.existsById(usuarioSaldo.getId_usuario()) == true){
                        return true;
                    }else{
                        usuarioRepositorio.deleteById(usuario.getId_usuario());
                        return false;
                    }              
                } else {
                    return false;
                }
            }           
        } catch (DataAccessException e) {
            return false;
        }
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarUsuario'");
    }

    @Override
    public ArrayList<TipoDocumento> listaDocumento() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listaDocumento'");
    }

    @Override
    public boolean eliminarProducto(String id_documento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarProducto'");
    }

    @Override
    public boolean agregarDocumento(TipoDocumento tipoDocumento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarUsuario'");
    }

    @Override
    public boolean actualizarDocumento(TipoDocumento tipodocumento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarDocumento'");
    }

}
