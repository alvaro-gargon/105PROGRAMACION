/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package es.sauces.ejercico4.vehiculos;

/**
 *
 * @author alvaro.gargon.4
 */
public enum Grupo {
   A(50,1.5f,5.0f),
   B(55,2.0f,10.0f),
   C(60,2.5f,15.0f);
   private final int precioBase;
   private final float factorTurismo;
   private final float factorFurgoneta;

    private Grupo(int precioBase, float factorTurismo, float factorFurgoneta) {
        this.precioBase = precioBase;
        this.factorTurismo = factorTurismo;
        this.factorFurgoneta = factorFurgoneta;
    }

    public float getFactorTurismo() {
        return factorTurismo;
    }

    public float getFactorFurgoneta() {
        return factorFurgoneta;
    }

    public int getPrecioBase() {
        return precioBase;
    }
   
   
   
}
