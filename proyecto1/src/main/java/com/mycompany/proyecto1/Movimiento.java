/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.time.LocalDate;

/**
 *La clase {@code Movimiento} modela un movimiento.
 * @author alvaro.gargon.4
 */
public class Movimiento {
    private LocalDate fecha;
    private char tipo;
    private float cantidad;
    private float saldo;

    /**
     * Genera un movimiento que contiene la fecha a la que se realizo, el tipo de movimiento, la cantidad que se mueve en el movimiento y el saldo restantes
     * @param fecha
     * @param tipo
     * @param cantidad
     * @param saldo
     */
    public Movimiento(LocalDate fecha, char tipo, float cantidad, float saldo) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.saldo = saldo;
    }

    /**
     *
     * @return la fecha solicitada
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha cambia la fecha
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return de que tipo es el elemento
     */
    public char getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo modifica el tipo del elemento
     */
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return la cantidad
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     *
     * @param cantidad cambia la cantidad
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     *
     * @return devuelve el saldo
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     *
     * @param saldo modifica el saldo
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
}
