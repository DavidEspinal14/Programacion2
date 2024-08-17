package co.edu.uniquindio.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AjustesDeArranque extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("AjustesDeArranque"),300,200);
        stage.setScene(scene);
        stage.setTitle("AjustesDeArranque");
        stage.show();

    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AjustesDeArranque.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    public static void main(String[] args) {
        launch();
    }
}
