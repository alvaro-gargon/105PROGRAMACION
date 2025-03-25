/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.ud08a02_archivos_binario;

import java.io.Serializable;

/**
 *
 * @author alvaro.gargon.4
 */
public class Provincia implements Serializable{
    private byte codigo;
    private String nombre;
    private int habitantes;
    private static final long serialVersionUID=1L;

    public Provincia(byte codigo, String nombre, int habitantes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.habitantes = habitantes;
    }

    public byte getCodigo() {
        return codigo;
    }

    public void setCodigo(byte codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    @Override
    public String toString() {
        return   codigo + "," + nombre + "," + habitantes;
    }    
}
