package Ejercicio3;

public class Personas {

    private String nombre;
    private String apellido;
    private String ciudad;
    private String fechaNac;

    public Personas(){}
    public Personas(String nombre, String apellido, String ciudad, String fechaNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Personas{" +
                "nombre= " + nombre + '\'' +
                ", apellido= " + apellido + '\'' +
                ", ciudad= " + ciudad + '\'' +
                ", fechaNac= " + fechaNac + '\'' +
                '}';
    }
}
