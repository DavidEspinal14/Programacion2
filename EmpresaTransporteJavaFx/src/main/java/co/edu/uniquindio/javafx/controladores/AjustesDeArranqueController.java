package co.edu.uniquindio.javafx.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AjustesDeArranqueController {

    @FXML
    private Button botonNuevos;

    @FXML
    private Button botonPreEstablecido;

    @FXML
    void clickNuevos(ActionEvent event) {
        System.out.println("Sapoooo");
    }

    @FXML
    void clickPreestablecido(ActionEvent event) {
        System.out.println("222");
    }

}

