/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.vehiculos;

import java.util.Objects;

/**
 *
 * @author alvaro.gargon.4
 */
public abstract class  Vehiculo implements Comparable<Vehiculo> {
    private String matricula;
    private Grupo grupo;

    public Vehiculo() {
    }

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }
    
    

    public Vehiculo(String matricula, Grupo grupo) {
        this.matricula = matricula;
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", grupo=" + grupo + '}';
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
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
        return dias*getPrecioAlquiler();
    }
    
    public abstract float getPrecioAlquiler();
}
