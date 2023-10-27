package Ejercicio5;


/*
* Ejercicio 5:
* Diseñar un pequeño programa que implemente un HILO.
* En las tareas de primer plano se le debe pedir al usuario 3 numeros enteros
* En las tareas de segundo plano se deben realizar
* las operaciones aritmeticas BASICAS.
* A+b+c
* A-b-c
* A*B*C
* A/B/C
*/


import java.io.File;
import java.util.Scanner;

public class Hilos extends Thread{

    int n1, n2, n3;

    public Hilos(int num1, int num2, int num3 ) {
        this.n1 = num1;
        this.n2 = num2;
        this.n3 = num3;
    }

    public void run() {
        //Tarea en segundo plano
        int sum = 0, res = 0, div = 0, multi = 0;

        sum = suma(n1,n2,n3);
        res = resta(n1,n2,n3);
        div = division(n1,n2,n3);
        multi = multiplicacion(n1,n2,n3);


        System.out.println("Tarea de calculadora en segundo plano");
        System.out.println("Resultado de la suma: " + sum);
        System.out.println("Resultado de la resta: " + res);
        System.out.println("Resultado de la division: " + div);
        System.out.println("Resultado de la multiplicacion: " + multi);

    }

    public int suma(int n1, int n2, int n3) {

        return n1 + n2 + n3;
    }

    public int resta(int n1, int n2, int n3) {

        return n1 - n2 - n3;
    }

    public int division(int n1, int n2, int n3) {

        return n1 / n2 / n3;
    }

    public  int multiplicacion(int n1, int n2, int n3) {

        return n1 * n2 * n3;
    }

    public static void main (String [] args) {
        Scanner scaner = new Scanner(System.in);
        int n1, n2, n3;
        System.out.println("Tarea en primer plano: Iniciando la aplicación");
        System.out.println("Introduce el primer numero: ");
        n1 = scaner.nextInt();
        System.out.println("Introduce el segundo numero:");
        n2 = scaner.nextInt();
        System.out.println("Introduce el tercer numero: ");
        n3 = scaner.nextInt();

        Hilos calculadora = new Hilos(n1,n2,n3);
        calculadora.start();

    }
}
