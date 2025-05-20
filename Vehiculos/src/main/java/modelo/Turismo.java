/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo.MatriculaException;
import modelo.Grupo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvaro.gargon.4
 */
public class Turismo extends Vehiculo {
    
    private int plazas;
    private static final Logger LOG = Logger.getLogger(Turismo.class.getName());

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        if(plazas<0 || plazas>5){
            LOG.log(Level.WARNING, "Las plazas han sido mayores de 5 o menores de 0");
            throw new IllegalArgumentException("Numero de plazas no valido");
        }
        this.plazas = plazas;
    }

    public Turismo() {
    }

    public Turismo(String matricula) throws MatriculaException {
        super(matricula);
    }

    public Turismo( String matricula, Grupo grupo,int plazas) throws MatriculaException {
        super(matricula, grupo);
        if(plazas<0 || plazas>5){
            LOG.log(Level.WARNING, "Las plazas han sido mayores de 5 o menores de 0");
            throw new IllegalArgumentException("Numero de plazas no valido");
        }
        this.plazas = plazas;
    }

    @Override
    public String toString() {
        return super.toString()+","+plazas; 
    }
    
    @Override
    public float getPrecioAlquiler() {
        /*
        return switch(this.getGrupo()){
            case A-> 50+(1.5f *plazas);
            case B-> 55+(2f *plazas);
            case C-> 60+(2.5f *plazas);
        };
        */
        return getGrupo().getPrecioBase()+getGrupo().getFactorTurismo()*plazas;
    }
    
}
