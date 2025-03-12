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
        this.inmuebles = new TreeSet<>(inmuebles);
    }
    
    public boolean incluirInmueble(Inmueble inmueble){
        return inmuebles.add(inmueble);
    }
    
    public boolean eliminarInmueble(String referencia){
        boolean elminiado;
        elminiado=false;
        if(getInmueble(referencia)!=null){
            inmuebles.remove(getInmueble(referencia));
            elminiado=true;
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
        List<Inmueble> listado = new ArrayList<>();
        for(Inmueble i :inmuebles){
            if(i instanceof Vivienda){
                listado.add(i);
            }
        }
        listado.sort(new ComparadorPrecio());
        return listado;
    }
    
    public List<Inmueble> getInmuebles(TipoOperacion operacion){
        ArrayList listaInmueble = new ArrayList<>();
        for(Inmueble i:inmuebles){
            if(i.getOperacion()==operacion){
                listaInmueble.add(i);
            }
        }
        //no hace fata ordenar porque con el TreeSet ya esta ordenado autoamticamente (por referencia)
        return listaInmueble;
    }
    
    public Local getLocalCompraMasBarato(){
        Local localBarato = null;
        int precioCompra=Integer.MAX_VALUE;
        for(Inmueble i:inmuebles){
            if(i instanceof Local l){
                if (TipoOperacion.COMPRAR==i.getOperacion()) {
                    if(i.getPrecio()<precioCompra){
                        precioCompra=i.getPrecio();
                        localBarato=l;
                    }
                }
            }
        }
        return localBarato;
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
                    salida.write(i.getClass().getSimpleName() + "," + super.toString());
                    salida.newLine();
                    contador++;
                }
            }catch(IOException ioe){
                LOG.log(Level.INFO, "No se ha podido guardar los archivos");
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
        Inmueble inmueble = null;
        contador=0;
        try(BufferedReader entrada=Files.newBufferedReader(path)){
            linea=entrada.readLine();
            while(linea!=null){
                lineaa=linea.split(",");
                tipo=lineaa[0];
                referencia=lineaa[1];
                if("Local".equals(tipo)){
                    escaparate=lineaa[lineaa.length-1];
                    inmueble=new Local(referencia,Float.parseFloat(lineaa[2]),Integer.parseInt(lineaa[3])
                            ,TipoOperacion.valueOf(lineaa[4]),Float.parseFloat(escaparate));
                }else{
                    dormitorios=lineaa[lineaa.length-1];
                    inmueble=new Vivienda(referencia,Float.parseFloat(lineaa[2]),Integer.parseInt(lineaa[3])
                            ,TipoOperacion.valueOf(lineaa[4]),Integer.parseInt(dormitorios));
                }
                contador++;
                inmuebles.add(inmueble);
                linea=entrada.readLine();
            }
        } catch (IOException ex) {
            LOG.log(Level.INFO, "No se ha podido cargar los archivos");
            throw new DaoException("Error al cargar los inmuebles en el archivo");
        }
        return contador;
    }
}
