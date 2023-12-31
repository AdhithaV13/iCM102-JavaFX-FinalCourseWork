package controller;

import db.DBConnection;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    void btnSendClicked(MouseEvent event) throws MessagingException, SQLException, ClassNotFoundException {
        boolean validationEmail = validationEmail(txtEmail.getText());

        String email = txtEmail.getText();

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM sellers");
        ResultSet resultSet = pstm.executeQuery();
        for(int j = 0 ; ;j++) {
            if (resultSet.next()) {
                String email2 = resultSet.getString(3);
                String password = resultSet.getString(2);

                int count = 0;

                for (int i = 0; i < email2.length(); i++) {
                    if (email.charAt(i) == email2.charAt(i)) {
                        count++;
                    }
                }

                if (count == email.length()) {
                    if(validationEmail == true){
                        String sender = "adhithavichak@gmail.com";
                        String recipient = txtEmail.getText();
                        String password2 = "skdc wndx lkxw tyoa";

                        Properties props = new Properties();
                        props.put("mail.smtp.host", "smtp.gmail.com");
                        props.put("mail.smtp.port", "587");
                        props.put("mail.smtp.auth", "true");
                        props.put("mail.smtp.starttls.enable", "true");

                        Session session = Session.getInstance(props,
                                new javax.mail.Authenticator() {
                                    protected PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication(sender, password2);
                                    }
                                });

                        try {
                            Message message = new MimeMessage(session);
                            message.setFrom(new InternetAddress(sender));
                            message.setRecipients(Message.RecipientType.TO,
                                    InternetAddress.parse(recipient));
                            message.setSubject("Burberry Cloth Shop");
                            message.setText("Your password : "+password);
                            Transport.send(message);

                            new Alert(Alert.AlertType.INFORMATION, "Email sent successfully..!").show();break;
                        } catch (MessagingException e) {
                            new Alert(Alert.AlertType.INFORMATION, "Failed to send email. Error : "+e.getMessage()).show();break;
                        }
                    }else{
                        new Alert(Alert.AlertType.INFORMATION,"Something went wrong...!").show();break;
                    }
                } else {
                    new Alert(Alert.AlertType.INFORMATION, "Incorrect email..!").show();break;
                }
            }else{
                break;
            }
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
