package controller;

import db.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.xml.soap.SOAPPart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignInController {

    @FXML
    private Button btnSignIn;

    @FXML
    private AnchorPane signInPanel;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtRePassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void btnSignInClicked(MouseEvent event) throws SQLException, ClassNotFoundException {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String reEnteredPassword = txtRePassword.getText();
        String email = txtEmail.getText();

        boolean validationPassword = validationPassword(password, reEnteredPassword);
        boolean validationEmail = validationEmail(email);

        if(validationEmail == true && validationPassword == true){
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO sellers VALUES(?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1,txtUsername.getText());
            pstm.setString(2,txtPassword.getText());
            pstm.setString(3,txtEmail.getText());

            new Alert(Alert.AlertType.INFORMATION,"Successfully signed in..!").show();
        }else if(validationEmail == false){
            new Alert(Alert.AlertType.INFORMATION,"Enter valid email..!").show();
        } else if (validationPassword == false) {
            new Alert(Alert.AlertType.INFORMATION,"Check your both passwords..!").show();
        }
    }

    public boolean validationPassword(String password, String reEnteredPassword){
        int lengthOfPassword = password.length();
        int lengthOfReEnteredPassword = reEnteredPassword.length();

        if(lengthOfPassword != lengthOfReEnteredPassword){
            return false;
        }else{
            int count = 0;

            for(int i = 0; i<lengthOfPassword; i++){
                if(password.charAt(i) == reEnteredPassword.charAt(i)){
                    count++;
                }
            }

            return (count == lengthOfPassword) ? true : false;
        }
    }

    public boolean validationEmail(String email){
        int startAt = email.length()-10;
        char letter1 = email.charAt(startAt);
        char letter2 = email.charAt(startAt+1);
        char letter3 = email.charAt(startAt+2);
        char letter4 = email.charAt(startAt+3);
        char letter5 = email.charAt(startAt+4);
        char letter6 = email.charAt(startAt+5);
        char letter7 = email.charAt(startAt+6);
        char letter8 = email.charAt(startAt+7);
        char letter9 = email.charAt(startAt+8);
        char letter10 = email.charAt(startAt+9);

        if((letter1 == '@') && (letter2 == 'g') && (letter3 == 'm') && (letter4 == 'a') && (letter5 == 'i') && (letter6 == 'l') && (letter7 == '.') && (letter8 == 'c') && (letter9 == 'o') && (letter10 == 'm')){
            return true;
        }else{
            return false;
        }
    }
}
