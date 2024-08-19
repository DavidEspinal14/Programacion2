package co.edu.uniquindio;
import com.sun.tools.javac.Main;

import java.util.Collection;
import java.util.LinkedList;

public class Propietario {
    private String nombre;
    private String id;
    private String email;
    private String telefono;
    private int edad;
    private Collection<Vehiculo> vehiculos;

    /**
     * Constructor de la clase Propietario
     * @param nombre
     * @param id
     * @param email
     * @param telefono
     */
    public Propietario(String nombre, String id, String email, String telefono, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
        vehiculos = new LinkedList<Vehiculo>();
    }

    /**
     * Constructor vacio
     */
    public Propietario() {
    }
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    /**
     * Metodo para crear un propietario
     * @return
     */
    public static Propietario crearPropietario() {
        String nombre = MainTransporte.entradaTexto("Ingrese el nombre de su propietario");
        String id = MainTransporte.entradaTexto("Ingrese el id del propietario");
        String email = MainTransporte.entradaTexto("Ingrese el email de su propietario");
        String telefono = MainTransporte.entradaTexto("Ingrese el telefono de su propietario");
        double edad = MainTransporte.entradaNumerica("Ingrese la edad de su propietario");

        return new Propietario(nombre, id, email, telefono, 0);
    }
    /**
     * Metodo toString de propietario para obtener toda su info
     */
    public String toString(){
        return "=======================INFORMACION DEL PROPIETARIO=======================\n" + "nombre: " + nombre + "\n" + "id: " + id + "\n" + "email: " + email + "\n" + "telefono: " + telefono + "\n" + "=========================================================================\n";
    }
    /*
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     */
    /**
     * Seccion getters y setters
     */
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getEdad() {return edad;}

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {this.edad = edad;}
}

