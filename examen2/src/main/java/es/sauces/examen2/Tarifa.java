/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.examen2;

public class Tarifa {
    private String nombre;
    private float precioEstablecimiento;
    private float precioMinuto;
    private float precioSms;
    private int datos;

    public Tarifa(String nombre, float precioEstablecimiento, float precioMinuto, float precioSms, int datos) {
        this.nombre = nombre;
        this.precioEstablecimiento = precioEstablecimiento;
        this.precioMinuto = precioMinuto;
        this.precioSms = precioSms;
        this.datos = datos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioEstablecimiento() {
        return precioEstablecimiento;
    }

    public void setPrecioEstablecimiento(float precioEstablecimiento) {
        this.precioEstablecimiento = precioEstablecimiento;
    }

    public float getPrecioMinuto() {
        return precioMinuto;
    }

    public void setPrecioMinuto(float precioMinuto) {
        this.precioMinuto = precioMinuto;
    }

    public float getPrecioSms() {
        return precioSms;
    }

    public void setPrecioSms(float precioSms) {
        this.precioSms = precioSms;
    }

    public int getDatos() {
        return datos;
    }

    public void setDatos(int datos) {
        this.datos = datos;
    }
}
