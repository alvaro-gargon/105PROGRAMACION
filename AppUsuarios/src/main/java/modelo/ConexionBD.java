/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.DaoException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ambrosio
 */
public class ConexionBD {
    private static ConexionBD conexion=null;
    public String driver;
    private String url;
    private String user;
    private String pass;
    private static final Logger LOG = Logger.getLogger(ConexionBD.class.getName());
    
    private ConexionBD(String archivoConfig) {
        Properties propiedades=new Properties();
        try(BufferedReader fichero=Files.newBufferedReader(Paths.get(archivoConfig))){
            propiedades.load(fichero);
            url=propiedades.getProperty("url");
            user=propiedades.getProperty("user");
            pass=propiedades.getProperty("pass");
        } catch (FileNotFoundException ex) {
           LOG.severe("Archivo de conexión a la base de datos no encontrado");
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Error de E/S: {0}", ex.toString());
        }
    }
    public static ConexionBD getConexionBD(String archivoConfig){
        if(conexion==null){
            conexion=new ConexionBD(archivoConfig);
        }
        return conexion;
    }
    
   
    public Connection getConnection() throws DaoException {
        Connection con=null; 
            try{
                
                con=DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                throw new DaoException(ex.getMessage());
            }
        return con;
    }
    
}
