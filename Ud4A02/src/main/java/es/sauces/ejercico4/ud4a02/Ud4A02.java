/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.sauces.ejercico4.ud4a02;

import java.util.Scanner;

/**
 *
 * @author alvaro.gargon.4
 */
public class Ud4A02 {

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int opcion,opcion2,i;
        double area;
        char letraDNI;
        boolean esPrefijo, esSufijo,esMonovocalica;
        String cadena1, cadena2;
        System.out.println("Bienvenido a la consola de opciones");
        do{
            System.out.println("1.- Mostrar el sistema operativo, el usuario, el directorio home del usuario y la versión del JRE");
            System.out.println("2.- Mostrar la mayor de dos cadenas primero");
            System.out.println("3.- Comprobar prefijo y sufijo.");
            System.out.println("4.- Buscar una cadena en otra.");
            System.out.println("5.- Convertir una cadena a mayusculas.");
            System.out.println("6.- Reemplazar caracteres espacios en blancos a subrrayado.");
            System.out.println("7.- Repetir una cadena.");
            System.out.println("8.- Mostrar la letra del DNI.");
            System.out.println("9.- Insertar una cadena en otra.");
            System.out.println("10.- Comprobar palíndromo.");
            System.out.println("11.- Calcular el área de un círculo.");
            System.out.println("12.- Calcular el área de un triángulo");
            System.out.println("13.- Comprobar monovocálica.");
            System.out.println("14.- Convertir a binario y a hexadecimal.");
            System.out.println("0.- Salir");
            System.out.print("Escoja la opcion deseada: ");
            opcion=teclado.nextInt();
            teclado.nextLine();
            switch(opcion){
                case 1 -> System.out.println("Nombre del sistema operativo: "+System.getProperty("os.name")+" Usuario: "+System.getProperty("user.name")+" directorio home: "+System.getProperty("user.home")+" version del JRE: "+System.clearProperty("java.version"));
                case 2 ->{ 
                    System.out.println("Dame dos cadenas, la primera: ");
                    cadena1=teclado.nextLine();
                    System.out.println("La segunda: ");
                    cadena2=teclado.nextLine();
                    if(cadena1.compareToIgnoreCase(cadena2)<0){
                        System.out.println(cadena1+" "+cadena2);
                    }else{
                        System.out.println(cadena2+" "+cadena1);
                        }
                }
                case 3-> {
                    System.out.println("Dame dos cadenas, la primera: ");
                    cadena1=teclado.nextLine();
                    System.out.println("La segunda: ");
                    cadena2=teclado.nextLine();
                    esPrefijo=cadena1.startsWith(cadena2);
                    esSufijo=cadena1.endsWith(cadena2);
                    if(esPrefijo){
                        if(esSufijo){
                        System.out.println("Es sufijo y prefijo");
                        }else{System.out.println("Es prefijo");}
                    }else{
                        if(esSufijo){
                            System.out.println("Es sufijo");
                        }else{System.out.println("No es prefijo ni sufijo");}
                    }
                }
                case 4->{
                    System.out.println("Dame dos cadenas, la primera: ");
                    cadena1=teclado.nextLine();
                    System.out.println("La segunda: ");
                    cadena2=teclado.nextLine();
                    if(cadena1.contains(cadena2)){
                        System.out.println("Si esta en la posicion "+cadena1.indexOf(cadena2));                        
                    }else{System.out.println("NO se ha encontrado la cadena");}
                }
                case 5->{
                    System.out.println("Dame una cadena: ");
                    cadena1=teclado.nextLine();
                    System.out.println(cadena1.toUpperCase());
                }
                case 6->{
                    System.out.println("Dame una cadena: ");
                    cadena1=teclado.nextLine();
                    cadena2=cadena1.replace(" ","_");
                    System.out.println(cadena1);
                    System.out.println(cadena2);
                }
                case 7->{
                    System.out.println("Dame una cadena: ");
                    cadena1=teclado.nextLine();
                    System.out.println("Dame un numero: ");
                    opcion2=teclado.nextInt();
                    cadena2=cadena1.repeat(opcion2);
                    System.out.println(cadena2);
                }
                case 8->{
                    System.out.println("Dame un dni");
                    opcion2=teclado.nextInt();
                    opcion2=opcion2%23;
                    cadena1="TRWAGMYFPDXBNJZSQVHLCKE";
                    letraDNI=cadena1.charAt(opcion2);
                    System.out.println(letraDNI);
                }
                case 9->{
                    StringBuilder cadena;
                    System.out.println("Dame dos cadenas, la primera: ");
                    cadena1=teclado.nextLine();
                    cadena=new StringBuilder(cadena1);
                    System.out.println("La segunda: ");
                    cadena2=teclado.nextLine();
                    opcion=cadena.length()/2;
                    cadena.insert(opcion, cadena2);
                    System.out.println(cadena);
                }
                case 10->{
                    StringBuilder cadena;
                    System.out.println("Dime una palabra: ");
                    cadena1=teclado.nextLine();
                    cadena1=cadena1.toLowerCase();
                    cadena=new StringBuilder(cadena1);
                    cadena.reverse();
                    if(cadena.toString().equalsIgnoreCase(cadena1)){
                        System.out.println("Es un palindromo");
                    }else{
                        System.out.println("No es un palindromo");
                    }  
                }
                case 11->{
                    double radio;
                    System.out.println("Dame el radio de un circulo");
                    radio=teclado.nextInt();
                    area=Math.pow(radio, 2)*Math.PI;
                    System.out.println("El area es: "+area);
                }
                case 12->{
                    double s;
                    int a,b,c;
                    System.out.println("Dame el lado de un triangulo");
                    a=teclado.nextInt();
                    System.out.println("Dame el segundo lado del triagulo");
                    b=teclado.nextInt();
                    System.out.println("Dame el tercer lado del triagulo");
                    c=teclado.nextInt();
                    s=(a+b+c)/2.00;
                    area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
                    System.out.println("El area es: "+area);
                }
                case 13->{
                    char a,primeraVocal=' ';
                    esMonovocalica=true;
                    System.out.println("Dame una palabra");
                    cadena1=teclado.nextLine();
                    cadena1=cadena1.toLowerCase();
                    for(i=0;i<cadena1.length()&& primeraVocal==' ';i++){
                        a=cadena1.charAt(i);
                        if(esVocal(cadena1.charAt(i))){
                            primeraVocal=a;
                        }
                    }
                    if(primeraVocal!=' '){
                         System.out.println("La primera vocal esta en la posicion: "+i);
                        for(;i<cadena1.length()&&esMonovocalica;i++){
                            a=cadena1.charAt(i);
                            if(esVocal(cadena1.charAt(i))){
                                if(a!=primeraVocal){
                                    esMonovocalica=false;
                                }
                            }
                    }
                    if(esMonovocalica){
                        System.out.println("Es monovocalica");
                    }else{System.out.println("No es monovocalica");}
                    }else{
                        System.out.println("No tiene vocales");
                    }
                }
                case 14->{
                    System.out.println("Dame un numero y te lo paso a binario y hexadecimal");
                    opcion=teclado.nextInt();
                    System.out.println(Integer.toBinaryString(opcion));
                    System.out.println(Integer.toHexString(opcion));
                }
            }
        }while(opcion!=0);
        
    }
    private static boolean esVocal(char c){
        return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
    }
}
