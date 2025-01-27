/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * La clase {@code Cuenta} modela una cuenta bancaria.
 * @author alvaro.gargon.4
 * @since 1.0
 */
public class Cuenta {
    private String codigo;
    private String titular;
    private float saldo;
    private List<Movimiento> movimientos;

    public Cuenta() {
        movimientos=new ArrayList<>();
    }

    public Cuenta(String codigo) {
        this.codigo = codigo;
        movimientos=new ArrayList<>();
    }

    
    /**
     * Permite instaciar un objeto incializando los valores codigo, titular y salida
     * @param codigo    el codigo de la cuenta
     * @param titular   el DNI del titular de la cuenta
     * @param saldo     el saldo de la cuenta
     */
    public Cuenta(String codigo, String titular, float saldo) {
        this.codigo = codigo;
        this.titular = titular;
        if(saldo>0){
            this.saldo = saldo;
        }
        movimientos=new ArrayList<>();
    }

    /**
     * Devuelve el codigo de la cuenta
     * @return el codigo de la cuenta
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @return
     */
    public String getTitular() {
        return titular;
    }

    /**
     *
     * @return
     */
    public float getSaldo() {
        return saldo;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }
    
    public List<Movimiento> getMovimientos(LocalDate desde, LocalDate hasta){
        List<Movimiento> listado =new ArrayList<>();
        return listado;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @param titular
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     *
     * @param saldo
     */
    public void setSaldo(float saldo) {
        if (saldo>=0){
            this.saldo=saldo;
        }
        this.saldo = saldo;
    }

    /**
     *
     * @param cantidad
     */
    public void ingresar(float cantidad){
        if(cantidad>0){
            saldo+=cantidad;
            movimientos.add(new Movimiento(LocalDate.now(),'I',cantidad,saldo));
        }
    }

    /**
     *
     * @param cantidad
     */
    public void reintegrar(float cantidad){
        if(cantidad>0 && cantidad<=saldo){
            saldo-=cantidad;
            movimientos.add(new Movimiento(LocalDate.now(),'R',-cantidad,saldo));
        }
    }
    
    public void realizarTransferencia(Cuenta destino, float cantidad){
        if(cantidad>0 && cantidad<=saldo){
            saldo-=cantidad;
            movimientos.add(new Movimiento(LocalDate.now(),'T',-cantidad,saldo));
        }
    }
    
    public void recibirTranseferencia(Cuenta origen, float cantidad){
        if(cantidad>0){
            saldo+=cantidad;
            movimientos.add(new Movimiento(LocalDate.now(),'I',cantidad,saldo));
        }
    }
    
    public String listarMovimientos(){
        return movimientos.toString();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return  codigo + "," + titular + "," + saldo ;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cuenta other = (Cuenta) obj;
        return Objects.equals(this.codigo, other.codigo);
    }
    

}
