/*
* Actividad 1: programa en java que permita al usuario realizar las 4 operaciones aritmeticas.
* donde el usuario debe insertar dos valores numericos por consola e informa del resultado
*
* Consideraciones:
* - crear un directorio donde se almacene el resusltado de salida.
* - el directorio debe contener el txt con los resultados
* - archivo de salida: resultados.
*
* */

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String [] args) {

        Scanner scaner = new Scanner(System.in);

        int operacion = 0;
        int n1 = 0, n2 = 0;
        String escribir = "";

        System.out.println("Elige que operacion quiere realizar:");
        System.out.println("    1 - suma");
        System.out.println("    2 - resta");
        System.out.println("    3 - multiplicacion");
        System.out.println("    4 - division");

        operacion = scaner.nextInt();

        System.out.println("Introduce el primer numero: ");
        n1 = scaner.nextInt();
        System.out.println("Introduce le segundo numero:");
        n2 = scaner.nextInt();


        switch (operacion) {
            case 1:
                resultado = suma(n1,n2);
                escribir = "resultado de la suma: " + resultado;
                System.out.println("resultado de la suma: " + resultado);
                break;
            case 2:
                resultado = resta(n1, n2);
                escribir = "resultado de la resta: " + resultado;
                System.out.println("resultado de la resta: " + resultado);
                break;
            case 3:
                resultado = multiplicacion(n1, n2);
                escribir = "resultado de la multiplicacion: " + resultado;
                System.out.println("resultado de la multiplicacion: " + resultado);
                break;
            case 4:
                resultado = division(n1, n2);
                escribir = "resultado de la division: " + resultado;
                System.out.println("resultado de la division: " + resultado);
                break;
        }
        
        try {
            Files.write(Paths.get("resultados.txt"), escribir.getBytes());
            System.out.println("Se escribe el archivo");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static int suma(int n1, int n2) {

        return n1 + n2;
    }

    public static int resta(int n1, int n2){

        return n1 - n2;
    }

    public static int division(int n1, int n2){

        return n1 / n2;
    }

    public static int multiplicacion(int n1, int n2) {

        return n1 * n2;
    }

}



