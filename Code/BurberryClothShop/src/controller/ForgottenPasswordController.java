package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ForgottenPasswordController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnSend;

    @FXML
    private TextField txtEmail;

    @FXML
    private AnchorPane forgottenPasswordPane;

    @FXML
    void btnBackClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) forgottenPasswordPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainWindow.fxml"))));
        stage.show();
    }

    @FXML
    void btnSendClicked(MouseEvent event) {

    }

}
