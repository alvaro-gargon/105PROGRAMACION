/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.appbanco2025.modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author usuario
 */
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    private LocalDate fecha;
    private TipoMovimiento tipo;
    private float cantidad;
    private float saldo;

    public Movimiento() {
    }

    
    public Movimiento(LocalDate fecha, TipoMovimiento tipo, float cantidad, float saldo) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.saldo = saldo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return fecha + "," + tipo + "," + cantidad + "," + saldo;
    }
    
    
}
