package com.example.demo.models;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "movimientos")
public class ModeloMovimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idMovimiento;
    
    private int estatusEntradaSalida;

    private Long usuario;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fechaHora;

    // Constructor sin argumentos
    public ModeloMovimiento() {
    }

    // Constructor con argumentos
    public ModeloMovimiento(int estatusEntradaSalida, Long usuario) {
        this.estatusEntradaSalida = estatusEntradaSalida;
        this.usuario = usuario;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public int getEstatusEntradaSalida() {
        return estatusEntradaSalida;
    }

    public void setEstatusEntradaSalida(int estatusEntradaSalida) {
        this.estatusEntradaSalida = estatusEntradaSalida;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    @PrePersist
    protected void onCreate() {
        fechaHora = new Timestamp(System.currentTimeMillis());
    }
}
