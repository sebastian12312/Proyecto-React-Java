package com.web.proyecto.ventas.controlador.administrador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.proyecto.ventas.producto.clases.Carrito;
import com.web.proyecto.ventas.producto.clases.Producto;
import com.web.proyecto.ventas.producto.implemento.ProductoImplemento;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/administrador/controlador/producto")
@CrossOrigin(origins ="http://localhost:3000")
public class AdministradorProductosControlador {
    @Autowired
    private ProductoImplemento productoImplement;

    
    @GetMapping("/listar")
    public ArrayList<Producto> listaProducto() {
        ArrayList<Producto> listaProducto = (ArrayList) productoImplement.listaProducto();
        return listaProducto;
    }

    @GetMapping("/buscar/{id_producto}")
    public Map<String, Object> buscarProducto(@PathVariable String id_producto) {
        Map<String, Object> response = new HashMap<>();
        Producto producto = productoImplement.buscarProducto(id_producto);
        if (producto.getId_producto().isEmpty()) {
            response.put("message", "Producto Encontrado!");
            response.put("producto", producto);
            return response;
        } else {
            response.put("message", "El producto no se pudo Encontrar!");
            response.put("producto", producto);
            return response;
        }

    }

    @GetMapping("/eliminar/{id_producto}")
    public String eliminarProducto(@PathVariable String id_producto) {
        boolean respuestaProducto = productoImplement.eliminarProducto(id_producto);
        if (respuestaProducto == true) {
            return "ok";
        } else {
            return "error";
        }
    }

    @PostMapping("/agregar/producto/{id_producto}")
    public boolean agregarProducto(@PathVariable String id_producto) {
        boolean response;
        Producto producto = new Producto();
        // para poder agregar a traves de post se puede con un RequestParam desde un formulario
        producto.setId_producto(id_producto);
        producto.setCodigo_barras("");
        producto.setNombre_producto("");
        producto.setCantidad_stock(0);
        producto.setPrecio_unit(0);
        producto.setId_genero(0);
        producto.setUrl_img("");
        producto.setFecha_creacion("");
        producto.setHora_creacion("");
        producto.setId_estado_general(0);
        boolean respuestaProducto = productoImplement.agregarProducto(producto);
        if (respuestaProducto) {
            response = true;
        } else {
            response = false;
        }
        return response;
    }

    @GetMapping("/agregar/carrito/{id_producto}")
    public  ArrayList<Carrito> agregarCarrito(@PathVariable String id_producto) {

        ArrayList<Carrito> listaCarrito = productoImplement.agregarCarrito(id_producto);
       System.out.println("cantidad total++++ " +  listaCarrito.size() + listaCarrito);
        return listaCarrito;
    }
    
}
