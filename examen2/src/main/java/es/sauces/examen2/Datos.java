/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.examen2;

// COMPLETA EL CÓDIGO

import java.time.LocalDate;
import java.time.LocalTime;
// COMPLETA EL CÓDIGO
public class Datos extends Consumo{
    private int volumen;

    public Datos(LocalDate fecha, LocalTime hora, float importe,int volumen) {
        super(fecha, hora,0);
        this.volumen=volumen;
    }

    public int getVolumen() {
        return volumen;
    }

    @Override
    public String toString() {
        return getTipoConsumo()+","+super.getFecha()+","+super.getHora()+","+super.getImporte()+","+volumen ;
    }

    @Override
    public TipoConsumo getTipoConsumo() {
        return TipoConsumo.DATOS;
    }

    @Override
    public int getDuracionVolumen() {
        return volumen;
    }
    
}
