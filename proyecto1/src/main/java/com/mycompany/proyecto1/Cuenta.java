/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

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
        if(saldo>0){
            saldo+=cantidad;
        }
    }

    /**
     *
     * @param cantidad
     */
    public void integrar(float cantidad){
        if(cantidad>0 && cantidad<=saldo){
            saldo-=cantidad;
        }
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
