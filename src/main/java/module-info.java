module org.example.serialgenerator {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.serialgenerator to javafx.fxml;
    exports org.example.serialgenerator;
}