package controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class fxempty {

    @FXML
    private HBox next;

    @FXML
    void clicknext(MouseEvent event) {
        // Fade-out da tela atual
        FadeTransition fadeOut = new FadeTransition(Duration.millis(300), next.getScene().getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setCycleCount(1);
        fadeOut.setAutoReverse(false);

        fadeOut.setOnFinished(e -> {
            try {
                // Carrega o FXML da tela de login
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
                Parent root = loader.load();

                // Aplica fade-in à nova tela
                FadeTransition fadeIn = new FadeTransition(Duration.millis(300), root);
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);
                fadeIn.setCycleCount(1);
                fadeIn.setAutoReverse(false);

                // Troca de cena
                Stage stage = (Stage) next.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Login");
                stage.show();

                // Inicia o fade-in
                fadeIn.play();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Inicia o fade-out
        fadeOut.play();
    }

}