package controller;

import db.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCustomerController {

    @FXML
    private AnchorPane addCustomerPane;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    void btnAddClicked(MouseEvent event) throws SQLException, ClassNotFoundException {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String gender = txtGender.getText();

        if(contact.length()==10){
            if(contact.charAt(0)=='0'){
                Connection connection = DBConnection.getInstance().getConnection();
                String sql = "INSERT INTO customers VALUES(?,?,?,?,?)";
                PreparedStatement pstm = connection.prepareStatement(sql);
                pstm.setString(1,id);
                pstm.setString(2,name);
                pstm.setString(3,address);
                pstm.setString(4,contact);
                pstm.setString(5,gender);
                pstm.executeUpdate();

                new Alert(Alert.AlertType.INFORMATION, "Customer saved successfully..!").show();
            }else{
                new Alert(Alert.AlertType.INFORMATION, "Enter valid contact number..!").show();
            }
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Enter valid contact number..!").show();
        }
    }

    @FXML
    void btnClearClicked(MouseEvent event) {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtContact.setText("");
        txtGender.setText("");
    }

}
