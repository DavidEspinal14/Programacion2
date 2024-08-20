package co.edu.uniquindio;

public class Usuario {
    private String nombre;
    private int edad;
    private String telefono;
    private int peso;
    public Usuario() {

    }
    public Usuario(String nombre, int edad, String telefono, int peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.peso = peso;

    }
    public String toString(){
        return "========INFORMACION DEL USUARIO=========\n"+ "Nombre: "+nombre+"\n"+ "Telefono: "+telefono+"\n==================================\n";
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
    public void setEdad(int edad) {
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
