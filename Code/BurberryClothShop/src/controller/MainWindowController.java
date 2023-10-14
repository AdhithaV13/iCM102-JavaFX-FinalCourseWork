package controller;

import db.DBConnection;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        Platform.exit();
    }

    @FXML
    void btnLogInClicked(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        String userName = txtUsername.getText();
        String password = txtPassword.getText();

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM sellers");
        ResultSet resultSet = pstm.executeQuery();
        for(int j = 0 ; ;j++) {
            if (resultSet.next()) {
                String userName2 = resultSet.getString(1);
                String password2 = resultSet.getString(2);

                int count = 0;

                for (int i = 0; i < userName.length()-1; i++) {
                    if (userName.charAt(i) == userName2.charAt(i)) {
                        count++;
                    }
                }

                if (count == userName.length() - 1) {
                    int count2 = 0;

                    for (int i = 0; i < password.length()-1; i++) {
                        if (password.charAt(i) == password2.charAt(i)) {
                            count2++;
                        }
                    }

                    if (count2 == password.length() - 1) {
                        new Alert(Alert.AlertType.INFORMATION, "Successfully loged in..!").show();
                        Stage stage = (Stage) mainWindowPane.getScene().getWindow();
                        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/HomePage.fxml"))));break;
                    } else {
                        new Alert(Alert.AlertType.INFORMATION, "Incorrect password..!").show();break;
                    }
                } else {
                    new Alert(Alert.AlertType.INFORMATION, "Incorrect username..!").show();break;
                }
            }else{
                break;
            }
        }
    }

    @FXML
    void txtForgottenClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) mainWindowPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ForgottenPassword.fxml"))));
        stage.show();
    }

    @FXML
    void btnSignInClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) mainWindowPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/SignIn.fxml"))));
        stage.show();
    }
}
