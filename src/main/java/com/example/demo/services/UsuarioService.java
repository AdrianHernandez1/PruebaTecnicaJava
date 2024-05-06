package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.ModeloUsuario;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ModeloUsuario autenticarUsuario(String usuario, String contrasenia) {
    ModeloUsuario usuarioEncontrado = usuarioRepository.buscarUsuarioPorNombreUsuario(usuario);
    if (usuarioEncontrado != null && usuarioEncontrado.getContrasenia().equals(contrasenia)) {
        return usuarioEncontrado;
    } else {
        return null;
    }
}


    public ArrayList<ModeloUsuario> obtenerProductos(){
        return (ArrayList<ModeloUsuario>) usuarioRepository.findAll();
    }
}
