package boletin2AAD;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Boletin2AAD {
    public static void main(String[]args) {
        Scanner ent = new Scanner(System.in);
        boolean fin = false;
        int opcion;
        do {
            opcion=menu(ent);
            switch (opcion) {
                case 1 -> ej1();
                case 2 -> ej2();
                case 3 -> ej3(ent);
                case 4 -> ej4(ent);
                case 5 -> ej5(ent);
                case 6 -> fin = true;
            }
        } while (!fin);
        ent.close();
    }

    static void ej1() {
        //Sucesion de fibonacci (5 primeros numeros)
        int num1=0, num2=1, aux, cont=0;

        System.out.println("Sucesion de Fibonacci :");

        while (cont<5) {
            System.out.print(num2+" ");

            aux=num2;
            num2=num2+num1;
            num1=aux;

            cont++;
        }
    }

    static void ej2(){
        System.out.println("Este ejercicio esta realizado en python");
    }

    static void ej3(Scanner ent) {
        //Calcular el area y la longitud de una circunferencia
        boolean error,error2;
        float radio;
        int otro;

        do {
            radio=0;
            do {
                // El error2 lo utilizo porque si introduces un numero negativo y luego una
                // letra esta linea salta el 'if' de la linea 255 y tienes que pulsar intro
                // o cualquier otra tecla para continuar
                error=false;
                error2=false;
                try {
                    System.out.println("Introduza el radio de la circunferencia: ");
                    radio=ent.nextInt();
                } catch (InputMismatchException ime) {
                    System.out.println("ERROR");
                    error=true;
                    error2=true;
                    ent.nextLine();
                }
                // Filtro para evitar que el usuario introduza numeros negativos
                if(radio<0&& !error2){
                    System.out.println("Una circunferencia no puede tener un radio negativo, introduza un numero positivo");
                    ent.nextLine();
                    error=true;
                }
            } while(error);

            System.out.println();
            System.out.println("Longitud de la circunferencia : " + (2*Math.PI*radio));
            System.out.println();
            System.out.println("Area del circulo : "+(Math.PI*(radio*radio)));
            System.out.println();

            /*damos la opcion al usuario de realizar una nueva operacion*/
            do {
                otro=3;
                try {
                    System.out.println("¿Desea realizar otro calculo?    (1=si  0=no)");
                    otro=ent.nextInt();
                } catch (InputMismatchException ime) {
                    System.out.println("ERROR");
                    ent.nextLine();
                }

            } while (otro!=1&&otro!=0);

        } while (otro==1);
    }

    static void ej4(Scanner ent){
        // Menu de factores de conversion
        boolean fin = false;
        int opcion;
        do {
            opcion=menuEj4(ent);
            switch (opcion) {
                case 1 -> factor1(ent);
                case 2 -> factor2(ent);
                case 3 -> factor3(ent);
                case 4 -> fin = true;
            }
        } while (!fin);
    }

    static void factor1(Scanner ent){
        // Factor de conversion de km/h ---> m/s
        float kmh;
        boolean error;
        int otro;

        do{
            kmh=0;

            do{
                error=false;
                try {
                    System.out.println("Introduza la cantidad de km/h que desea convertir a m/s: ");
                    kmh=ent.nextInt();
                }catch (InputMismatchException ime){
                    System.out.println("ERROR");
                    error=true;
                    ent.nextLine();
                }
            }while(error);

            System.out.println(kmh+" km/h  =  "+((kmh*1000)/3600)+" m/s");
            System.out.println();

            /*damos la opcion al usuario de realizar una nueva operacion*/
            do{
                otro=3;
                try {
                    System.out.println("¿Desea realizar otro factor de conversion de km/h a m/s?    (1=si  0=no)");
                    otro=ent.nextInt();
                }catch (InputMismatchException ime){
                    System.out.println("ERROR");
                    ent.nextLine();
                }

            }while(otro!=1 && otro!=0);

        }while(otro==1);
    }

    static void factor2(Scanner ent){
        // Factor de conversion de km/h ---> mi/h
        float kmh;
        int otro;
        boolean error;

        do{
            kmh=0;

            do{
                error=false;
                try {
                    System.out.println("Introduza la cantidad de km/h que desea convertir a mi/h: ");
                    kmh=ent.nextInt();
                }catch (InputMismatchException ime){
                    System.out.println("ERROR");
                    error=true;
                    ent.nextLine();
                }
            }while(error);

            System.out.println(kmh+" km/h  =  "+(kmh*0.621371)+" mi/h");
            System.out.println();

            /*damos la opcion al usuario de realizar una nueva operacion*/
            do{
                otro=3;
                try {
                    System.out.println("¿Desea realizar otro factor de conversion de km/h a mi/h?    (1=si  0=no)");
                    otro=ent.nextInt();
                }catch (InputMismatchException ime){
                    System.out.println("ERROR");
                    ent.nextLine();
                }

            }while(otro!=1 && otro!=0);

        }while(otro==1);

    }

    static void factor3(Scanner ent){
        float mih;
        int otro;
        boolean error;

        do{
            mih=0;

            do{
                error=false;
                try {
                    System.out.println("Introduza la cantidad de mi/h que desea convertir a m/s: ");
                    mih=ent.nextInt();
                }catch (InputMismatchException ime){
                    System.out.println("ERROR");
                    error=true;
                    ent.nextLine();
                }
            }while(error);

            System.out.println(mih+" mi/h  =  "+((mih*1609.34)/3600)+" m/s");
            System.out.println();

            /*damos la opcion al usuario de realizar una nueva operacion*/
            do{
                otro=3;
                try {
                    System.out.println("¿Desea realizar otro factor de conversion de mi/h a m/s?    (1=si  0=no)");
                    otro=ent.nextInt();
                }catch (InputMismatchException ime){
                    System.out.println("ERROR");
                    ent.nextLine();
                }

            }while(otro!=1 && otro!=0);

        }while(otro==1);

    }

    static void ej5(Scanner ent){
        //Comprobar si un numero es perfecto
        int num,suma_divisores,otro,i;
        boolean error,error2;

        do{
            num=0;
            suma_divisores=0;

            /*introducimos numero*/
            do {
                // El error2 lo utilizo porque si introduces un numero negativo y luego una
                // letra esta linea salta el 'if' de la linea 255 y tienes que pulsar intro
                // o cualquier otra tecla para continuar
                error=false;
                error2=false;

                try {
                    System.out.println("Introduce un numero para comprobar si es perfecto: ");
                    num=ent.nextInt();
                }catch (InputMismatchException ime){
                    System.out.println("ERROR");
                    ent.nextLine();
                    error=true;
                    error2=true;
                }
                // Filtro para evitar que el usuario introduza numeros negativos
                if(num<0 && !error2){
                    System.out.println("Un numero negativo no puede ser perfecto, introduza uno positivo");
                    ent.nextLine();
                    error=true;
                }
            }while(error);

            /*comprobamos si el numero es perfecto*/
            for(i=1;i<num;i++){
                /*
                recorremos todos los numeros desde el 0 al propio numero (sin incluirlo)
                y comprobamos si son o no son divisores del numero introducido
                */
                if(num%i==0){
                    suma_divisores=suma_divisores+i;
                }
                /*
                si la suma de los divisores es mayor que el propio numero este NO es perfecto
                si esto sucede le hacemos salir del bucle para que no haga operaciones innecesarias
                */
                if(suma_divisores>num){
                    System.out.println("El numero introducido no es perfecto");
                    System.out.println();
                    i=num;
                }
            }

            /*
            si la suma de los divisores es igual a el numero introducido el numero es perfecto
            y si es menor el numero no es perfecto
            */

            if(suma_divisores<num){
                System.out.println("El numero introducido no es perfecto");
                System.out.println();
            }

            if(suma_divisores==num){
                System.out.println("El numero introducido es perfecto");
                System.out.println();
            }

            /*damos la opcion al usuario de realizar una nueva operacion*/
            do{
                otro=3;
                try {
                    System.out.println("¿Desea realizar otra comprobacion de numero perfecto?    (1=si  0=no)");
                    otro=ent.nextInt();
                }catch (InputMismatchException ime){
                    System.out.println("ERROR");
                    ent.nextLine();
                }
            }while(otro!=1&&otro!=0);
        }while(otro==1);
    }


    static int menu(Scanner ent){
        int opcion=0 ;

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("1- Sucesion de Fibonacci (5 primeros numeros)");
        System.out.println("2- Calcular derivadas propias");
        System.out.println("3- Calcular longitud y area de una circunferencia apartir del radio de esta");
        System.out.println("4- Factor de conversion km/h a m/s");
        System.out.println("5- Comprobar si un numero es perfecto");
        System.out.println("6- Fin");
        System.out.println();
        do{
            try {
                System.out.println("Seleccione una opcion: ");
                opcion=ent.nextInt();
            }catch (InputMismatchException ime){
                System.out.println("ERROR");
                ent.nextLine();
            }
        }while(opcion<1||opcion>6);

        return opcion;
    }

    static int menuEj4(Scanner ent){
        int opcion=0 ;

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Factores de conversion:");
        System.out.println("1- km/h ---> m/s");
        System.out.println("2- km/h ---> mi/h");
        System.out.println("3- mi/h ---> m/s");
        System.out.println("4- Fin");
        System.out.println();
        do{
            try {
                System.out.println("Seleccione una opcion: ");
                opcion=ent.nextInt();
            }catch (InputMismatchException ime){
                System.out.println("ERROR");
                ent.nextLine();
            }
        }while(opcion<1||opcion>4);

        return opcion;
    }
}
