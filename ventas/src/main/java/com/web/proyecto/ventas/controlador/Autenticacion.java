package com.web.proyecto.ventas.controlador;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.proyecto.ventas.usuarios.clases.Usuario;
import com.web.proyecto.ventas.usuarios.implemento.UsuarioImplemento;




@RestController
@RequestMapping("/autenticacion")
@CrossOrigin(origins ="http://localhost:3000/")

public class Autenticacion {
    
    @Autowired
    private UsuarioImplemento usuarioImplemento;
    @PostMapping("/login")
    public Usuario validacionLogin(@RequestParam String numero_doc, @RequestParam String contrasena_usuario){
        Map<String, Object> response = new HashMap<>();
       
        System.out.println("CREDENCIALES" +numero_doc + contrasena_usuario);
        Usuario respuesta = usuarioImplemento.autenticacioUsuario(numero_doc, contrasena_usuario);
        if(respuesta.getId_usuario() != null || respuesta.getId_usuario() != ""){
            response.put("message","usuario encontrado");
            response.put("usuario", respuesta);
        }else{
            response.put("message","usuario no encontrado");
            response.put("usuario", null);
        }
        System.out.println("respueta:"+numero_doc +contrasena_usuario + respuesta);
        return respuesta;
        
    }
}
