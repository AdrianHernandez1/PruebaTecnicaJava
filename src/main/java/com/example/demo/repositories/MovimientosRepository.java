package com.example.demo.repositories;

import com.example.demo.models.ModeloMovimiento;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientosRepository extends CrudRepository<ModeloMovimiento, Long> {
   
}