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

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddItemController {

    @FXML
    private AnchorPane addItemPane;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtKind;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    @FXML
    private Button btnBack;

    @FXML
    void btnAddClicked(MouseEvent event) throws SQLException, ClassNotFoundException {
        String code = txtCode.getText();
        String description = txtDescription.getText();
        double unitPrice = Double.parseDouble(txtPrice.getText());
        String kind = txtKind.getText();
        int qty = Integer.parseInt(txtQty.getText());

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO items VALUES(?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,code);
        pstm.setString(2,description);
        pstm.setDouble(3,unitPrice);
        pstm.setString(4,kind);
        pstm.setInt(5,qty);
        pstm.executeUpdate();

        new Alert(Alert.AlertType.INFORMATION, "Item saved successfully..!").show();
    }

    @FXML
    void btnClearClicked(MouseEvent event) {
        txtCode.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
        txtKind.setText("");
        txtQty.setText("");
    }

    @FXML
    void btnBackClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) addItemPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/HomePage.fxml"))));
        stage.show();
    }

}
