/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.examen2;

// COMPLETA EL CÓDIGO

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Consumo {
    private LocalDate fecha;
    private LocalTime hora;
    private float importe;

    public Consumo(LocalDate fecha, LocalTime hora, float importe) {
        this.fecha = fecha;
        this.hora = hora;
        this.importe = importe;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public float getImporte() {
        return importe;
    }

    @Override
    public String toString() {
        return getTipoConsumo() +","+ fecha + "," + hora + "," + importe ;
    }
    public abstract TipoConsumo getTipoConsumo();
    public abstract int getDuracionVolumen();
}
