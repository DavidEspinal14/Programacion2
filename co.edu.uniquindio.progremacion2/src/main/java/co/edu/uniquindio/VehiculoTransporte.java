package co.edu.uniquindio;
import java.util.ArrayList;
import java.util.Collection;

public class VehiculoTransporte extends Vehiculo{
    private int maxPasajeros;
    private Collection<Usuario> usuarios;

    /**
     * Constructor VehiculoCarga
     * @param placa
     * @param marca
     * @param modelo
     * @param color
     * @param maxPasajeros
     */
    public VehiculoTransporte(String placa, String marca, String modelo, String color, int maxPasajeros){
        super(placa, marca, modelo, color);
        this.maxPasajeros = maxPasajeros;
        this.usuarios = new ArrayList<Usuario>();
    }

    /**
     * Constructor vacio
     */
    public VehiculoTransporte(){
        super();
    }
    public void agregarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }

    /**
     * Metodo toString para obtener la informacion de un Vehiculo de Transporte
     * @return
     */
    @Override
    public String toString(){
        return super.toString() + "Max Pasajeros: " + maxPasajeros + "\n";
    }
    /*
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     */

    public int getMaxPasajeros() {
        return maxPasajeros;
    }

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setMaxPasajeros(int maxPasajeros) {
        this.maxPasajeros = maxPasajeros;
    }

    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}

