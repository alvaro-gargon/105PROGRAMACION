/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.examen2;

// COMPLETA EL CÓDIGO

import java.time.LocalDate;
import java.time.LocalTime;
// COMPLETA EL CÓDIGO
public class Llamada extends Consumo{
    private String numero;
    private int duracion;

    public Llamada(LocalDate fecha, LocalTime hora,float importe,String numero,int duracion) {
        super(fecha, hora, importe);
        this.numero=numero;
        this.duracion=duracion;
    }

    public String getNumero() {
        return numero;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return getTipoConsumo()+","+super.getFecha()+","+super.getHora()+","+super.getImporte()+"," 
                + numero + "," + duracion;
    }

    @Override
    public TipoConsumo getTipoConsumo() {
        return TipoConsumo.LLAMADA;
    }

    @Override
    public int getDuracionVolumen() {
        return duracion;
    }
    
}
