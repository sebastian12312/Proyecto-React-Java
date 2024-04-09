package com.web.proyecto.ventas.producto.implemento;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.web.proyecto.ventas.producto.clases.Carrito;
import com.web.proyecto.ventas.producto.clases.Producto;
import com.web.proyecto.ventas.producto.repositorio.ProductoRepositorio;
import com.web.proyecto.ventas.producto.servicio.ProductoServicio;

import jakarta.annotation.PostConstruct;

@Service
public class ProductoImplemento implements ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepository;

    // lista producto
    @Override
    public ArrayList<Producto> listaProducto() {
        ArrayList<Producto> listaProducto = (ArrayList<Producto>) productoRepository.findAll();
        return listaProducto;
    }

    @Override
    public Producto buscarProducto(String id_producto) {
        Producto producto = new Producto();
        if (productoRepository.existsById(id_producto)) {
            Optional<Producto> prod = productoRepository.findById(id_producto);
            if (prod.isPresent()) {
                System.out.println(prod.get());
                return prod.get();
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    @Override
    public boolean eliminarProducto(String id_producto) {
        boolean validacion = productoRepository.existsById(id_producto);
        if (validacion == true) {
            productoRepository.deleteById(id_producto);
            if (productoRepository.existsById(id_producto) == true) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    @Override
    public boolean agregarProducto(Producto producto) {

       try {
        if (productoRepository.existsById(producto.getId_producto()) == true) {
            return false;
        } else {
            productoRepository.save(producto);
            if (productoRepository.existsById(producto.getId_producto())) {
                return true;
            } else {
                return false;
            }
        }
       } catch (DataAccessException e) {
            System.out.println(e);
           return false;
       }

    }

    @Override
    public ArrayList<Carrito> agregarCarrito(String id_producto) {
        Optional<Producto> prodOptional = productoRepository.findById(id_producto);
    
        if (prodOptional.isPresent()) {
            Producto producto = prodOptional.get();
            int cantidad = 1;
            ArrayList<Carrito> listaCarritos = new ArrayList<>();
            boolean productoYaEnCarrito = false;
    
            // Verificar si el producto ya está en la lista de carritos
            for (Carrito carrito : listaCarritos) {
                if (carrito.getId_producto().equals(producto.getId_producto())) {
                    carrito.setCantidad_compra(carrito.getCantidad_compra() + 1);
                    carrito.setSubTotal(carrito.getCantidad_compra() * carrito.getPrecio_producto());
                    productoYaEnCarrito = true;
                    break;
                }
            }
    
            // Si el producto no está en la lista de carritos, agregarlo como nuevo carrito
            if (!productoYaEnCarrito) {
                Carrito cart = new Carrito();
                cart.setId_producto(producto.getId_producto());
                cart.setNombre_producto(producto.getNombre_producto());
                cart.setDescripcion_producto(producto.getDescripcion());
                cart.setPrecio_producto(producto.getPrecio_unit());
                cart.setCantidad_compra(cantidad);
                cart.setSubTotal(cantidad * producto.getPrecio_unit());
                cart.setImg_url(producto.getUrl_img());
                listaCarritos.add(cart);
            }
    
            System.out.println("Cantidad de carritos: " + listaCarritos.size());
    
            return listaCarritos;
        } else {
            System.out.println("No se encontró ningún producto con el ID proporcionado: " + id_producto);
            return new ArrayList<>(); // Devuelve una lista vacía si no se encuentra ningún producto
        }
    }
}    