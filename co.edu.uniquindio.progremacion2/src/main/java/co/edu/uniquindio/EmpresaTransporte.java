package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        for (Usuario usuario : usuarios) {
            cont++;
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
     *
     * @param propietario
     * @return cont
     */
    public int propietariosMayores (Propietario propietario){
        int cont = 0;
        for (Propietario propietario1: propietarios){
            if (propietario1.getEdad()>40){
                cont++;
            }
        }
        return cont;
    }
        /**
         * Metodo para encontrar a los usuarios en un rango de edad
         */
        public Collection<Usuario> rangoEdad(Collection<Usuario> usuarios, double edadMinima, double edadMaxima) {
            List<Usuario> rangoEdad = new ArrayList<Usuario>();
            for (Usuario usuario : usuarios) {
                if ((usuario.getEdad() < edadMaxima)&&(usuario.getEdad()>edadMinima)){
                    rangoEdad.add(usuario);
                }
            }
            return rangoEdad;
        }

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
