package ej2;
//Realizar las descomposicion factorial de un numero dado por el usuario

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej2{
    public static void main(String[]args){
        Scanner ent = new Scanner(System.in);
        int num,divisor,otro;
        boolean error;
        do{
            // Preguntamos al usuario el numero a introducir
            do{
                //Inicializamos el valor de "num" y el de "error"
                num = 0;
                error = false;
                System.out.println("Introduzca el numero a descomponer factorialmente: ");
                try {
                    num = ent.nextInt();
                }catch(InputMismatchException ime){
                    System.out.println("ERROR");
                    ent.nextLine();
                    error = true;
                }

            }while(error);

            // Inicializamos el valor de "divisor"
            divisor = 2;

            // Realizamos la descomposicion factorial de el numero introducido por el usuario anteriormente
            while(num!=1){
                if(num % divisor == 0){
                    num = num/divisor;
                    System.out.println(num);
                }else{
                    divisor++;
                }
            }

            // Preguntamos al usuario si desea realizar una nueva operacion
            do{

                otro = 0;
                error = false;
                System.out.println("¿Descomponer factorialmente otro numero?       (1=si   0=no)");
                try {
                    otro = ent.nextInt();
                }catch(InputMismatchException ime){
                    System.out.println("ERROR");
                    ent.nextLine();
                    error = true;
                }

            }while(error || (otro!=1 && otro!=0));

        }while(otro == 1);

        System.out.println();
        System.out.println();
        System.out.println("FIN PROGRAMA");
        ent.close();
    }
}
