package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ModeloMovimiento;
import com.example.demo.services.MovimientoService;

@RestController
@RequestMapping("/movimiento")
public class MovimientoController {
    @Autowired
    MovimientoService movimientoService;

     @GetMapping()
    public ResponseEntity<ArrayList<ModeloMovimiento>> obtenerMovimiento() {
        ArrayList<ModeloMovimiento> productos = movimientoService.obtenerMovimientos();
        return ResponseEntity.ok(productos);
    }

    @PostMapping()
    public ResponseEntity<ModeloMovimiento> guardarMovimiento(@RequestBody ModeloMovimiento movimiento) {
        try {
            ModeloMovimiento nuevoProducto = movimientoService.guardarMovimiento(movimiento);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

  
}
