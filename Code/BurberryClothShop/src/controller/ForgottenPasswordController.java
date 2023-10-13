package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

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
    void btnSendClicked(MouseEvent event) throws MessagingException {
        boolean validationEmial = validationEmail(txtEmail.getText());

        if(validationEmial == true){
            Properties properties = new Properties();
            properties.put("mail.smtp.auth",true);
            properties.put("mail.smtp.hot","smtp.gmail.com");
            properties.put("mail.smtp.port",587);
            properties.put("mail.smtp.starttls.enable",true);
            properties.put("mail.transport.protocl","smtp");

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("adhithavichak@gmail.com","12#Mmadhitha");
                }
            });

            Message message = new MimeMessage(session);
            message.setSubject("OTP of Burberry Cloth Shop");
            message.setContent("<h1>Email from fullstack developer Adhitha Vithanage..</h1>","text/html");

            Address addressTo = new InternetAddress(txtEmail.getText());
            message.setRecipient(Message.RecipientType.TO,addressTo);
            Transport.send(message);

            new Alert(Alert.AlertType.INFORMATION,"Email sent successfully...!").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION,"Something went wrong...!").show();
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
