package com.web.proyecto.ventas.controlador.administrador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.proyecto.ventas.usuarios.clases.Usuario;
import com.web.proyecto.ventas.usuarios.clases.UsuarioSaldo;
import com.web.proyecto.ventas.usuarios.implemento.GeneradorCodigos;
import com.web.proyecto.ventas.usuarios.implemento.UsuarioImplemento;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/administrador/usuario")

@CrossOrigin("http://localhost:3000")
public class AdministradorUsuarioControlador {
    
    @Autowired
    private UsuarioImplemento usuarioImplemento;



    @GetMapping("/listar")
    public ArrayList<Usuario> listaUsuario(){
        ArrayList<Usuario> listaUsuario = usuarioImplemento.listaUsuario();
        return listaUsuario;
    }
    @GetMapping("/buscar/{id_usuario}")
    public Map<String,Object> buscarUsuario(@PathVariable String id_usuario) {
        Map<String,Object> response = new HashMap<>();        
        Usuario user = usuarioImplemento.buscarUsuario(id_usuario);  
        if(user != null){
            response.put("user", user);
            response.put("menssage", "El usuario si existe");
        }else{
            response.put("user", user);
            response.put("menssage", "El usuario no existe");
        }        
        return  response;
    }
    @GetMapping("/eliminar/{id_usuario}")
    public boolean eliminarUsuario(@PathVariable String id_usuario) {
        boolean respuestaUsuario = usuarioImplemento.eliminarUsuario(id_usuario);
        if(respuestaUsuario){
            return true;
        }else{
            return false;
        }
      
    }

    @GetMapping("/agregar/usuario")
    public boolean agregarUsuario() {
        //consutla correcta agregar @Param en la funcion para hacer consulta
        GeneradorCodigos gen = new GeneradorCodigos();        
        String id_usuario = gen.GeneradorDeCodigoUsuarios();

        Usuario user = new Usuario();
        user.setId_usuario(id_usuario);
        user.setId_documento(1);
        user.setNumero_doc(id_usuario);
        user.setNombre("");
        user.setPrimer_apellido("");
        user.setSegundo_apellido("");
        user.setTelefono("TPRUEBA");
        user.setCorreo(gen.GeneradorDeCodigoUsuarios());
        user.setContrasena_usuario("");
        user.setId_genero(1);
        user.setFecha_nacimiento("12-12-12");
        user.setId_rol(1);
        user.setId_membresia(1);
        user.setFecha_registro("");
        user.setHora_registro("");
        user.setId_estado_usuario(1);
        //
        // UsuarioSaldo userSaldo = new UsuarioSaldo();
        // userSaldo.setId_usuario(id_usuario);
        // userSaldo.setSaldo_usuario(458.0);
        // userSaldo.setId_moneda(1);
        System.out.println("resultado" + user);
        usuarioImplemento.agregarUsuario(user);
        return true;
    }
    
}
