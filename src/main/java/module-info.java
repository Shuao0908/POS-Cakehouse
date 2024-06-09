module com.example.cakehouse {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires junit.platform.console.standalone;

    opens com.example.cakehouse to javafx.fxml, org.junit.jupiter.api, org.junit.jupiter.engine, org.junit.platform.commons,org.junit.platform.engine;

    exports com.example.cakehouse;
}