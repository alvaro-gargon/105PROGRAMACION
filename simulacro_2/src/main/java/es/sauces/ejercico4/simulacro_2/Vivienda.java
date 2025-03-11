/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.simulacro_2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvaro.gargon.4
 */
public class Vivienda extends Inmueble{

    private int dormitorio;
    private static final Logger LOG = Logger.getLogger(Vivienda.class.getName());

    public Vivienda() {
    }

    public Vivienda(String referencia) throws ReferenciaException {
        super(referencia);
    }

    public Vivienda(String referencia, float superficie, int precio, TipoOperacion operacion,int dormitorio) throws ReferenciaException {
        super(referencia, superficie, precio, operacion);
        if(dormitorio<0){
            LOG.log(Level.INFO, "El valor de dormitorio es menor de 0");
            throw new IllegalArgumentException("Los dormitorios no pueden ser negativos");
        }
        this.dormitorio = dormitorio;
    }

    public int getDormitorio() {
        return dormitorio;
    }

    public void setDormitorio(int dormitorio) {
        if(dormitorio<0){
            LOG.log(Level.INFO, "El valor de dormitorio es menor de 0");
            throw new IllegalArgumentException("Los dormitorios no pueden ser negativos");
        }
        this.dormitorio = dormitorio;
    }

    @Override
    public String toString() {
        return super.toString() +","+ dormitorio;
    }
    
    
    @Override
    public float getComision() {
        if(dormitorio==2){
            return (float) (super.getPrecio()*0.02);
        }else{
            return (float) (super.getPrecio()*0.03);
        }
    }
    
}
