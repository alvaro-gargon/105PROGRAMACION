/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo.MatriculaException;
import modelo.VehiculoDao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvaro.gargon.4
 */
public class VehiculoCsv implements VehiculoDao{
    private static final Logger LOG = Logger.getLogger(VehiculoCsv.class.getName());
 
    private Path path;
 
    public VehiculoCsv(String path) {
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
        List lista = new ArrayList<>();
        String linea;
        String[] parte;
        Vehiculo e;
        try (BufferedReader fichero = Files.newBufferedReader(path)) {
                linea=fichero.readLine();
                while(linea!=null){
                    parte=linea.split(",");
                    switch(parte[0]){
                        case "Turismo"->{    
                        e=new Turismo(parte[1],Grupo.valueOf(parte[2]),Integer.parseInt(parte[3]));
                        lista.add(e);
                        }
                        case "Furgoneta"->{
                        e=new Furgoneta(parte[1],Grupo.valueOf(parte[2]),Float.parseFloat(parte[3]));
                        lista.add(e);
                        }
                    }
                    linea=fichero.readLine();
                }
        } catch (IOException | MatriculaException|NumberFormatException|ArrayIndexOutOfBoundsException ex) {
            LOG.log(Level.WARNING, "Ha ocurrido un error: "+ex.toString());
            throw new DaoException(ex.toString());
        }
        return lista;
    }
 
    @Override
    public int insertar(List<Vehiculo> vehiculos) throws DaoException {
        int cont;
        cont = 0;
        try (BufferedWriter fichero = Files.newBufferedWriter(path)){
            for(Vehiculo e:vehiculos){
            fichero.write(e.getClass().getSimpleName() + "," + e.toString());            
            fichero.newLine();
            cont++;
            }
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
        return cont;
    }
}
