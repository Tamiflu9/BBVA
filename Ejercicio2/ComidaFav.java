import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ComidaFav extends DatosPersonales{

    private String comida = "gołąbki";

    public ComidaFav(){

    }
    public ComidaFav(String nombre, String apellidos, String puesto, String ciudad, String comida) {
        super(nombre, apellidos, puesto, ciudad);
        this.comida = comida;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    @Override
    public String toString() {
        return "ComidaFav{" +
                "comida='" + comida + '\'' +
                '}';
    }

    public static void main (String [] args) {

        String ruta = "C:\\curso\\src\\";
        String nombreArchivo = "proceso_salida.txt";
        String ruta_NombreArchivo = ruta + nombreArchivo;

        File archivo = new File(ruta_NombreArchivo);

        DatosPersonales persona = new DatosPersonales();
        ComidaFav comida = new ComidaFav();
        String contenido = persona.toString() + comida.toString();
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Apellidos: " + persona.getApellidos());
        System.out.println("Puesto: " + persona.getPuesto());
        System.out.println("Cuidad: " + persona.getCiudad());
        System.out.println("Comida: " + comida.getComida());

        try {
            if(! archivo.exists())
            {
                archivo.createNewFile();
                System.out.println("Se creo el fichero");
            }
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter (fw);
            bw.write(contenido);
            bw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}
