package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ModeloProducto;
import com.example.demo.repositories.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    
    public ArrayList<ModeloProducto> obtenerProductos(){
        return (ArrayList<ModeloProducto>) productoRepository.findAll();
    }

    public ModeloProducto guardarProducto(ModeloProducto producto){
        return productoRepository.save(producto);
    }

    public Optional<ModeloProducto> obtenerProductoPorId(Long id){
        return productoRepository.findById(id);
    }

    public boolean cambiarEstadoProducto(Long id, int status) {
        Optional<ModeloProducto> optionalProducto = productoRepository.findById(id);
        if (optionalProducto.isPresent()) {
            ModeloProducto producto = optionalProducto.get();
            producto.setEstatus(status);
            productoRepository.save(producto);
            return true;
        } else {
            return false;
        }
    }

    public ResponseEntity<Object> restarCantidadProducto(Long id, int cantidadARestar) {
        if (cantidadARestar < 0) {
            String mensaje = "La cantidad a restar no puede ser negativa";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"" + mensaje + "\", \"status\": \"bad_request\"}");
        }
    
        Optional<ModeloProducto> optionalProducto = productoRepository.findById(id);
        if (optionalProducto.isPresent()) {
            ModeloProducto producto = optionalProducto.get();
            int cantidadActual = producto.getCantidad();
            if (cantidadARestar <= cantidadActual) {
                int nuevaCantidad = cantidadActual - cantidadARestar;
                producto.setCantidad(nuevaCantidad);
                productoRepository.save(producto);
                String mensaje = "Se restó " + cantidadARestar + " unidades al producto con ID: " + id + ". Cantidad actualizada: " + nuevaCantidad;
                if (nuevaCantidad == 0) {
                    producto.setEstatus(0); // Cambiar a inactivo
                    productoRepository.save(producto);
                    mensaje += " y se cambió su estado a inactivo";
                }
                return ResponseEntity.ok().body("{\"message\": \"" + mensaje + "\", \"status\": \"ok\"}");
            } else {
                String mensaje = "No se puede restar una cantidad mayor de la que está en inventario. Cantidad actual: " + cantidadActual;
                return ResponseEntity.ok().body("{\"message\": \"" + mensaje + "\", \"status\": \"false\"}");
            }
        } else {
            String mensaje = "El producto con ID: " + id + " no fue encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"" + mensaje + "\", \"status\": \"not_found\"}");
        }
    }
    
    
}
