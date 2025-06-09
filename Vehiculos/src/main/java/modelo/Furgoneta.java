/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo.Grupo;
import modelo.Vehiculo;
import modelo.MatriculaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvaro.gargon.4
 */
public class Furgoneta extends Vehiculo {
    private float capacidad;
    private static final Logger LOG = Logger.getLogger(Furgoneta.class.getName());

    public Furgoneta() {
    }

    public Furgoneta(String matricula) throws MatriculaException {
        super(matricula);
    }

    public Furgoneta( String matricula, Grupo grupo,float capacidad) throws MatriculaException {
        super(matricula, grupo);
         if(capacidad<0){
            LOG.log(Level.WARNING, "La capacidad introducida es menor de 0");
            throw new IllegalArgumentException("La capacidad no puede ser negativa");
        }
        this.capacidad = capacidad;
    }

    public float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(float capacidad) {
        if(capacidad<0){
            throw new IllegalArgumentException("La capacidad no puede ser negativa");
        }
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return super.toString()+","+capacidad;
    }

    @Override
    public float getPrecioAlquiler() {
        /*
        return switch(this.getGrupo()){
            case A-> 50+(5f *capacidad);
            case B-> 55+(10f *capacidad);
            case C-> 60+(15f *capacidad);
        };
        */
        return getGrupo().getPrecioBase()+getGrupo().getFactorFurgoneta()*capacidad;
    }
    
    
}
