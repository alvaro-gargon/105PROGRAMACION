/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.sauces.ejercico4.simulacro;

/**
 *
 * @author alvaro.gargon.4
 */
public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion() {
        this.numerador = 1;
        this.denominador = 1;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
    
    public Fraccion sumar(Fraccion otraFraccion){
        Fraccion fraccion;
        int numerador=this.numerador*otraFraccion.denominador+this.denominador+otraFraccion.numerador;
        int denominador=this.denominador*otraFraccion.denominador;
        fraccion = new Fraccion( numerador,  denominador);
        return fraccion;
    }
    public Fraccion multiplicar(Fraccion otraFraccion){
        Fraccion fraccion;
        int numerador=this.numerador*otraFraccion.denominador+this.denominador+otraFraccion.numerador;
        int denominador=this.denominador*otraFraccion.denominador;
        fraccion = new Fraccion( numerador,  denominador);
        return fraccion;
    }
    
    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }
    
    
}
