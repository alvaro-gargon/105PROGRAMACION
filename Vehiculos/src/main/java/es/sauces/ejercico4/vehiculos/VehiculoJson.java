/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.ejercico4.vehiculos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alvaro.gargon.4
 */
public class VehiculoJson implements VehiculoDao {
 
Path path;
 
    public VehiculoJson(String path) {
        this.path = Paths.get(path);
    }
 
    public Path getPath() {
        return path;
    }
 
    public void setPath(Path path) {
        this.path = path;
    }
 
    @Override
    public String toString() {
        return path + "";
    }
 
    @Override
    public List<Vehiculo> listar() throws DaoException {
        java.lang.reflect.Type tipo = new com.google.gson.reflect.TypeToken<List<Vehiculo>>() {
        }.getType();
        List<Vehiculo> lista=new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            lista = getGson().fromJson(br, tipo);
        } catch (IOException ioe) {
            throw new DaoException(ioe.toString());
        }
        return lista;
    }
 
    @Override
    public int insertar(List<Vehiculo> empleados) throws DaoException {
        Type tipo=new TypeToken<List<Vehiculo>>() {}.getType();
        int contador;
        contador = 0;
        List<Vehiculo> lista = new ArrayList<>();
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            getGson().toJson(lista, tipo, bw);
        }catch (IOException ioe) {
            throw new DaoException(ioe.toString());
        }
 
        return contador;
    }
    private Gson getGson(){
        java.lang.reflect.Type tipo = new com.google.gson.reflect.TypeToken<List<Vehiculo>>() {
        }.getType();
        RuntimeTypeAdapterFactory<Vehiculo> empleadoAdapter = RuntimeTypeAdapterFactory.of(Vehiculo.class, "type");
        empleadoAdapter.registerSubtype(Turismo.class, "Turismo");
        empleadoAdapter.registerSubtype(Furgoneta.class, "Furgoneta");
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapterFactory(empleadoAdapter);
        return  builder.create();
    }
}
