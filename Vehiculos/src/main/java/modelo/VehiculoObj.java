/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo.VehiculoDao;
import modelo.Vehiculo;
import modelo.DaoException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class VehiculoObj implements VehiculoDao {
 
    Path path;
    private static final Logger LOG = Logger.getLogger(VehiculoObj.class.getName());
 
    public VehiculoObj(String path) {
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
        Vehiculo e;
        try (InputStream is = Files.newInputStream(Paths.get(path.toString())); 
                ObjectInputStream entrada = new ObjectInputStream(is)) {
            while (is.available() > 0) {
                e = (Vehiculo) entrada.readObject();
                lista.add(e);
            }
        } catch (EOFException eofe) {
            LOG.info("Fin de fichero");
            throw new DaoException("Fin de fichero");
        } catch (ClassNotFoundException cnfe) {
            LOG.info("Objeto no esperado");
            throw new DaoException("Objeto no esperado");
        } catch (IOException ioe) {
            LOG.info("Error ed entrada/salida");
            throw new DaoException("Error de entrada/salida");
        }
 
        return lista;
    }
 
    @Override
    public int insertar(List<Vehiculo> vehiculos) throws DaoException {
        int cont;
        cont = 0;
        try (ObjectOutputStream salida = new ObjectOutputStream(Files.newOutputStream(Paths.get(path.toString())))) {
            for (Vehiculo e : vehiculos) {
                salida.writeObject(e);
                cont++;
            }
        } catch (FileNotFoundException fnfe) {
            LOG.info("No existe el fichero");
            throw new DaoException("No existe el ficheri");
        } catch (IOException ioe) {
            LOG.info("Error de entrada/salida");
            throw new DaoException("Error de entrada/salida");
        }
        return cont;
    }
 
}
