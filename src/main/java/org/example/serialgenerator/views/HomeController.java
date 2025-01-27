package org.example.serialgenerator.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HomeController {
    private Stage stage;

    @FXML
    private TextField txtEmail;

    @FXML
    private Label lblSerialGenerated;

    @FXML
    private void generateSerial(ActionEvent event) {
        String email = txtEmail.getText();
        lblSerialGenerated.setText(hashEmail(email));
    }

    public String hashEmail(String email) {
        try {
            // Crear un objeto MessageDigest con MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");

            // Aplicar el hash al texto de entrada
            byte[] hashBytes = digest.digest(email.getBytes());

            // Convertir el array de bytes a una cadena hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            // Devolver el hash como una cadena
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    @FXML
    private void copySerial(ActionEvent event) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString(lblSerialGenerated.getText());
        clipboard.setContent(clipboardContent);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
