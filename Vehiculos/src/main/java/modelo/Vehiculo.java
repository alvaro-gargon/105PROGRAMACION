/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo.MatriculaException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alvaro.gargon.4
 */
public abstract class  Vehiculo implements Comparable<Vehiculo>,Serializable {
    private String matricula;
    private Grupo grupo;
    private static final Logger LOG = Logger.getLogger(Vehiculo.class.getName());

    public Vehiculo() {
    }

    public Vehiculo(String matricula) throws MatriculaException {
        if(!esMatriculaValida(matricula)){
            LOG.log(Level.WARNING, "La matricula no es valida{0}", matricula);
            throw new MatriculaException("Matricula no valida");
        }
        this.matricula = matricula;
    }
    
    public Vehiculo(String matricula, Grupo grupo) throws MatriculaException {
         if(!esMatriculaValida(matricula)){
             LOG.log(Level.WARNING, "La matricula no es valida{0}", matricula);
            throw new MatriculaException("Matricula no valida");
        }
        this.matricula = matricula;
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return matricula +","+ grupo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws MatriculaException {
        if(!esMatriculaValida(matricula)){
            LOG.log(Level.WARNING, "La matricula no es valida{0}", matricula);
            throw new MatriculaException("Matricula no valida");
        }
        this.matricula = matricula;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.matricula);
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
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.matricula, other.matricula);
    }

    @Override
    public int compareTo(Vehiculo v) {
        return this.matricula.compareTo(v.matricula);
    }
    
    public float getPrecioAlquiler(int dias){
        if(dias<0){
            throw new IllegalArgumentException("El numero de dias no puede ser menor de 0");
        }
        return dias*getPrecioAlquiler();
    }
    
    public abstract float getPrecioAlquiler();
    
    private static boolean esMatriculaValida(String matricula){
        String patron="([0-9]{4})([B-Z&&[^EIOUQÑ]]{3})";
        Pattern p=Pattern.compile(patron);
        Matcher m=p.matcher(matricula);
        return m.matches();
    }
    
}
