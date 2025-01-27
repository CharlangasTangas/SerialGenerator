module org.example.serialgenerator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;


    opens org.example.serialgenerator to javafx.fxml;
    exports org.example.serialgenerator;

    opens org.example.serialgenerator.views to javafx.fxml;
    exports org.example.serialgenerator.views;
}