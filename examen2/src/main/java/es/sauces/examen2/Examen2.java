/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.examen2;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author Ambrosio
 */
public class Examen2 {

    private static final Logger LOG = Logger.getLogger("es.sauces.examen2");
    
    public static void main(String[] args) throws IOException, NumeroFormatException {
        LogManager.getLogManager().readConfiguration(ClassLoader.getSystemClassLoader().getResourceAsStream("mylogging.properties"));
        Operadora operadora=new Operadora("Sauces Móvil");
        Tarifa tarifa=new Tarifa("Tarifa Habla 6",0.30f,0.06f,0.18f,1000);
        LineaMovil lineaMovil=new LineaMovil("666666666","12345678Z",tarifa);
        
        
    }
}
