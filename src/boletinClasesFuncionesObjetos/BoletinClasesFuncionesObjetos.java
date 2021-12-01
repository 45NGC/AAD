package boletinClasesFuncionesObjetos;

import java.io.IOException;

public class BoletinClasesFuncionesObjetos {

    public static void main(String[]args) throws IOException {
        Teclado entrada =new Teclado();
        int opcion;
        boolean fin=false;
        do {
            opcion=menuPrincipal(entrada);
            switch (opcion) {
                case 1 -> calculadora(entrada);
                case 2 -> indicadorEdadConducir(entrada);
                case 3 -> cualificacionSegunNota(entrada);
                case 4 -> letraDNI(entrada);
                case 5 -> fin=true;
            }
        } while (!fin);
    }

    static int menuPrincipal(Teclado entrada)throws IOException{
        int opcion;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("1- Calculadora");
        System.out.println("2- Edad permitida para conducir");
        System.out.println("3- Cualificación según nota");
        System.out.println("4- Letra DNI");
        System.out.println("5- Fin");
        System.out.println();
        do{
            System.out.println("Seleccione una opcion: ");
            opcion=entrada.leerInt();
        }while(opcion<1 || opcion>5);
        return opcion;
    }

    static void calculadora(Teclado entrada)throws IOException{
        int opcion,otro;
        float num1,num2;
        boolean fin;

        do{
            // El usuario introduce los numeros con los que va a realizar la operacion
            do{
                System.out.println("Las operaciones se realizaran de la siguiente forma: ");
                System.out.println();
                System.out.println("Suma             -->      numero1 + numero2");
                System.out.println("Resta            -->      numero1 - numero2");
                System.out.println("Multiplicacion   -->      numero1 x numero2");
                System.out.println("Division         -->      numero1 / numero2");
                System.out.println();
                System.out.println("Introduce el numero1 : ");
                num1= entrada.leerFloat();
            }while(num1==Float.MIN_VALUE);

            do{
                System.out.println("Las operaciones se realizaran de la siguiente forma: ");
                System.out.println();
                System.out.println("Suma             -->      "+num1+" + numero2");
                System.out.println("Resta            -->      "+num1+" - numero2");
                System.out.println("Multiplicacion   -->      "+num1+" x numero2");
                System.out.println("Division         -->      "+num1+" / numero2");
                System.out.println();
                System.out.println("Introduce el numero2 : ");
                num2= entrada.leerFloat();
            }while(num2==Float.MIN_VALUE);

            // El usuario decide que operacion va a realizar
            fin=false;
            do{
                opcion=menuCalculadora(entrada,num1,num2);
                switch(opcion){
                    case 1 -> Operaciones.sumar(num1,num2);
                    case 2 -> Operaciones.restar(num1,num2);
                    case 3 -> Operaciones.multiplicar(num1,num2);
                    case 4 -> Operaciones.dividir(num1,num2);
                    case 5 -> fin=true;
                }
            }while (!fin);

            // Damos la opcion al usuario de realizar una nueva operacion
            do{
                System.out.println("¿Desea realizar otra operacion?    (1=si  0=no)");
                otro= entrada.leerInt();
            }while(otro!=1 && otro!=0);

        }while(otro==1);
    }

    static int menuCalculadora(Teclado entrada, float num1, float num2)throws IOException{
        int opcion;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("1- Sumar            ---> "+num1+" + "+num2);
        System.out.println("2- Restar           ---> "+num1+" - "+num2);
        System.out.println("3- Multiplicar      ---> "+num1+" x "+num2);
        System.out.println("4- Dividir          ---> "+num1+" / "+num2);
        System.out.println("5- Fin");
        System.out.println();
        do{
            System.out.println("Seleccione una opcion: ");
            opcion= entrada.leerInt();
        }while(opcion<1||opcion>5);
        return opcion;
    }

    static void indicadorEdadConducir(Teclado entrada) throws IOException {
        int otro,edad;
        do{
            // El usuario introduce la edad
            do{
                System.out.println("Introduza su edad: ");
                edad=entrada.leerInt();
            }while(edad==Integer.MIN_VALUE);

            // Si la edad supera o iguala los 18 le indicaremos al usuario que puede
            // conducir, y de lo contrario le indicaremos que no puede
            if(edad>=18){
                System.out.println("Usted si puede conducir");
            }else{
                System.out.println("Usted no puede conducir");
            }

            // Damos la opcion al usuario de realizar una nueva operacion
            do{
                System.out.println("¿Desea realizar otra operacion?    (1=si  0=no)");
                otro=entrada.leerInt();
            }while(otro!=1 && otro!=0);

        }while(otro==1);
    }

    static void cualificacionSegunNota(Teclado entrada)throws IOException{
        int otro;
        float nota;
        do{
            // El usuario introduce su nota
            do{
                System.out.println("Introduza su nota: ");
                nota=entrada.leerFloat();
            }while(nota==Float.MIN_VALUE || nota<0 || nota>10);

            // En funcion de las notas daremos las siguientes notas:
            // 10-9 Sobresaliente
            // 7-9 Notable
            // 6-7 Bien
            // 5-6 Suficiente
            // 3-5 Deficiente
            // 0-3 Muy deficiente
            // Lo intente de esta forma pero no da resultado
            /*
            switch (nota){
                case nota<=3 ->  System.out.println("Muy deficiente");
                case nota>3 && nota<5   -> System.out.println("Deficiente");
                case nota>=5 && nota<6  -> System.out.println("Suficiente");
                case nota>=6 && nota<7  -> System.out.println("Bien");
                case nota>=7 && nota<9  -> System.out.println("Notable");
                case nota>=9            -> System.out.println("Sobresaliente");
            }
            */
            if(nota<=3){
                System.out.println("Muy deficiente");
            }else{
                if(nota>3 && nota<5){
                    System.out.println("Deficiente");
                }else{
                    if(nota>=5 && nota<6){
                        System.out.println("Suficiente");
                    }else{
                        if(nota>=6 && nota<7){
                            System.out.println("Bien");
                        }else{
                            if(nota>=7 && nota<9){
                                System.out.println("Notable");
                            }else{
                                if(nota>=9){
                                    System.out.println("Sobresaliente");
                                }
                            }
                        }
                    }
                }
            }

            // Damos la opcion al usuario de realizar una nueva operacion
            do{
                System.out.println("¿Desea realizar otra operacion?    (1=si  0=no)");
                otro=entrada.leerInt();
            }while(otro!=1 && otro!=0);

        }while(otro==1);
    }

    static void letraDNI(Teclado entrada)throws IOException{
        int numeroDNI,otro;
        char[] letrasDNI = new char[]{'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','D','Q','V','H','L','C','K','E'};
        do{
            // El usuario introduce el numero de su DNI
            do{
                System.out.println("Introduza su DNI: ");
                numeroDNI=entrada.leerInt();
            }while(numeroDNI<10000000 || numeroDNI>99999999);

            // Calculamos la letra de su DNI el resto de la division numeroDNI/23 es equivalente
            // a la posicion de la letra correspondiente en el array de letras DNI creado previamente
            System.out.println();
            System.out.println("La letra de su DNI es: "+letrasDNI[numeroDNI%23]);
            System.out.println();
            System.out.println("Su DNI es : "+numeroDNI+letrasDNI[numeroDNI%23]);

            // Damos la opcion al usuario de realizar una nueva operacion
            do{
                System.out.println("¿Desea realizar otra operacion?    (1=si  0=no)");
                otro=entrada.leerInt();
            }while(otro!=1 && otro!=0);

        }while(otro==1);
    }

}