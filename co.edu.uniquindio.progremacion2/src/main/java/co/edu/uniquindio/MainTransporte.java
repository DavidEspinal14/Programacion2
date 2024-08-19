package co.edu.uniquindio;

import javax.swing.*;
import java.util.Map;
import java.util.HashMap;

public class MainTransporte {

    public static void main(String[] args) {
        iniciarMenu();
    }

    /**
     * Metodo para iniciar el menu
     */
    public static void iniciarMenu() {
        int opcion = (int) (entradaNumerica("BIENVENIDO\n 1. Iniciar con valores de prueba\n 0. Salir"));
        while (opcion != 0) {
            EmpresaTransporte empresa = inicializarEmpresa();
            int opcion2 = 9;
            while (opcion2 != 0) {
                opcion2 = (int) (entradaNumerica("EMPRESDA DE TRANSPORTE= " + empresa.getNombre() + "\n" + "1. Agregar Propietario\n 2. Pasajeros transportados en un dia\n 3. Informacion de los vehiculos \n 4. Lista peso usuarios \n 0. Salir"));
                switch (opcion2) {
                    case 1:
                        Propietario propietario = Propietario.crearPropietario();
                        String[] opciones = {"Lista de vehiculos" , "Crear uno nuevo"};
                        int opcion3 = JOptionPane.showOptionDialog(null,"Seleccione el vehiculo a asociar", "Menu agregar vehiculo", 0,1,null,opciones,opciones[0]);
                        if (opcion3 == 0) {
                            if(verificarListaVehiculos(empresa) == true){
                                Map<String, Vehiculo> temporal = new HashMap<>();
                                for(Vehiculo vehiculoArreglo : empresa.getVehiculos()){
                                    if (vehiculoArreglo instanceof VehiculoTransporte) {
                                        temporal.put("Transporte - "+vehiculoArreglo.getPlaca(), vehiculoArreglo);
                                    } else if (vehiculoArreglo instanceof VehiculoCarga) {
                                        temporal.put("Carga - "+vehiculoArreglo.getPlaca(), vehiculoArreglo);
                                    }
                                }
                                String[] opcionesVehiculos = temporal.keySet().toArray(new String[0]);
                                String vehiculoSeleccionado = (String) JOptionPane.showInputDialog(null,"Seleccione el vehiculo de la lista: ", "Elegir",JOptionPane.QUESTION_MESSAGE,null,opcionesVehiculos, opcionesVehiculos[0]);
                                propietario.agregarVehiculo(temporal.get(vehiculoSeleccionado));
                                empresa.modificarPropietarioVehiculo(propietario,temporal.get(vehiculoSeleccionado));
                                empresa.agregarPropietarios(propietario);
                            }
                        }
                        break;
                    case 2:
                        generarReporteTransporte(empresa);
                        break;
                    case 3:
                        for (Vehiculo vehiculo: empresa.getVehiculos()) {
                            JOptionPane.showMessageDialog(null,vehiculo.toString());
                        }
                        break;
                    case 4:
                        StringBuilder resultado = new StringBuilder("Usuarios con peso >=" + EmpresaTransporte.getPesoMinimo() + ":\n");
                        for (Usuario usuario : usuariosFiltrados) {
                            resultado.append("Usuario con peso: ").append(usuario.getPeso()).append(" kg\n");
                        }
                        JOptionPane.showMessageDialog(null, resultado.toString(), "Usuarios Filtrados", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            opcion = 0;
        }
    }
    public static EmpresaTransporte inicializarEmpresa(){
        EmpresaTransporte empresa = new EmpresaTransporte("Empresa prueba", 60);
        VehiculoTransporte trans1 = new VehiculoTransporte("00000","Suzuki","2012","Zapote",10);
        VehiculoTransporte trans2 = new VehiculoTransporte("11111","Toyota","2010","Blanco",20);
        VehiculoCarga car1 = new VehiculoCarga("00000","Suzuki","2012","Zapote",20000);
        Usuario usu1 = new Usuario("Fulano","18","123456", 75);
        Usuario usu2 = new Usuario("Karla","25","78910", 58);
        Usuario usu3 = new Usuario("Tomas","19","1071788", 80);
        trans1.agregarUsuario(usu1);
        trans1.agregarUsuario(usu2);
        trans2.agregarUsuario(usu3);
        trans2.agregarUsuario(usu1);
        trans2.agregarUsuario(usu2);
        empresa.agregarVehiculo(trans1);
        empresa.agregarVehiculo(trans2);
        empresa.agregarVehiculo(car1);
        return empresa;
    }
    public static void generarReporteTransporte(EmpresaTransporte empresa){
        int cont = 0 ;
        String info = "==================== REPORTE DE USUARIOS TRANSPORTADOS =======================\n";
        for (VehiculoTransporte vehiculoTransporte: empresa.getVehiculosTransporte()){
            for(Usuario usuario: vehiculoTransporte.getUsuarios()){
                cont++;
            }
            info += vehiculoTransporte.getMarca() + " = " + cont + "\n";
            cont = 0;
        }
        info += "Total de usuarios transportados = " + empresa.calcularPasajerosAlDia();
        JOptionPane.showMessageDialog(null,info);
    }
    /**
     * Metodo para verificar que hay vehiculos en la lista de la empresa
     * @param empresa
     * @return
     */
    public static boolean verificarListaVehiculos(EmpresaTransporte empresa) {
        boolean lista = false;
        if (empresa.getVehiculosTransporte().size() > 0 && empresa.getVehiculosCarga().size() > 0) {
            lista = true;
        }
        return lista;
    }
    /**
     * Metodo para leer entradas de texto
     * @param info
     * @return resultado
     */
    public static String entradaTexto(String info) {
        String resultado = "";
        boolean entradaVelida = false;
        while (!entradaVelida) {
            try{
                resultado = JOptionPane.showInputDialog(info);
                if (resultado == null) {
                    break;
                }else {
                    entradaVelida = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Entrada invalida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultado;
    }

    /**
     * Metodo para agregar entradas numericas
     * @param info
     * @return resultado
     */
    public static double entradaNumerica(String info) {
        double resultado = 0;
        boolean entradaVelida = false;
        while (!entradaVelida) {
            try{
                String entrada = JOptionPane.showInputDialog(info);
                if (entrada == null) {
                    break;
                }else {
                    resultado = Integer.parseInt(entrada);
                    entradaVelida = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Entrada invalida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultado;
    }
}
