package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController {

    @FXML
    private Button btnClose;

    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnSignIn;

    @FXML
    private AnchorPane mainWindowPane;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void btnCloseClicked(MouseEvent event) throws IOException {
        mainWindowPane.setVisible(false);
    }

    @FXML
    void btnLogInClicked(MouseEvent event) {

    }

    @FXML
    void txtForgottenClicked(MouseEvent event) {

    }

    @FXML
    void btnSignInClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) mainWindowPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/SignIn.fxml"))));
        stage.show();
    }
}
