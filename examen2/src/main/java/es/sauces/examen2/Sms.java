/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.examen2;

// COMPLETA EL CÓDIGO

import java.time.LocalDate;
import java.time.LocalTime;
// COMPLETA EL CÓDIGO
public class Sms extends Consumo{
    //fijarse que esten bien los constructores respecto 
    private String numero;

    public Sms(LocalDate fecha, LocalTime hora, float importe,String numero) {
        super(fecha, hora, importe);
        this.numero=numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return getTipoConsumo()+","+super.getFecha()+","+super.getHora()+","+super.getImporte()+"," 
                + numero;
    }
    

    @Override
    public TipoConsumo getTipoConsumo() {
        return TipoConsumo.SMS;
    }

    @Override
    public int getDuracionVolumen() {
        return 1;
    }
    
}
