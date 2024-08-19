package co.edu.uniquindio;
import java.util.ArrayList;
import java.util.Collection;

public class EmpresaTransporte {
    private String nombre;
    private double pesoMinimo;
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
                usuarios.add(usuario);
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
    public Collection<Usuario> filtrarPorPeso(Collection<Usuario>usuarios, double pesoMinimo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getPeso() >= pesoMinimo) {
                usuariosFiltrados.add(usuario);
            }
        }
        return usuariosFiltrados;
    }

    /**
     * Metodo para identificar a las propietarios mayores de 40
     * @param propietarios
     * @return
     */
    public int propietariosMayores (Propietario propietarios){
        int cont = 0;
        for (Propietario propietario: propietarios){
            if (propietario.getEdad()>40){
                cont++;
            }
        }
        return cont;
    }
}
    /*
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     */
    public String getNombre() {
        return nombre;
    }
    public double getPeso Minimo(){
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
        return usuariosFiltrados;
}

