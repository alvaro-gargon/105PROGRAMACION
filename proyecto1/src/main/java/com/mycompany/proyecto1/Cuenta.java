/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La clase {@code Cuenta} modela una cuenta bancaria.
 * @author alvaro.gargon.4
 * @since 1.0
 */
public class Cuenta implements Comparable<Cuenta>{
    
    private static final Logger Log=Logger.getLogger("");
    
    private String codigo;
    private String titular;
    private float saldo;
    private List<Movimiento> movimientos;

    /**
     *
     */
    public Cuenta() {
        movimientos=new ArrayList<>();
    }

    /**
     *Permite instaciar un objeto incializando los valores codigo.
     * @param codigo el codigo de la cuenta
     * @throws com.mycompany.proyecto1.IbanException
     */
    public Cuenta(String codigo) throws IbanException {
        if(!esIbanValido(codigo)){
            throw new IbanException("Codigo incorrecto");
        }
        this.codigo = codigo;
        movimientos=new ArrayList<>();
    }

    
    /**
     * Permite instaciar un objeto incializando los valores codigo, titular y salida
     * @param codigo    el codigo de la cuenta
     * @param titular   el DNI del titular de la cuenta
     * @param saldo     el saldo de la cuenta
     * @throws com.mycompany.proyecto1.IbanException
     */
    public Cuenta(String codigo, String titular, float saldo) throws IbanException {
         if(!esIbanValido(codigo)){
            throw new IbanException("Codigo incorrecto");
        }
        if(saldo<0){
            throw new IllegalArgumentException("No inicial no puede seer menor de 0");
        }
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
     * @return el titular de la cuenta
     */
    public String getTitular() {
        return titular;
    }

    /**
     *
     * @return el saldo de la cuenta
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     *
     * @return una lista con los movimientos
     */
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }
    
    /**
     *
     * @param desde
     * @param hasta
     * @return
     */
    public List<Movimiento> getMovimientos(LocalDate desde, LocalDate hasta){
        List<Movimiento> listado =new ArrayList<>();
        for(Movimiento m:movimientos){
            if(m.getFecha().isAfter(desde) && m.getFecha().isBefore(hasta)){
                listado.add(m);
            }
        }
        return listado;
    }

    /**
     *
     * @param codigo cambia el codigo 
     * @throws com.mycompany.proyecto1.IbanException 
     */
    public void setCodigo(String codigo) throws IbanException {
         if(!esIbanValido(codigo)){
            throw new IbanException("Codigo incorrecto");
        }
        this.codigo = codigo;
    }

    /**
     *
     * @param titular cambia el titular
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     *
     * @param saldo cambia el saldo
     * @throws com.mycompany.proyecto1.SaldoInsuficienteException
     */
    public void setSaldo(float saldo) throws SaldoInsuficienteException{
        if(saldo<0){
            throw new SaldoInsuficienteException("Saldo no puede ser menor de 0");
        }
        if (saldo>=0){
            this.saldo=saldo;
        }
        this.saldo = saldo;
    }

    /**
     * Ingresa una cantidad especificada
     * @param cantidad es la cantidad que se va a ingresar
     */
    public void ingresar(float cantidad){
        if(cantidad<0){
            throw new IllegalArgumentException("La cantidad debe de ser mayor de 0");
        }
        if(cantidad>0){
            saldo+=cantidad;
            movimientos.add(new Movimiento(LocalDate.now(),'I',cantidad,saldo));
        }
    }

    /**
     * Reintegra la cantidad especificada y genera un movimiento
     * @param cantidad es la cantidad que se va a reintegrar
     * @throws com.mycompany.proyecto1.SaldoInsuficienteException
     */
    public void reintegrar(float cantidad)throws SaldoInsuficienteException{
        if(cantidad>saldo){
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        if(cantidad<0){
            throw new IllegalArgumentException("La cantidad debe de ser mayor de 0");
        }
        if(cantidad>0 && cantidad<=saldo){
            saldo-=cantidad;
            movimientos.add(new Movimiento(LocalDate.now(),'R',-cantidad,saldo));
        }
    }
    
    /**
     * Realiza una transferencia desde una cuenta destino y genera un movimiento
     * @param destino es la cuenta que va a recibir la transferencia
     * @param cantidad es la cantidad a transferir
     * @throws com.mycompany.proyecto1.SaldoInsuficienteException
     */
    public void realizarTransferencia(Cuenta destino, float cantidad)throws SaldoInsuficienteException{
        if(cantidad>saldo){
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        if(cantidad<0){
            throw new IllegalArgumentException("La cantidad debe de ser mayor de 0");
        }
        if(destino==null){
            throw new NullPointerException("El destino no puede ser nulo");
        }
        if(destino==this){
            throw new IllegalArgumentException("No se puede realizar una transferencia a si mismo");
        }
        saldo-=cantidad;
        movimientos.add(new Movimiento(LocalDate.now(),'T',-cantidad,saldo));
        destino.recibirTranseferencia(this, cantidad); 
    }
    
    /**
     * Recibe una cantidad 
     * @param origen cuenta desde la cual recibes la transferencia
     * @param cantidad es la cantidad que se va a recibir
     */
    public void recibirTranseferencia(Cuenta origen, float cantidad){
        if(cantidad<0){
            throw new IllegalArgumentException("La cantidad debe de ser mayor de 0");
        }
        if(cantidad>0){
            saldo+=cantidad;
            movimientos.add(new Movimiento(LocalDate.now(),'I',cantidad,saldo));
        }
    }
    
    /**
     *
     * @return una lista de movimientos
     */
    public String listarMovimientos(){
        return movimientos.toString();
    }

    /**
     *
     * @return un string con el codigo, el titular y el saldo de la cuenta
     */
    @Override
    public String toString() {
        return  codigo + "," + titular + "," + saldo ;
    }

    /**
     *
     * @return hashCode
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

    /**
     * Compara una cuenta con otro especificada
     * @param o la cuenta con la que se va a comparar
     * @return 
     */
    @Override
    public int compareTo(Cuenta o) {
        return this.codigo.compareTo(o.codigo);
    }
    
    public static boolean esIbanValido(String codigoIban){
        String patron="(ES)(\\d{2})(\\d{4})(\\d{4})(\\d{2})(\\d{10})";
        Pattern p=Pattern.compile(patron);
        Matcher m=p.matcher(codigoIban);
        return m.matches();
    }
}
