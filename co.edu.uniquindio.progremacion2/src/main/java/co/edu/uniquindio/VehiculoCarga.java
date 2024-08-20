package co.edu.uniquindio;

/**
 * Clase Hija VehiculoCarga
 */
public class VehiculoCarga extends Vehiculo {
    private double capacidadCarga;

    /**
     * Constructor Vehiculo Transporte
     * @param marca
     * @param modelo
     * @param color
     * @param placa
     * @param capacidad
     */
    public VehiculoCarga(String marca, String modelo, String placa, String color, double capacidad) {
        super(marca, modelo, placa, color);
        this.capacidadCarga = capacidad;
    }

    /**
     * Constructor Vacio
     */
    public VehiculoCarga(){
        super();
    }

    /**
     * Metodo toString para obtener la informacion de un vehiculo de carga
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "Capacidad: " + capacidadCarga + "\n";
    }
    /*
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     */

    /**
     * Gets y Sets
     * @return
     */
    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
}

