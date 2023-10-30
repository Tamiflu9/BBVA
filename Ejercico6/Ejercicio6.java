package Ejercico6;

import java.io.*;

public class Ejercicio6 {

    public static void main (String [] args) {
        String nom = "";
        int cantUsu = 0;
        int costM = 0;

        try {
            File documento = new File("C:\\curso\\src\\src\\Ejercico6\\appGoogle.txt");
            BufferedReader objeto = new BufferedReader(new FileReader(documento));
            String apli = "";

            while((apli = objeto.readLine()) != null) {

                nom = apli.split(": ")[1];
                System.out.println(nom);

                String cUsusarios = objeto.readLine().split(": ")[1];
                cantUsu = Integer.parseInt(cUsusarios);
                System.out.println(cantUsu);

                String cMensual = objeto.readLine().split(": ")[1];
                costM = Integer.parseInt(cMensual);
                System.out.println(costM);


                Aplicacion app = new Aplicacion(nom, cantUsu, costM);
                System.out.println(app.toString());

                Thread hiloNoDemonio = new Thread(new Tarea(app));
                hiloNoDemonio.start();

                try{
                    hiloNoDemonio.join();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }

            }
            objeto.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static class Aplicacion implements iGananciaMensual {
        private String nombre;
        private int cantUsus;
        private int costoM;

        public Aplicacion(String nombre, int cantUsus, int costoM) {
            this.nombre = nombre;
            this.cantUsus = cantUsus;
            this.costoM = costoM;
        }

        public String getNombre() {
            return nombre;
        }

        public int getCantUsus() {
            return cantUsus;
        }

        public int getCostoM() {
            return costoM;
        }
        @Override
        public int gananciaMensual(int cantUsus, int costoM) {
            return cantUsus*costoM;
        }

        @Override
        public int totalUsuarios(int cantUsus) {
            return cantUsus*12;
        }

        @Override
        public String toString() {
            return "Aplicacion{" +
                    "nombre='" + nombre + '\'' +
                    ", cantUsus=" + cantUsus +
                    ", costoM=" + costoM +
                    '}';
        }
    }

    static class Tarea implements Runnable {

        private Aplicacion appT;

        private String ruta = "C:\\curso\\src\\src\\Ejercico6\\";
        private String nombreArchivo = "output_proceso_google.txt";
        private String ruta_NombreArchivo = ruta + nombreArchivo;

        private File archivo = new File(ruta_NombreArchivo);

        private String contenido = "";

        public Tarea(Aplicacion app) {
            this.appT = app;
        }

        @Override
        public void run() {
            try {
                if(! archivo.exists()) {
                    archivo.createNewFile();
                    System.out.println("Se creo el fichero");
                }
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter (fw);
                contenido = "Aplicacion: " + appT.getNombre() + '\'' +
                            "Ganancia neta mensual: " + appT.gananciaMensual(appT.getCantUsus(),appT.getCostoM()) +
                            '\'' + "Total usuarios: " + appT.totalUsuarios(appT.getCantUsus()) +  '\'' ;
                bw.write(contenido);
                bw.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

}
