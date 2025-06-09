/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.appbanco2025.modelo;

import es.sauces.appbanco2025.dao.DaoException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author usuario
 */
public class Cuenta implements Serializable, Comparable<Cuenta>{

    private static final long serialVersionUID = 1L;
    private String codigo;
    private Usuario titular;
    private float saldo;
    private List<Movimiento> movimientos=new ArrayList<>();

    public Cuenta() {
    }

    public Cuenta(String codigo) {
        this.codigo = codigo;
    }

    public Cuenta(String codigo, Usuario titular, float saldo) {
        this.codigo = codigo;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Usuario getTitular() {
        return titular;
    }

    public void setTitular(Usuario titular) {
        this.titular = titular;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    
    public List<Movimiento> getMovimientos(){
        return movimientos;
    }
    
    public Movimiento ingresar(float cantidad){
        if(cantidad<0){
            throw new IllegalArgumentException("La cantidad debe de ser mayor de 0");
        }
        
            saldo+=cantidad;
            movimientos.add(new Movimiento(LocalDate.now(),TipoMovimiento.INGRESO,cantidad,saldo));
        
        return new Movimiento(LocalDate.now(),TipoMovimiento.INGRESO,cantidad,saldo);
    }
    
    public Movimiento reintegrar(float cantidad){
        if(cantidad>saldo){
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        if(cantidad<0){
            throw new IllegalArgumentException("La cantidad debe de ser mayor de 0");
        }
       
            saldo-=cantidad;
            movimientos.add(new Movimiento(LocalDate.now(),TipoMovimiento.REINTEGRO,cantidad,saldo));
        
        return new Movimiento(LocalDate.now(),TipoMovimiento.REINTEGRO,cantidad,saldo);
    }

    @Override
    public String toString() {
        return  codigo + "," + "," + saldo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

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
    
    

    @Override
    public int compareTo(Cuenta o) {
        return this.codigo.compareTo(o.codigo);
    }
}
