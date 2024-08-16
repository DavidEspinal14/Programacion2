package co.edu.uniquindio;

public class Usuario {
    private String nombre;
    private String edad;
    private String telefono;
    public Usuario() {

    }
    public Usuario(String nombre, String edad, String telefono) {
        assert nombre != null;
        assert edad != null;
        assert telefono != null;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
