package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.ModeloMovimiento;
import com.example.demo.repositories.MovimientosRepository;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class MovimientoService {
    @Autowired
    MovimientosRepository movimientoRepository;

    @Autowired
    UsuarioRepository usuarioRepository; 

    public ArrayList<ModeloMovimiento> obtenerMovimientos(){
        return (ArrayList<ModeloMovimiento>) movimientoRepository.findAll();
    }

    public ModeloMovimiento guardarMovimiento(ModeloMovimiento movimiento){
        return  movimientoRepository.save(movimiento);
    }
}
