/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.simulacro_1b;

/**
 *
 * @author alvaro.gargon.4
 */
public class NumeroComplejo {
    private float parteReal;
    private float parteImaginaria;

    public NumeroComplejo() {
    }

    public NumeroComplejo(float parteReal, float parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    public float getParteReal() {
        return parteReal;
    }

    public float getParteImaginaria() {
        return parteImaginaria;
    }

    public void setParteReal(float parteReal) {
        this.parteReal = parteReal;
    }

    public void setParteImaginaria(float parteImaginaria) {
        this.parteImaginaria = parteImaginaria;
    }
    
    public NumeroComplejo sumar(NumeroComplejo z){
        float a=this.parteReal+z.parteReal;
        float b=this.parteImaginaria+z.parteImaginaria;
        NumeroComplejo z3= new NumeroComplejo(a,b);
        return z3;
    }
    public NumeroComplejo restar(NumeroComplejo z){
        float a=this.parteReal-z.parteReal;
        float b=this.parteImaginaria-z.parteImaginaria;
        NumeroComplejo z3= new NumeroComplejo(a,b);
        return z3;
    }
    public NumeroComplejo multiplicar(NumeroComplejo z){
        float a=this.parteReal*z.parteReal-this.parteImaginaria*z.parteImaginaria;
        float b=this.parteReal*z.parteImaginaria+this.parteImaginaria*z.parteReal;
        NumeroComplejo z3= new NumeroComplejo(a,b);
        return z3;
    }
    public NumeroComplejo conjugado(){
        float a=this.parteReal;
        float b=this.parteImaginaria*-1;
        NumeroComplejo z3= new NumeroComplejo(a,b);
        return z3;
    }

    @Override
    public String toString() {
        return "(" + parteReal + "," + parteImaginaria + ')';
    }

    
       
    public static NumeroComplejo sumar(NumeroComplejo z1, NumeroComplejo z2){
        float a=z1.parteReal+z2.parteReal;
        float b=z1.parteImaginaria+z2.parteImaginaria;
        NumeroComplejo z3= new NumeroComplejo(a,b);
        return z3;
    }
    public String printFormaBionica(){
        if(this.parteImaginaria>=0){
            return this.parteReal+"+"+this.parteImaginaria+"i";
        }else{
            return this.parteReal+""+this.parteImaginaria+"i";
        }
       
    }
}
