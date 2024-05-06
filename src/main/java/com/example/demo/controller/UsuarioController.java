package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ModeloUsuario;
import com.example.demo.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService authService;

 @PostMapping("/login")
public ResponseEntity<java.util.Map<String, Long>> login(@RequestParam String usuario, @RequestParam String contrasenia) {
    ModeloUsuario usuarioAutenticado = authService.autenticarUsuario(usuario, contrasenia);
    if (usuarioAutenticado != null) {
        java.util.Map<String, Long> response = new HashMap<>();
        response.put("idUsuario", usuarioAutenticado.getId());
        return ResponseEntity.ok().body(response);
    } else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}



      @GetMapping()
    public ResponseEntity<ArrayList<ModeloUsuario>> obtenerUsuarios() {
        ArrayList<ModeloUsuario> usuarios = authService.obtenerProductos();
        return ResponseEntity.ok(usuarios);
    }
}
