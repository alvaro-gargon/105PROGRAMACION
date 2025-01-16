/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.ud4a04;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ud4A04 {

    public static void main(String[] args) {
        int opcion,ndias,minutos,contador;
        String fecha,fecha2,hora,cadena,ape1,ape2;
        Scanner teclado=new Scanner (System.in);
        ZonedDateTime salidaVuelo,llegadaVuelo;
        StringBuilder sb;
         do{
            System.out.println("1.- Mostrar fecha y hora del sistema.");
            System.out.println("2.- Mostrar fecha y hora en dos zonas horarias.");
            System.out.println("3.- Sumar un número de días a una fecha.");
            System.out.println("4.- Mostrar la menor de dos fechas.");
            System.out.println("5.- Sumar un número de minutos a una hora.");
            System.out.println("6.- Mostrar si la hora es anterior o posterior.");
            System.out.println("7.- Mostrar la diferencia entre dos fechas.");
            System.out.println("8.- Mostrar la diferencia entre dos horas.");
            System.out.println("9.- Calcular hora de llegada de un vuelo.");
            System.out.println("10.- Número de vocales de una cadena.");
            System.out.println("11.- Iniciales del nombre y apellidos.");
            System.out.println("12.- Información sobre ficheros y directorios.");
            System.out.println("0.- Salir");
            System.out.print("Escoja la opcion deseada: ");
            opcion=teclado.nextInt();
            teclado.nextLine();
            switch(opcion){
                case 1->{
                    System.out.println(LocalDateTime.now());
                    System.out.println(ZonedDateTime.now());
                    System.out.println(OffsetDateTime.now());
                    System.out.println(Instant.now());
                }
                case 2->{
                    System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Tokyo")));
                    System.out.println(ZonedDateTime.now(ZoneId.of("America/New_York")));
                }
                case 3->{
                    System.out.println("Dame una fecha");
                    fecha=teclado.nextLine();
                    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("d-M-yyyy");
                    LocalDate fecha1=LocalDate.parse(fecha,dtf);
                    System.out.println(fecha1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    System.out.println("Dame un numero de dias para sumar a tu fecha");
                    ndias=teclado.nextInt();
                    System.out.println(fecha1.plusDays(ndias).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                }
                case 4->{
                    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("d-M-yyyy");
                    System.out.println("Dame una fecha");
                    fecha=teclado.nextLine();
                    LocalDate fechaP=LocalDate.parse(fecha,dtf);
                    System.out.println("Dame otra fecha");
                    fecha2=teclado.nextLine();
                    LocalDate fechaS=LocalDate.parse(fecha2,dtf);
                    if(fechaP.compareTo(fechaS)>1){
                        System.out.println("La primera fecha es la menor: "+fechaP.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    }else{
                        System.out.println("La segunda fecha es la menor: "+fechaS.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    }
                }
                case 5->{
                    System.out.println("Dame una hora con sus minutos");
                    hora=teclado.nextLine();
                    LocalTime hora1=LocalTime.parse(hora);
                    System.out.println("Dame un numero de minutos para sumar a la hora");
                    minutos=teclado.nextInt();
                    System.out.println(hora1.plusMinutes(minutos));
                }
                case 6->{
                    System.out.println("Dame una hora");
                    hora=teclado.nextLine();
                    LocalTime hora1=LocalTime.parse(hora);
                    if(hora1.compareTo(LocalTime.now())>0){
                        System.out.println("Esta hora es posterior a la del sistema");
                    }else{
                        System.out.println("Esta hora es anterior a la del sistema");
                    }
                }
                case 7->{
                    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("d-M-yyyy");
                    System.out.println("Dame una fecha");
                    fecha=teclado.nextLine();
                    LocalDate fechaP=LocalDate.parse(fecha,dtf);
                    System.out.println(Period.between(fechaP, LocalDate.now()));
                }
                case 8->{
                    System.out.println("Dame una hora");
                    hora=teclado.nextLine();
                    LocalTime hora1=LocalTime.parse(hora);
                    System.out.println(Duration.between(hora1, LocalTime.now()));
                }
                case 9->{
                    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("d-M-yyyy");
                    System.out.println("Dame tu salida de vuelo (dd-mm-aaaa)");
                    fecha=teclado.nextLine();
                    System.out.println("Dame una hora de salida del vuelo(hh-mm)");
                    hora=teclado.nextLine();
                    System.out.println("Dame tu zona horaria(la de salida)");
                    cadena=teclado.nextLine();
                    salidaVuelo=ZonedDateTime.of(LocalDate.parse(fecha,dtf), LocalTime.parse(hora), ZoneId.of(cadena));
                    System.out.println("Cuanto dura tu vuelo (hh:mm)");
                    cadena=teclado.nextLine();
                    StringTokenizer st=new StringTokenizer(cadena,":");
                    minutos=Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
                    System.out.println("Dame tu zona horaria(la de llegada)");
                    cadena=teclado.nextLine();
                    llegadaVuelo=salidaVuelo.plusMinutes(minutos).withZoneSameInstant(ZoneId.of(cadena));
                    System.out.println(llegadaVuelo);
                }
                case 10->{
                    cadena=JOptionPane.showInputDialog("Dame una cadena: ").toLowerCase();
                    contador=0;
                    for(int i=0;i<cadena.length();i++){
                        if(esVocal(cadena.charAt(i))){
                            contador++;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "El numero de vocales es: ");
                    JOptionPane.showMessageDialog(null, contador);
                }
                case 11->{
                    cadena=JOptionPane.showInputDialog("Dame tu nombre y apellidos: ");
                    StringTokenizer tokens = new StringTokenizer(cadena, " ");
                    while(tokens.hasMoreTokens()){
                        cadena=tokens.nextToken();
                        ape1=tokens.nextToken();
                        ape2=tokens.nextToken();
                        JOptionPane.showInputDialog(cadena.charAt(0));
                        JOptionPane.showInputDialog(ape1.charAt(0));
                        JOptionPane.showInputDialog(ape2.charAt(0));
                    }
                }
                case 12->{
                    do{
                    File cadena1;
                    cadena=JOptionPane.showInputDialog("Dame el nombre de un archivo o directorio y te lo busco ");
                    cadena1 = new File(cadena);
                    sb=new StringBuilder();
                    if(cadena1.exists()){
                        sb.append("Existe");
                        if(cadena1.isFile()){
                            sb.append("Es un fichero.");
                        }else{
                            sb.append("Es un directorio.");
                        }
                    }
                    JOptionPane.showMessageDialog(null,sb);
                    }while(JOptionPane.showConfirmDialog(null, "Desea continuar?")==JOptionPane.OK_OPTION);
                }
            }
    }while(opcion!=0);
    }
    private static boolean esVocal(char c){
        return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
    }
}
