
public class DatosPersonales {

    private String nombre = "Tamara";
    private String apellidos = "Huertas Smolis";
    private String puesto = "Desarrolladora";
    private String ciudad = "Madrid";

    public DatosPersonales() {

    }

    public DatosPersonales(String nombre, String apellidos, String puesto, String ciudad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.puesto = puesto;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPuesto () {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String toString() {
        return "DatosPersonales{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", puesto='" + puesto + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}








