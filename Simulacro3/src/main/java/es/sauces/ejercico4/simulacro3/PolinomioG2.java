/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.simulacro3;

/**
 *
 * @author alvaro.gargon.4
 */
public class PolinomioG2 {
    private float a;
    private float b;
    private float c;

    public PolinomioG2(float a, float b, float c) {
        this.a = a;
        if(a==0){
            a=1;
        }
        this.b = b;
        this.c = c;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        if(a!=0){
            this.a = a;
        }
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }
    public float evaluar(float x){
        return a*x*x+b*x+c;
    }
    
    private float getDiscriminante(){
        return b*b-4*a*c;
    }
    
    public String getRaices(){
        float x1,x2;
        
        return "";
    }

    @Override
    public String toString() {
        return "PolinomioG2{" + "a=" + a + ", b=" + b + ", c=" + c + ", getRaices=" + getRaices() + '}';
    }
    
    
}
