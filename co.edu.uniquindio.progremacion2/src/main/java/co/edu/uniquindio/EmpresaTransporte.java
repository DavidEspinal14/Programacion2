package co.edu.uniquindio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Clase Empresa de Transporte
 */
public class EmpresaTransporte {
    private double pesoMinimo;
    private String nombre;
    private Collection<VehiculoTransporte> vehiculosTransporte;
    private Collection<VehiculoCarga> vehiculosCarga;
    private Collection<Propietario> propietarios;
    private Collection<Usuario> usuarios;
    private Collection<Vehiculo> vehiculos;
    private Collection<Usuario> usuariosFiltrados;

    /**
     * Constructor Completo
     * @param nombre
     */
    public EmpresaTransporte(String nombre, double pesoMinimo) {
        this.nombre = nombre;
        this.pesoMinimo = pesoMinimo;
        this.vehiculosTransporte = new ArrayList<VehiculoTransporte>();
        this.vehiculosCarga = new ArrayList<>();
        this.propietarios = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.usuariosFiltrados = new ArrayList<>();
    }

    /**
     * Agregar un vehiculo dependiendo de que tipo sea
     * @param vehiculo
     */
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        if (vehiculo.getPropietario() != null) {
            propietarios.add(vehiculo.getPropietario());
        }
        if (vehiculo instanceof VehiculoTransporte) {
            vehiculosTransporte.add((VehiculoTransporte) vehiculo);
            for ( Usuario usuario : ((VehiculoTransporte) vehiculo).getUsuarios() ) {
                if (!verificarUsuarioRepetido(usuario,usuarios)) {
                    usuarios.add(usuario);
                }
            }
        } else if (vehiculo instanceof VehiculoCarga) {
            vehiculosCarga.add((VehiculoCarga) vehiculo);
        }
    }

    /**
     * Metodo para cambiar a un vehiculo de propietario
     * @param propietario
     * @param vehiculo
     */
    public void modificarPropietarioVehiculo(Propietario propietario, Vehiculo vehiculo) {
        for(Vehiculo vehiculo1 : vehiculos) {
            if(vehiculo1 == vehiculo) {
                vehiculo1.setPropietario(propietario);
            }
        }
    }
    /**
     * Agregar propietario
     * @param propietario
     */
    public void agregarPropietarios(Propietario propietario){
        propietarios.add(propietario);
    }

    /**
     * Agregar Usuario
     * @param usuario
     */
    public void agregarUsuarios(Usuario usuario){
        usuarios.add(usuario);
    }

    /**
     * Metodo para calcular los psajeros transportados por todos los vehiculos de transporte
     * @return
     */
    public int calcularPasajerosAlDia(){
        int cont = 0;
        for (VehiculoTransporte vehiculoTransporte : vehiculosTransporte) {
            for (Usuario usuario : vehiculoTransporte.getUsuarios()) {
                cont ++;
            }
        }
        return cont;
    }

    /**
     * Metodo de la funcionalidad peso y filtrar por peso
     * @return
     */
    public void filtrarPorPeso() {
        for (Usuario usuario : usuarios) {
            if (usuario.getPeso() >= pesoMinimo && !verificarUsuarioRepetido(usuario, usuariosFiltrados)) {
                usuariosFiltrados.add(usuario);
            }
        }
    }

    /**
     * Metodo para verificar si ya hay un usuario en la lista de usuarios filtrados
     * @param usuario
     * @return
     */
    public boolean verificarUsuarioRepetido(Usuario usuario, Collection<Usuario> lista) {
        boolean existe = false;
        for (Usuario usuario1 : lista) {
            if (usuario1 == usuario) {
                existe = true;
            }
        }
        return existe;
    }

    /**
     * Metodo para verificar si hay propietarios en la lista de propietarios
     * @return
     */
    public boolean verificarListaPropietarios(){
        boolean lista = false;
        if (propietarios.size() > 0) {
            lista = true;
        }
        return lista;
    }
    /**
     *Metodo para mostrar la cantidad de propietarios mayores de 40 años
     * @return cont
     */
    public void mostrarPropietariosMayores (){
        String info = "";
        for (Propietario propietario: propietarios){
            if (propietario.getEdad()>40){
                info += propietario.toString();
            }
        }
        if (info == ""){
            info += "No hay ningun propietario mayor a 40 años";
        }
        JOptionPane.showMessageDialog(null, info);
    }
        /**
         * Metodo para encontrar a los usuarios en un rango de edad
         */
        public Collection<Usuario> rangoEdad(double edadMinima, double edadMaxima) {
            List<Usuario> rangoEdad = new ArrayList<Usuario>();
            for (Usuario usuario : usuarios) {
                if ((usuario.getEdad() < edadMaxima)&&(usuario.getEdad()>edadMinima)){
                    rangoEdad.add(usuario);
                }
            }
            return rangoEdad;
        }
    public void mostrarVehiculoYUsuariosTransportados(String placa){
        String info = "=========INFORMACION DEL VEHICULO=========\n";
        int cont = 0;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa) && vehiculo instanceof VehiculoTransporte) {
                for (Usuario usuario : ((VehiculoTransporte) vehiculo).getUsuarios()) {
                    cont++;
                }
                info += vehiculo.toString() + "================================\nNumero de usuarios transportados: "+ cont +"\n================================\n";
                cont =0;
            } else if ( vehiculo.getPlaca().equals(placa) && vehiculo instanceof VehiculoCarga) {
                info += vehiculo.toString();
            }
        }
        JOptionPane.showMessageDialog(null, info);

    }

    /**
     * Metodos get y set
     * @return
     */
    public String getNombre() {
        return nombre;
    }
    public double getPesoMinimo(){
        return pesoMinimo;
    }
    public Collection<VehiculoTransporte> getVehiculosTransporte() {
        return vehiculosTransporte;
    }

    public Collection<VehiculoCarga> getVehiculosCarga() {
        return vehiculosCarga;
    }

    public Collection<Propietario> getPropietarios() {
        return propietarios;
    }

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Collection<Usuario> getUsuariosFiltrados(){
            filtrarPorPeso();
        return usuariosFiltrados;
    }
}
