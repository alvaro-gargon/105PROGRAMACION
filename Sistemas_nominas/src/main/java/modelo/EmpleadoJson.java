/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

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
public class EmpleadoJson implements EmpleadoDao {

    Path path;

    public EmpleadoJson(String path) {
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
    public List<Empleado> listar() throws DaoException {
        java.lang.reflect.Type tipo = new com.google.gson.reflect.TypeToken<List<Empleado>>() {
        }.getType();
        List<Empleado> lista=new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            lista = getGson().fromJson(br, tipo);
        } catch (IOException ioe) {
            throw new DaoException(ioe.toString());
        }
        return lista;
    }

    @Override
    public int insertar(List<Empleado> empleados) throws DaoException {
        Type tipo=new TypeToken<List<Empleado>>() {}.getType();
        int contador;
        contador = 0;
        List<Empleado> lista = new ArrayList<>();
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            getGson().toJson(lista, tipo, bw);
        }catch (IOException ioe) {
            throw new DaoException(ioe.toString());
        }

        return contador;
    }
    
    private Gson getGson(){
        java.lang.reflect.Type tipo = new com.google.gson.reflect.TypeToken<List<Empleado>>() {
        }.getType();
        RuntimeTypeAdapterFactory<Empleado> empleadoAdapter = RuntimeTypeAdapterFactory.of(Empleado.class, "type");
        empleadoAdapter.registerSubtype(EmpleadoFijo.class, "Fijo");
        empleadoAdapter.registerSubtype(EmpleadoEventual.class, "Eventual");
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapterFactory(empleadoAdapter);
        return  builder.create();
    }
}
