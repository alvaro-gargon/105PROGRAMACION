/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.simulacro_2;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alvaro.gargon.4
 */
public abstract class Inmueble implements Comparable<Inmueble> {
    private String referencia;
    private float superficie;
    private int precio;
    private TipoOperacion operacion;
    private static final Logger LOG = Logger.getLogger(Inmueble.class.getName());
    public Inmueble() {
    }

    public Inmueble(String referencia) throws ReferenciaException {
        if(!referenciaValida(referencia)){
            LOG.log(Level.INFO, "Se ha introducido una referencia invalida ");
            throw new ReferenciaException("La referencia no es valida");
        }
        this.referencia = referencia;
    }

    public Inmueble(String referencia, float superficie, int precio, TipoOperacion operacion) throws ReferenciaException {
        if(!referenciaValida(referencia)){
            LOG.log(Level.INFO, "Se ha introducido una referencia invalida ");
            throw new ReferenciaException("La referencia no es valida");
        }
        this.referencia = referencia;
        this.superficie = superficie;
        this.precio = precio;
        this.operacion = operacion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) throws ReferenciaException {
        if(!referenciaValida(referencia)){
            LOG.log(Level.INFO, "Se ha introducido una referencia invalida ");
            throw new ReferenciaException("La referencia no es valida");
        }
        this.referencia = referencia;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        if(superficie<0){
            LOG.log(Level.INFO, "Se ha introducido una superficie menor de 0 ");
            throw new IllegalArgumentException("La superficie no puede ser negativa");
        }
        this.superficie = superficie;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        if(precio<0){
            LOG.log(Level.INFO, "Se ha introducido un precio menor de 0 ");
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

    public TipoOperacion getOperacion() {
        return operacion;
    }

    public void setOperacion(TipoOperacion operacion) {
        this.operacion = operacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.referencia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inmueble other = (Inmueble) obj;
        return Objects.equals(this.referencia, other.referencia);
    }

    @Override
    public String toString() {
        return referencia + "," + superficie + "," + precio + "," + operacion;
    }

    @Override
    public int compareTo(Inmueble o){
        return this.referencia.compareTo(o.referencia);
    }
    
    public abstract float getComision();
    
    private boolean referenciaValida(String referencia){
        String patron="([L|V]{1})([0-9]{3})";
        Pattern p=Pattern.compile(patron);
        Matcher m=p.matcher(referencia);
        return m.matches();
    }
}
