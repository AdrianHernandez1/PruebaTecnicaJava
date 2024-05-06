package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaController {
    @GetMapping({"/","/login"})
    public String index() {
        return "index"; 
    }

    @GetMapping({"/productos"})
    public String productos() {
        return "gestion/productos/productos"; 
    }

    @GetMapping({"/salida_productos"})
    public String salida_productos() {
        return "gestion/salidaProductos/SalidaProductos"; 
    }

    @GetMapping({"/main"})
    public String main() {
        return "main"; 
    }
}
