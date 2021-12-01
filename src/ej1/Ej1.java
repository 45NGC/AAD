package ej1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej1 {
    public static void main(String[]args){
        Scanner ent = new Scanner(System.in);
        boolean fin=false;
        int opcion;
        do{
            opcion=menu(ent);
            switch (opcion) {
                case 1 -> ej1();
                case 2 -> ej2();
                case 3 -> ej3();
                case 4 -> ej4(ent);
                case 5 -> ej5();
                case 6 -> fin = true;
            }
        }while(!fin);
        ent.close();
    }

    static void ej1(){
        int num=1;
        /*este while suma de dos en dos hasta llegar a 100 y despues sale del bucle e imprime el 100 aparte*/
        while(num<100){
            System.out.println(num);
            num=num+2;
        }
        System.out.println("100");
    }

    static void ej2(){
        int num = 2;
        while (num < 25) {
            System.out.println(num);
            num += 2;
        }
    }

    static void ej3(){
        int num=0, acumulador=0;
        //El while recorre todos los numeros hasta el valor introducido y en el acumulador se van sumando
        while(num<=100){
            acumulador=acumulador+num;
            num += 1;
        }
        System.out.println(acumulador);
    }

    static void ej4(Scanner ent){
        int factorial,num,i,otro;
        boolean error;

        do{
            num=0;
            factorial=1;
            /*introducimos numero*/
            do {
                error=false;
                try {
                    System.out.println("Introduce un numero para realizar el producto factorial");
                    num = ent.nextInt();
                }catch (InputMismatchException ime){
                    System.out.println("ERROR");
                    ent.nextLine();
                    error=true;
                }
            }while(error);


            //Si el numero introducido se corresponde con el 0 o con el 1 el factorial es 1
            //por lo que no se tiene que entrar en el bucle for
            if(num!=0 && num!=1){
                //El bucle for recorre los numeros y los va multiplicando hasta alcanzar
                //el numero introducido
                for(i=2;i<=num;i++){
                    factorial=factorial*i;
                }
            }

            System.out.println();
            System.out.println(factorial);


            /*estos print solo se utilizan para separar el producto factorial de la proposicion
             * de querer hacer otro producto factorial*/
            System.out.println();
            System.out.println();

            /*damos la opcion al usuario de realizar una nueva operacion*/
            do{
                otro=0;
                try {
                    System.out.println("¿Desea realizar otro producto factorial?    (1=si  0=no)");
                    otro = ent.nextInt();
                }catch (InputMismatchException ime){
                    System.out.println("ERROR");
                    ent.nextLine();
                }

            }while(otro!=1 && otro!=0);
        }while(otro==1);
    }

    static void ej5(){
        int num=1,divisor;
        boolean primo=true;

        while(num<150){

            //El for comprueba si el numero es divisible por cualquier numero que se encuentre
            //entre 1 y la mitad de el numero introducido
            for(divisor=2;divisor<=num/2;divisor++){

                if(num%divisor==0){
                    //Si el numero es divisible (el resto=0) se activa este booleano y se sale del bucle for
                    primo=false;
                    divisor=160;
                }
            }
            if(primo){
                System.out.println(num);
            }
            primo=true;
            num++;
        }
    }

    static int menu(Scanner ent){
        int opcion=0 ;

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("1- Numeros del 1 al 100 de dos en dos");
        System.out.println("2- Numeros pares del 1 al 25");
        System.out.println("3- Suma de los numeros del 1 al 100");
        System.out.println("4- Calcular el factorial de un numero introducido");
        System.out.println("5- Lista de numeros primos del 1 al 150");
        System.out.println("6- Fin");
        System.out.println();
        do{
            try {
                System.out.println("Seleccione una opcion: ");
                opcion = ent.nextInt();
            }catch (InputMismatchException ime){
                System.out.println("ERROR");
                ent.nextLine();
            }
        }while(opcion<1 || opcion>6);

        return opcion;
    }
}

