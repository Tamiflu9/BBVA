package Examen;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Examen {

    public static void main (String [] args ) {
        String vacio = "";

        try {
            Files.write(Paths.get("C:\\curso\\src\\src\\Ejercico6\\examen.txt"),vacio.getBytes());
            LocalDate fecha1 = LocalDate.of(2023, Month.APRIL, 12);
            LocalDate fecha2 = LocalDate.of(2023, Month.JUNE, 23);
            LocalDate fecha3 = LocalDate.of(2023, Month.AUGUST, 9);

            Cliente c1 = new Cliente(1,"Laura tiene un perro", "comedia", fecha1, "ENTREGADO");
            Cliente c2 = new Cliente(2,"Las margaritas", "romatico", fecha2, "PASO FECHA DE ENTREGA");
            Cliente c3 = new Cliente(3,"kika superbruja", "infantil", fecha3, "ENTREGADO");

            Thread hilo1 = new Thread(new Escribir(c1));
            Thread hilo2 = new Thread(new Escribir(c2));
            Thread hilo3 = new Thread(new Escribir(c3));

            hilo1.setPriority(Thread.MAX_PRIORITY);
            hilo2.setDaemon(true);
            hilo1.start();
            hilo2.start();
            hilo3.start();

        } catch(IOException e) {
            e.printStackTrace();
        }


    }
}

class Cliente {

    private int IDCliente;
    private String nombre_libro;
    private String genero;
    private LocalDate fecha_publicacion;
    private String estado_solicitud;

    public Cliente(int IDCliente, String nombre_libro, String genero, LocalDate fecha_publicacion, String estado_solicitud) {
        this.IDCliente = IDCliente;
        this.nombre_libro = nombre_libro;
        this.genero = genero;
        this.fecha_publicacion = fecha_publicacion;
        this.estado_solicitud = estado_solicitud;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public String getGenero() {
        return genero;
    }

    public LocalDate getFecha_publicacion() {
        return fecha_publicacion;
    }

    public String getEstado_solicitud() {
        return estado_solicitud;
    }

    @Override
    public String toString() {
        return  "\n" + "\n" + "ID Cliente: " + IDCliente + "\n" +
                "Nombre del libro: " + nombre_libro + "\n" +
                "Genero: " + genero + "\n" +
                "Fecha de publicacion: " + fecha_publicacion + "\n" +
                "Estado de solicitud: " + estado_solicitud + "\n"
                + diasDevolucion(this.fecha_publicacion) + segmentacion(this.estado_solicitud);
    }

    public String diasDevolucion(LocalDate fecha_publicacion) {
        LocalDate fech_actual = LocalDate.of(2023, Month.OCTOBER, 10);
        long dias = Math.abs(ChronoUnit.DAYS.between(fech_actual, fecha_publicacion));
        String msg = "Fecha actual del pedido: " + fech_actual + "\n";
        msg += "Dias de diferencia: " + dias + "\n";
        return msg;
    }

    public String segmentacion(String estado_solicitud) {
        String estado = "Segmentacion: ";
        if(this.estado_solicitud == "ENTREGADO"){
            estado += "Cliente al día" + "\n";
        }else if(this.estado_solicitud == "PASO FECHA DE ENTREGA"){
            estado += "El Cliente no esta al día" + "\n";
        }
        return estado;
    }
}

class Escribir implements Runnable {

    private Cliente cliente;

    private String ruta = "C:\\curso\\src\\src\\Examen\\";
    private String nombreArchivo = "examen.txt";
    private String ruta_NombreArchivo = ruta + nombreArchivo;

    private File archivo = new File(ruta_NombreArchivo);

    private String contenido = "";

    public Escribir(Cliente c1) {
        this.cliente = c1;
    }

    @Override
    public void run() {

        try {
            if(!archivo.exists()) {
                archivo.createNewFile();
            }

            FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter (fw);

            contenido = cliente.toString();
            bw.write(contenido);
            bw.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
