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
public class Local extends Inmueble{
    
    private float escaparate;
    
    private static final Logger LOG = Logger.getLogger(Local.class.getName());

    public Local() {
    }

    public Local(String referencia) throws ReferenciaException {
        super(referencia);
    }

    public Local( String referencia, float superficie, int precio, TipoOperacion operacion,float escaparate) throws ReferenciaException {
        super(referencia, superficie, precio, operacion);
        if(escaparate<0){
            LOG.log(Level.INFO, "Se ha introducido un valor de escaparate menor de 0");
            throw new IllegalArgumentException("El valor de escaparate no puede ser negativo");
        }
        this.escaparate = escaparate;
    }

    public float getEscaparate() {
        return escaparate;
    }

    public void setEscaparate(float escaparate) {
        if(escaparate<0){
            LOG.log(Level.INFO, "Se ha introducido un valor de escaparate menor de 0");
            throw new IllegalArgumentException("El valor de escaparate no puede ser negativo");
        }
        this.escaparate = escaparate;
    }

    @Override
    public String toString() {
        return super.toString()+","+escaparate;
    }
    
    
    @Override
    public float getComision() {
        return (getPrecio()*0.01f);
    }
    
}
