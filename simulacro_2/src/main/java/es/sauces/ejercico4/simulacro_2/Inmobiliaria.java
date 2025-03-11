/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.simulacro_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvaro.gargon.4
 */
public class Inmobiliaria {
    private Set<Inmueble> inmuebles;
     private static final Logger LOG = Logger.getLogger(Inmobiliaria.class.getName());

    public Inmobiliaria(Set<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
        inmuebles=new TreeSet();
    }

    public List<Inmueble> getInmuebles() {
        return new ArrayList<>(inmuebles);
    }

    public void setInmuebles(List<Inmueble> inmuebles) {
        this.inmuebles = new TreeSet(inmuebles);
    }
    
    public boolean incluirInmueble(Inmueble inmueble){
        return inmuebles.add(inmueble);
    }
    
    public boolean eliminarInmueble(String referencia){
        boolean elminiado;
        elminiado=false;
        for(Inmueble i:inmuebles){
            if(i.getReferencia().equals(referencia)){
                return inmuebles.remove(i);
            }
        }
        return elminiado;
    }
    
    public Inmueble getInmueble(String referencia){
        for(Inmueble i:inmuebles){
            if(i.getReferencia().equals(referencia)){
                return i;
            }
        }
        return null;
    }
    
    public List<Inmueble> getViviendas(){
        ArrayList listaPrecio = new ArrayList<>(inmuebles);
        listaPrecio.sort(new ComparadorPrecio());
        return listaPrecio;
    }
    
    public List<Inmueble> getInmuebles(TipoOperacion operacion){
        ArrayList listaInmueble = new ArrayList<>();
        for(Inmueble i:inmuebles){
            if(i.getOperacion()==operacion){
                listaInmueble.add(i);
            }
        }
        return listaInmueble;
    }
    
    public Local getLocalCompraMasBarato(){
        ArrayList buscarLocalBarato= new ArrayList<>();
        for(Inmueble i:inmuebles){
            if(i instanceof Local){
                if (TipoOperacion.COMPRAR==i.getOperacion()) {
                    buscarLocalBarato.add(i);
                }
            }
        }
        buscarLocalBarato.sort(new ComparadorPrecio());
        return (Local) buscarLocalBarato.getLast();
    }
    
    public int guardarInmuebles(String nombreArchivo) throws DaoException{
        Path path;
        int contador;
        String tipo;
        path=Paths.get(nombreArchivo);
        contador=0;
            try(BufferedWriter salida = Files.newBufferedWriter(path)) 
            {
                for(Inmueble i: inmuebles){
                    if(i instanceof Local){
                        tipo="Local";
                    }else{
                        tipo="Vivienda";
                    }
                    salida.write(tipo + "," + super.toString());
                    salida.newLine();
                    contador++;
                }
            }catch(IOException ioe){
                LOG.log(Level.INFO, "No se ha podido cargar los archivos");
                throw new DaoException("Error al guardar los inmuebles en el archivo");
            }
        return contador;
    }
    
    public int cargarInmuebles(String nombreArchivo) throws DaoException, ReferenciaException{
        Path path;
        int contador;
        String tipo,linea,dormitorios,escaparate,referencia;
        String[] lineaa;
        path=Paths.get(nombreArchivo);
        contador=0;
        try(BufferedReader entrada=Files.newBufferedReader(path)){
            linea=entrada.readLine();
            while(linea!=null){
                lineaa=linea.split(",");
                tipo=lineaa[0];
                referencia=lineaa[1];
                if("Local".equals(tipo)){
                    escaparate=lineaa[lineaa.length-1];
                    new Local(referencia,Float.parseFloat(lineaa[2]),Integer.parseInt(lineaa[3])
                            ,TipoOperacion.valueOf(lineaa[4]),Float.parseFloat(escaparate));
                }else{
                    dormitorios=lineaa[lineaa.length-1];
                    new Vivienda(referencia,Float.parseFloat(lineaa[2]),Integer.parseInt(lineaa[3])
                            ,TipoOperacion.valueOf(lineaa[4]),Integer.parseInt(dormitorios));
                }
                contador++;
            }
        } catch (IOException ex) {
            LOG.log(Level.INFO, "No se ha podido cargar los archivos");
            throw new DaoException("Error al cargar los inmuebles en el archivo");
        }
        return contador;
    }
}
