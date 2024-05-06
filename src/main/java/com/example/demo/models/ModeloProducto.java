
package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class ModeloProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idProducto;
    private String nombre;
    private String descripccion;
    private double precio;
    private int cantidad;
    private int estatus;

    // Constructor sin argumentos
    public ModeloProducto() {
    }

    // Constructor con argumentos
    public ModeloProducto(String nombre, String descripccion, double precio, int cantidad, int estatus) {
        this.nombre = nombre;
        this.descripccion = descripccion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.estatus = estatus;
    }
    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "ModeloProducto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", descripccion=" + descripccion + ", precio=" + precio + ", cantidad=" + cantidad + ", estatus=" + estatus + '}';
    }
    
    
}
