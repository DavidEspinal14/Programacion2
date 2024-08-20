package co.edu.uniquindio;
public class Vehiculo {

    private String marca;
    private String modelo;
    private String placa;
    private String color;
    private Propietario propietario;

    /**
     * Constructor de vehiculo
     * @param marca
     * @param modelo
     * @param placa
     * @param color
     */
    public Vehiculo(String marca, String modelo, String placa, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.color = color;
    }

    /**
     * Constructor Vacio
     */
    public Vehiculo() {
    }

    /**
     * Metodo para agregar propietario
     * @param propietario
     */
    public void agregarPropietario(Propietario propietario) {
        if (propietario == null) {
            setPropietario(propietario);
        }
    }

    /**
     * Metodo toString de Vehiculo
     * @return
     */
    @Override
    public String toString(){
        String info = "";
        if (propietario != null) {
            info = propietario.toString() + "=======================INFORMACION DEL VEHICULO=======================\n" + "Marca: " + marca + "\n" + "Placa: " + placa +"\n" + "Modelo: " + modelo + "\n" + "Color: " + color + "\n";
        }else{
            info = "=======================INFORMACION DEL VEHICULO=======================\n" + "Marca: " + marca + "\n" + "Modelo: " + modelo +"\n"+ "Placa: " + placa +"\n" + "Color: " + color + "\n";
        }
        return info;
    }
    /*
     * --------------------------------------Seccion Getters y Setters--------------------------------------------------
     */

    public String getMarca() {
        return marca;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getColor() {
        return color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPropietario(Propietario propietario) {

        this.propietario = propietario;
    }
}

