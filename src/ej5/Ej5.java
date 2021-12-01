package ej5;

// Ejercicio que lista los ficheros de un directorio introducido por el usuario

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej5 {

    public static void main(String[]args){
        Scanner entrada=new Scanner(System.in);
        String rutaDirectorio;
        int otro,i;
        boolean primeraVuelta=true;

        do{
            rutaDirectorio="";
            // En caso de que no se trate de la primera ruta que introduce el usuario vaciamos el buffer de entrada
            if(!primeraVuelta){
                entrada.nextLine(); // Vaciamos el buffer de entrada
            }

            while(rutaDirectorio.equalsIgnoreCase("")){
                System.out.println("Introduza la ruta de un directorio: ");
                rutaDirectorio=entrada.nextLine();
            }

            // A partir del directorio determinamos la carpeta en la que nos encontramos
            File carpeta = new File(rutaDirectorio);

            if(carpeta.exists()){
                // Creamos un array que contenga los archivos del directorio
                File [] ficheros = carpeta.listFiles();

                System.out.println("Archivos dentro del directorio: "+ficheros.length);
                System.out.println();

                // El for recorre el array ficheros (el cual contiene los ficheros de la carpeta) e imprime
                // el nombre de los ficheros hasta que alcance el limite de archivos de la carpeta
                for(i=0;i<ficheros.length;i++){
                    System.out.println("-"+(i+1)+" > "+ficheros[i].getName());
                }
                System.out.println();
            }else{
                System.out.println("El directorio no existe");
                System.out.println();
            }

            primeraVuelta=false; // Este boolean nos servirá para vaciar el buffer de entrada en la siguiente vuelta (si es que la hay)

            // Damos la opcion al usuario de realizar una nueva operacion
            do{
                otro=0;
                try {
                    System.out.println("¿Desea comprobar otro directorio?    (1=si  0=no)");
                    otro=entrada.nextInt();
                }catch (InputMismatchException ime){
                    System.out.println("ERROR");
                    entrada.nextLine();
                }
            }while(otro!=1 && otro!=0);
        }while(otro==1);

    }

}
