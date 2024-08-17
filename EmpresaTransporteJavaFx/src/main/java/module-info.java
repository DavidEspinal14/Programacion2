module co.edu.uniquindio.co_edu_uniquindio_programacion2_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens co.edu.uniquindio.co_edu_uniquindio_programacion2_javafx to javafx.fxml;
    exports co.edu.uniquindio.co_edu_uniquindio_programacion2_javafx;
}