package Ejercicio3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Empleado extends Personas implements iCalcularSueldo{

    private int idEmpleado;
    private String cargo;
    private int antiguedad;
    private int sueldo;

    public Empleado(){
        super();
    }
    public Empleado(int idEmpleado, String cargo, int antiguedad, int sueldo, String nombre,
                    String apellido, String ciudad, String fechaNac) {
        super(nombre, apellido, ciudad, fechaNac);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.antiguedad = antiguedad;
        this.sueldo = sueldo;
    }

    @Override
    public double calculoSueldoFinal(double sueldo) {

        return sueldo/0.8;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado= " + idEmpleado +
                ", cargo= " + cargo + '\'' +
                ", antiguedad= " + antiguedad +
                ", sueldo= " + sueldo +
                '}';
    }

    public static void main (String [] args) {

        String ruta = "C:\\curso\\src\\";
        String nombreArchivo = "proceso_salida.txt";
        String ruta_NombreArchivo = ruta + nombreArchivo;

        File archivo = new File(ruta_NombreArchivo);

        Empleado empleado1 = new Empleado(8,"animadora",2,1000,
                                    "Lucia","Muñoz","Madrid","12/02/1996");
        Empleado empleado2 = new Empleado(9,"cocinero",4,1200,
                                    "Juan","Perez","Madrid","27/06/1995");
        Empleado empleado3 = new Empleado(7,"pescador",5,890,
                                    "Paco","Gil","Madrid","12/04/1986");

        String contenido1 = empleado1.toString() + empleado1.toString() +
                "Sueldo final:" + empleado1.calculoSueldoFinal(empleado1.getSueldo());
        String contenido2 = empleado2.toString() + empleado2.toString() +
                "Sueldo final:" + empleado2.calculoSueldoFinal(empleado2.getSueldo());
        String contenido3 = empleado3.toString() + empleado3.toString() +
                "Sueldo final:" + empleado3.calculoSueldoFinal(empleado3.getSueldo());

        try {
            if(! archivo.exists())
            {
                archivo.createNewFile();
                System.out.println("Se creo el fichero");
            }
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter (fw);
            bw.write(contenido1);
            bw.write(contenido2);
            bw.write(contenido3);
            bw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}
