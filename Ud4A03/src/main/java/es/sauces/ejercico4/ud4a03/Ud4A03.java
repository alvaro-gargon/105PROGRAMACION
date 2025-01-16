/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.ud4a03;
import java.text.NumberFormat;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.StringJoiner;
import java.util.TimeZone;
/**
 *
 * @author alvaro.gargon.4
 */
public class Ud4A03 {

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena,mes,codigoPais,codigoIdioma,zonaHoraria;
        int opcion,entero,acumulador,m,d,a;
        float media,contador;
        double precio;
        do{
            System.out.println("1.- Calculo de la media.");
            System.out.println("2.- Adivina el número.");
            System.out.println("3.- Dividir cadena.");
            System.out.println("4.- Leer fecha y mostrar formateada.");
            System.out.println("5.- Unir palabras separadas por delimitador.");
            System.out.println("6.- Mostrar la configuración regional y la zona horaria.");
            System.out.println("7.- Cambiar la configuración regional.");
            System.out.println("8.- Cambiar la zona horaria.");
            System.out.println("9.- Mostrar información en distintos formatos.");
            System.out.println("0.- Salir");
            System.out.print("Escoja la opcion deseada: ");
            opcion=teclado.nextInt();
            teclado.nextLine();
            switch(opcion){
                case 1->{
                    acumulador=0;
                    contador=0;
                    entero=leerEntero("Dame numeros enteros");
                    while(entero>=0){
                        acumulador=acumulador+entero;
                        contador++;
                        entero=leerEntero("Dame numeros enteros");
                    }
                    if(contador!=0){
                       
                        media=acumulador/contador;
                        System.out.println("La media es: "+media);
                    }else{
                        System.out.println("No se ha introducido ningun numero");
                    }
                    
                }
                case 2->{
                   Random n= new Random();
                   int aleatorio = n.nextInt(100);
                   System.out.println("Introduce un numero ente 1 y 99 a ver si lo adivinas");
                   do{
                       entero=leerEntero("Un numero entre 1 y 99 por favor");
                   }while(entero>99 || entero<1);
                   contador=0;
                   while(aleatorio!=entero){
                       contador++;
                       if(aleatorio>entero){
                           System.out.println("El numero aleatorio es mayor");
                       }else{
                           System.out.println("El numero aleatorio es menor");
                       }
                       entero=leerEntero("Introduce otro numero");
                   }
                   System.out.println("Este ha sido el numero de intentos: "+contador);
                }
                case 3->{
                    System.out.println("Dame una cadena");
                    cadena=teclado.nextLine();
                    StringTokenizer tokens = new StringTokenizer(cadena);
                    contador=0;
                    while(tokens.hasMoreTokens()){
                        contador=tokens.countTokens();
                        System.out.println(tokens.nextToken());
                    }
                    System.out.println("Hay un total del: "+contador+" palabras");
                }
                case 4->{
                    System.out.println("Dame una fecha en este formato: dd-mm-aaaa; escribe también los guiones y ceros necesarios");
                    cadena=teclado.nextLine();
                    StringTokenizer tokens = new StringTokenizer(cadena, "-");
                    if(tokens.countTokens()==3){
                        d=Integer.parseInt(tokens.nextToken());
                        m=Integer.parseInt(tokens.nextToken());
                        a=Integer.parseInt(tokens.nextToken());
                        mes=switch(m){
                            case 1->"enero";
                            case 2->"febrero";
                            case 3->"marzo";
                            case 4->"abril";
                            case 5->"mayo";
                            case 6->"junio";
                            case 7->"julio";
                            case 8->"agosto";
                            case 9->"septiembre";
                            case 10->"octubre";
                            case 11->"noviembre";
                            default->"diciembre";
                        };
                        System.out.println(d+" de "+m+" de "+a);
                    }else{
                        System.out.println("Error en el formato");
                    }
                }
                case 5->{
                    System.out.println("Dame cadenas, si quieres salir escribe FIN");
                    cadena=teclado.nextLine();
                    StringJoiner sj = new StringJoiner(",   ", "[", "]");
                    while(!cadena.equalsIgnoreCase("fin")){
                        sj.add(cadena);
                        System.out.println("Dame cadenas, si quieres salir escribe FIN");
                        cadena=teclado.nextLine();
                    }
                    System.out.println(sj);
                }
                case 6->{
                    System.out.println(Locale.getDefault()+" , "+TimeZone.getDefault());
                }
                case 7->{
                    System.out.println("Dame tu codigo de pais y tu codigo de idioma");
                    codigoPais=teclado.nextLine();
                    codigoIdioma=teclado.nextLine();
                    Locale.setDefault(Locale.of( codigoIdioma,codigoPais));
                    System.out.println("Pais: "+Locale.getDefault().getDisplayCountry());
                    System.out.println("Pais: "+Locale.getDefault().getDisplayLanguage());
                }
                case 8->{
                    System.out.println("Dame tu zona horario(ejemplo formato: Europe/London)");
                    zonaHoraria=teclado.nextLine();
                    TimeZone.setDefault(TimeZone.getTimeZone(zonaHoraria));
                    System.out.println(LocalTime.now());
                }
                case 9->{
                    System.out.println("Introduzca el precio del producto");
                    precio=teclado.nextDouble();
                    NumberFormat nf=NumberFormat.getInstance(Locale.getDefault());
                    System.out.println(nf.format(precio));
                    System.out.println(nf.getCurrency());
                }
            }
        }while(opcion!=0);
    }
    private static int leerEntero(String mensaje){
        int entero;
        Scanner teclado=new Scanner(System.in);
        System.out.println(mensaje);
        while(!teclado.hasNextInt()){
            teclado.nextLine();
        }
        entero=teclado.nextInt();
        return entero;
    }
}
