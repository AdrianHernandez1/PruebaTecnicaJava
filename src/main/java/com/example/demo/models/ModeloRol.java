
package com.example.demo.models;

public class ModeloRol {
    private int idRol;
    private String rol;
    private int estatus;

    public ModeloRol(int idRol, String rol, int estatus) {
        this.idRol = idRol;
        this.rol = rol;
        this.estatus = estatus;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "ModeloRol{" + "idRol=" + idRol + ", rol=" + rol + ", estatus=" + estatus + '}';
    }
    
    
}
