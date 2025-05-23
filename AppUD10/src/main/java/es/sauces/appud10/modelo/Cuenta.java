/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.appud10.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author ambrosio
 */
public class Cuenta implements Serializable, Comparable<Cuenta> {

    private static final Logger LOG = Logger.getLogger(Cuenta.class.getName());

    private String codigo;

    private String titular;

    private float saldo;

    public Cuenta() {
    }

    public Cuenta(String codigo, String titular, float saldo) throws SaldoException {
        if (saldo < 0) {
            LOG.warning("SALDO NEGATIVO");
            throw new SaldoException("EL SALDO DEBE SER POSITIVO");
        }
        this.codigo = codigo;
        this.titular = titular;
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void ingresar(float cantidad) {
        if (cantidad < 0) {
            LOG.warning("CANTIDAD NEGATIVA");
            throw new IllegalArgumentException("LA CANTIDAD DEBE SER POSITIVIA");
        }
        saldo += cantidad;
    }

    public void reintegrar(float cantidad) throws SaldoException {
        if (cantidad < 0) {
            LOG.warning("CANTIDAD NEGATIVA");
            throw new IllegalArgumentException("LA CANTIDAD DEBE SER POSITIVIA");
        }
        if (cantidad > saldo) {
            LOG.warning("CANTIDAD SUPERA EL SALDO DISPONIBLE");
            throw new SaldoException("LA CANTIDAD SUPERA EL SALDO");
        }
        saldo -= cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.codigo);
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
    public String toString() {
        return codigo + "," + titular + "," + saldo;
    }

    @Override
    public int compareTo(Cuenta o) {
        return codigo.compareTo(o.codigo);
    }

}
