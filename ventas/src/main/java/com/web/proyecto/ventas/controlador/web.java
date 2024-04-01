package com.web.proyecto.ventas.controlador;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.proyecto.ventas.producto.clases.Producto;
import com.web.proyecto.ventas.producto.implemento.ProductoImplemento;

@Controller
public class web {
    @Autowired 
    @GetMapping("/")
    public String web(){
       System.out.println("resultado");
        return "index";
    }
      
        
    
}
