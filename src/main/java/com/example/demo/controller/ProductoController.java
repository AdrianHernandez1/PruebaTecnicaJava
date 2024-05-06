package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ModeloProducto;
import com.example.demo.services.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping()
    public ResponseEntity<ArrayList<ModeloProducto>> obtenerProductos() {
        ArrayList<ModeloProducto> productos = productoService.obtenerProductos();
        return ResponseEntity.ok(productos);
    }

    @PostMapping()
    public ResponseEntity<String> guardarProducto(@RequestBody ModeloProducto producto) {
        try {
            productoService.guardarProducto(producto);
            return ResponseEntity.ok().body("{\"message\": \"Producto guardado correctamente\", \"status\": \"ok\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ModeloProducto> obtenerProductoPorId(@PathVariable("id") Long id) {
        Optional<ModeloProducto> producto = productoService.obtenerProductoPorId(id);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/{id}")
    public ResponseEntity<Object> cambiarEstadoProducto(@PathVariable("id") Long id, @RequestParam int status) {
        boolean cambiado = productoService.cambiarEstadoProducto(id, status);
        
        if (cambiado) {
            String mensaje = "Se " + (status == 1 ? "activó" : "desactivó") + " el producto con ID: " + id;
            return ResponseEntity.ok().body("{\"message\": \"" + mensaje + "\"}");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"No se pudo cambiar el estado del producto con ID: " + id + "\"}");
        }
    }

    @PostMapping(path = "/{id}/cantidad")
    public ResponseEntity<Object> cambiarCantidadProducto(@PathVariable("id") Long id, @RequestParam int nuevaCantidad) {
        ResponseEntity<Object> respuesta = productoService.restarCantidadProducto(id, nuevaCantidad);
        return respuesta;
    }
}
