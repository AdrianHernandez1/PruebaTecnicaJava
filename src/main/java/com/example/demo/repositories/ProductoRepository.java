package com.example.demo.repositories;

import com.example.demo.models.ModeloProducto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<ModeloProducto, Long> {
   
}