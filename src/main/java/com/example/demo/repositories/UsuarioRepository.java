package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.ModeloUsuario;

public interface UsuarioRepository extends JpaRepository<ModeloUsuario, Long> {
    
    @Query("SELECT u FROM ModeloUsuario u WHERE u.usuario = :nombreUsuario")
    ModeloUsuario buscarUsuarioPorNombreUsuario(String nombreUsuario);
}
