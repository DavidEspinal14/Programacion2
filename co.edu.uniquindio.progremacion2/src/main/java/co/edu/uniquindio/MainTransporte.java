package co.edu.uniquindio;

import javax.swing.*;
import java.util.Map;
import java.util.HashMap;

public class MainTransporte {

    public static void main(String[] args) {
        iniciarMenuPrincipal();
    }

    /**
     * Metodo para iniciar el menu
     */
    public static void iniciarMenuPrincipal() {
        int bucle = 1;
        while (bucle != 0) {
            int opcion = (int) (entradaNumerica("BIENVENIDO\n 1. Iniciar con valores de prueba\n 2.Ingresar todo de nuevo\n 0. Salir"));
            switch (opcion){
                case 1:
                    EmpresaTransporte empresa = inicializarEmpresa();
                    int opcion2 = 9;
                    while (opcion2 != 0) {
                        opcion2 = (int) (entradaNumerica("EMPRESA DE TRANSPORTE= " + empresa.getNombre() + "\n" + "1. Agregar Propietario\n 2. Analiticas con los usuarios\n 3. Analiticas con vehiculos \n 4. Analiticas con propietarios \n 0. Salir\n==================================\n Peso minimo: "+ empresa.getPesoMinimo()+"\n=================================="));
                        switch (opcion2) {
                            case 1:
                                menuAgregarPropietario(empresa);
                                break;
                            case 2:
                                menuAnaliticasUsuarios(empresa);
                                break;
                            case 3:
                                menuAnaliticasDeVehiculos(empresa);
                                break;
                            case 4:
                                menuAnaliticasConPropietarios(empresa);
                                break;
                            case 0:
                                bucle = 0;
                        }
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Aun estamos trabajando en estas funcionalidades");
                    break;
                case 0:
                    bucle = 0;
                    break;
            }

        }
    }
    public static void menuAnaliticasDeVehiculos(EmpresaTransporte empresa) {
        String[] opciones = {"Mostrar informacion","Buscar vehiculo","Regresar"};
        int bucle = 1;
        while (bucle != 0) {
            int seleccion = JOptionPane.showOptionDialog(null,"Seleccione que analitica desea ver: ", "Menu analiticas con vehiculos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            switch (seleccion) {
                case 0:
                    for (Vehiculo vehiculo : empresa.getVehiculos()) {
                        JOptionPane.showMessageDialog(null, vehiculo.toString());
                    }
                    break;
                case 1:
                    String placa = seleccionarVehiculo(empresa);
                    empresa.mostrarVehiculoYUsuariosTransportados(placa);
                    break;
                case 2:
                    bucle = 0;
                    break;
            }
        }
    }

    /**
     * Metodo para seleccionar un vehiculo de la lista de la empresa y obtener su placa
     * @param empresa
     * @return
     */
    public static String seleccionarVehiculo(EmpresaTransporte empresa) {
        String resultado = "";
        if (verificarListaVehiculos(empresa) == true) {
            Map<String, Vehiculo> temporal = new HashMap<>();
            for (Vehiculo vehiculoArreglo : empresa.getVehiculos()) {
                if (vehiculoArreglo instanceof VehiculoTransporte) {
                    temporal.put("Transporte - " + vehiculoArreglo.getPlaca(), vehiculoArreglo);
                } else if (vehiculoArreglo instanceof VehiculoCarga) {
                    temporal.put("Carga - " + vehiculoArreglo.getPlaca(), vehiculoArreglo);
                }
            }
            String[] opcionesVehiculos = temporal.keySet().toArray(new String[0]);
            String vehiculoSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione el vehiculo de la lista: ", "Elegir", JOptionPane.QUESTION_MESSAGE, null, opcionesVehiculos, opcionesVehiculos[0]);
            resultado = temporal.get(vehiculoSeleccionado).getPlaca();
        }
        return resultado;
    }
    /**
     * Metodo para agregar un propietario con datos ingresados por UI a una empresa
     * @param empresa Objeto al que se le va a agregar el propietario
     */
    public static void menuAgregarPropietario(EmpresaTransporte empresa) {
        Propietario propietario = Propietario.crearPropietario();
        String[] opciones = {"Lista de vehiculos", "Crear uno nuevo"};
        int opcion3 = JOptionPane.showOptionDialog(null, "Seleccione el vehiculo a asociar", "Menu agregar vehiculo", 0, 1, null, opciones, opciones[0]);
        if (opcion3 == 0) {
            if (verificarListaVehiculos(empresa) == true) {
                Map<String, Vehiculo> temporal = new HashMap<>();
                for (Vehiculo vehiculoArreglo : empresa.getVehiculos()) {
                    if (vehiculoArreglo instanceof VehiculoTransporte && vehiculoArreglo.getPropietario() == null) {
                        temporal.put("Transporte - " + vehiculoArreglo.getPlaca(), vehiculoArreglo);
                    } else if (vehiculoArreglo instanceof VehiculoCarga && vehiculoArreglo.getPropietario() == null) {
                        temporal.put("Carga - " + vehiculoArreglo.getPlaca(), vehiculoArreglo);
                    }
                }
                String[] opcionesVehiculos = temporal.keySet().toArray(new String[0]);
                String vehiculoSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione el vehiculo de la lista: ", "Elegir", JOptionPane.QUESTION_MESSAGE, null, opcionesVehiculos, opcionesVehiculos[0]);
                propietario.agregarVehiculo(temporal.get(vehiculoSeleccionado));
                empresa.modificarPropietarioVehiculo(propietario, temporal.get(vehiculoSeleccionado));
                empresa.agregarPropietarios(propietario);
            }
        } else if (opcion3 == 1) {
            JOptionPane.showMessageDialog(null, "Aun estamos trabajando en estas funcionalidades");
        }
    }
    public static  void menuAnaliticasConPropietarios(EmpresaTransporte empresa) {
        String[] opciones = {"Propietarios Mayores", "Regresar"};
        int bucle = 1;
        while (bucle != 0) {
            int pick = JOptionPane.showOptionDialog(null,"Seleccion que analitica desea ver: ", "menu analiticas con propietarios",0,1,null,opciones,opciones[0]);
            if (empresa.verificarListaPropietarios() == true && pick == 0) {
                empresa.mostrarPropietariosMayores();
            }else if (empresa.verificarListaPropietarios() == false && pick == 0){
               int seleccion = JOptionPane.showConfirmDialog(null,"Parece que no hay propietarios agregados, ¿Desea agregar uno nuevo?","Menu Analiticas con propietarios",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
               switch (seleccion){
                   case JOptionPane.YES_OPTION:
                       menuAgregarPropietario(empresa);
                       break;
                   case JOptionPane.NO_OPTION:
                       bucle = 0;
                       break;
               }
            } else{
                bucle = 0;
            }
        }
    }
    /**
     *
     * @param empresa
     */
    public static void menuAnaliticasUsuarios(EmpresaTransporte empresa) {
        int bucle = 1;
        while (bucle != 0) {
            String[] opciones = {"Usuarios Transportados", "Usuarios por peso", "Usuarios por edad","Regresar"};
            int seleccion = JOptionPane.showOptionDialog(null,"Seleccione la analitica que desea ver: ","Menu Analitica de usuarios",0,1,null, opciones, opciones[0]);
            switch (seleccion){
                case 0:
                    generarReporteTransporte(empresa);
                    break;
                case 1:
                    generarAnaliticaUsuariosPorPeso(empresa);
                    break;
                case 2:
                    generarAnaliticaUsuariosPorRangoDeEdad(empresa);
                    break;
                case 3:
                    bucle = 0;
                    break;
            }
        }
    }
    /**
     * Metodo para crear una empresa con datos quemados, para poder realizar pruebas del funcionamiento del codigo
     * @return Clase del tipo EmpresaTransporte
     */
    public static EmpresaTransporte inicializarEmpresa() {
        EmpresaTransporte empresa = new EmpresaTransporte("Empresa prueba", 60);
        VehiculoTransporte trans1 = new VehiculoTransporte("Suzuki", "2012", "00000", "Zapote", 10);
        VehiculoTransporte trans2 = new VehiculoTransporte("Toyota", "2010", "111111", "Blanco", 20);
        VehiculoCarga car1 = new VehiculoCarga("Mazda", "2012", "222222", "Verde", 20000);
        Usuario usu1 = new Usuario("Fulano", 18, "123456", 75);
        Usuario usu2 = new Usuario("Karla", 25, "78910", 58);
        Usuario usu3 = new Usuario("Tomas", 19, "1071788", 80);
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

    /**
     *
     * @param empresa
     */
    public static void generarAnaliticaUsuariosPorRangoDeEdad(EmpresaTransporte empresa) {
        double edadMinima = entradaNumerica("Ingrese el valor mínimo:");
        double edadMaxima = entradaNumerica("Ingrese el valor maximo");
        StringBuilder resultado2 = new StringBuilder("Usuarios en el rango de edad:\n");
        for (Usuario usuario : empresa.getUsuarios()) {
            resultado2.append(usuario.toString());
        }
        JOptionPane.showMessageDialog(null, resultado2.toString(), "Usuarios Filtrados", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     *
     * @param empresa
     */
    public static void generarAnaliticaUsuariosPorPeso(EmpresaTransporte empresa) {
        StringBuilder resultado = new StringBuilder("Usuarios con peso >=" + empresa.getPesoMinimo() + ":\n");
        for (Usuario usuario : empresa.getUsuariosFiltrados()) {
            resultado.append("Usuario con peso: ").append(usuario.getPeso()).append(" kg\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString(), "Usuarios Filtrados", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     *
     * @param empresa
     */
    public static void generarReporteTransporte(EmpresaTransporte empresa) {
        int cont = 0;
        String info = "==================== REPORTE DE USUARIOS TRANSPORTADOS =======================\n";
        for (VehiculoTransporte vehiculoTransporte : empresa.getVehiculosTransporte()) {
            for (Usuario usuario : vehiculoTransporte.getUsuarios()) {
                cont++;
            }
            info += vehiculoTransporte.getPlaca() + " = " + cont + "\n";
            cont = 0;
        }
        info += "Total de usuarios transportados = " + empresa.calcularPasajerosAlDia();
        JOptionPane.showMessageDialog(null, info);
    }

    /**
     * Metodo para verificar que hay vehiculos en la lista de la empresa
     *
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
     *
     * @param info
     * @return resultado
     */
    public static String entradaTexto(String info) {
        String resultado = "";
        boolean entradaVelida = false;
        while (!entradaVelida) {
            try {
                resultado = JOptionPane.showInputDialog(info);
                if (resultado == null) {
                    break;
                } else {
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
     *
     * @param info
     * @return resultado
     */
    public static double entradaNumerica(String info) {
        double resultado = 0;
        boolean entradaVelida = false;
        while (!entradaVelida) {
            try {
                String entrada = JOptionPane.showInputDialog(info);
                if (entrada == null) {
                    break;
                } else {
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