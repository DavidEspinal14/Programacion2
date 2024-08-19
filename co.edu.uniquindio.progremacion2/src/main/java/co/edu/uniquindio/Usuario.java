package co.edu.uniquindio;

public class Usuario {
    private String nombre;
    private String edad;
    private String telefono;
    private int peso;
    public Usuario() {

    }
    public Usuario(String nombre, String edad, String telefono, int peso) {
        assert nombre != null;
        assert edad != null;
        assert telefono != null;
        assert peso > 0;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.peso = peso;

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
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
    public int getPeso() {return peso;}
    public void setPeso(int peso) {this.peso = peso;}
}
