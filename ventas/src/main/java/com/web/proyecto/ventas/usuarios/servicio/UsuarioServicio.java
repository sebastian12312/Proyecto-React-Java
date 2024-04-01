package com.web.proyecto.ventas.usuarios.servicio;

import java.util.ArrayList;

import com.web.proyecto.ventas.usuarios.clases.TipoDocumento;
import com.web.proyecto.ventas.usuarios.clases.Usuario;
import com.web.proyecto.ventas.usuarios.clases.UsuarioSaldo;

public interface UsuarioServicio {
    //
    ArrayList<Usuario> listaUsuario();//
    Usuario buscarUsuario(String id_usuario);//
    boolean eliminarUsuario(String id_usuario);//
    boolean agregarUsuario(Usuario usuario);//
    boolean actualizarUsuario(Usuario usuario);
    Usuario autenticacioUsuario(String numero_doc, String contrasena_usuario);//
    //
    ArrayList<TipoDocumento> listaDocumento();
    boolean eliminarProducto(String id_documento);
    boolean agregarDocumento(TipoDocumento tipoDocumento);
    boolean actualizarDocumento(TipoDocumento tipodocumento);
}
