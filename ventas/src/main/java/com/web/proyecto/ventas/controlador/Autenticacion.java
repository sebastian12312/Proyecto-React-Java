package com.web.proyecto.ventas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.proyecto.ventas.usuarios.clases.Usuario;
import com.web.proyecto.ventas.usuarios.implemento.UsuarioImplemento;




@RestController
@RequestMapping("/autenticacion")
public class Autenticacion {
    
    @Autowired
    private UsuarioImplemento usuarioImplemento;
    @GetMapping("/login")
    public boolean validacionLogin(@RequestParam String numero_doc, @RequestParam String contrasena_usuario){
        System.out.println("respueta:"+numero_doc +contrasena_usuario);
        Usuario respuesta = usuarioImplemento.autenticacioUsuario(numero_doc, contrasena_usuario);
        if(respuesta != null){
            return true;
        }else{
            return false;
        }
        
    }
}
