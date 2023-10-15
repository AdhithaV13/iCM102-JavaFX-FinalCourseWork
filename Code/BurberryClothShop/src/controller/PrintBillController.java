package controller;

import db.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
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

public class PrintBillController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnPrint;

    @FXML
    private AnchorPane printBillPane;

    @FXML
    private TextField txtBillId;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtItemCodes;

    @FXML
    private TextField txtItemPrices;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtSupplierId;

    @FXML
    private TextField txtSupplierName;

    @FXML
    private TextField txtTotal;

    @FXML
    void btnClearClicked(MouseEvent event) {
        txtBillId.setText("");
        txtCustomerId.setText("");
        txtCustomerName.setText("");
        txtSupplierId.setText("");
        txtSupplierName.setText("");
        txtItemCodes.setText("");
        txtItemPrices.setText("");
        txtQty.setText("");
        txtTotal.setText("");
    }

    @FXML
    void btnPrintClicked(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        String billId = txtBillId.getText();
        String customerId = txtCustomerId.getText();
        String customerName = txtCustomerName.getText();
        String supplierId = txtSupplierId.getText();
        String supplierName = txtSupplierName.getText();
        String itemCodes = txtItemCodes.getText();
        double itemPrices = Double.parseDouble(txtItemPrices.getText());
        int qty = Integer.parseInt(txtQty.getText());
        double total = Double.parseDouble(txtTotal.getText());

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO bills VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,billId);
        pstm.setString(2,customerId);
        pstm.setString(3,customerName);
        pstm.setString(4,supplierId);
        pstm.setString(5,supplierName);
        pstm.setString(6,itemCodes);
        pstm.setDouble(7,itemPrices);
        pstm.setInt(8,qty);
        pstm.setDouble(9,total);
        pstm.executeUpdate();

        new Alert(Alert.AlertType.INFORMATION, "Bill saved successfully..!").show();

        Stage stage = (Stage)printBillPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/PrintingBill.fxml"))));
        stage.show();
    }

    public String generateCustomerName(String customerId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm=connection.prepareStatement("SELECT * FROM customers WHERE id=?");
        pstm.setObject(1,customerId);
        ResultSet resultSet=pstm.executeQuery();

        String customerName = "";

        while(resultSet.next()){
            customerName = resultSet.getString(2);
        }

        return customerName;
    }

    public String generateSupplierName(String supplierId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm=connection.prepareStatement("SELECT * FROM suppliers WHERE id=?");
        pstm.setObject(1,supplierId);
        ResultSet resultSet=pstm.executeQuery();

        String supplierName = "";

        while(resultSet.next()){
            supplierName = resultSet.getString(2);
        }

        return supplierName;
    }

    public String generateItemPrices(String itemCode) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm=connection.prepareStatement("SELECT * FROM items WHERE code=?");
        pstm.setObject(1,itemCode);
        ResultSet resultSet=pstm.executeQuery();

        String itemPrice = "";

        while(resultSet.next()){
            itemPrice = ""+resultSet.getDouble(3);
        }

        return itemPrice;
    }

    @FXML
    void txtCustomerNameClicked(MouseEvent event) throws SQLException, ClassNotFoundException {
        txtCustomerName.setText(generateCustomerName(txtCustomerId.getText()));
    }


    @FXML
    void txtSupplierNameClicked(MouseEvent event) throws SQLException, ClassNotFoundException {
        txtSupplierName.setText(generateSupplierName((txtSupplierId.getText())));
    }

    @FXML
    void txtItemPricesClicked(MouseEvent event) throws SQLException, ClassNotFoundException {
        txtItemPrices.setText(generateItemPrices(txtItemCodes.getText()));
    }

    @FXML
    void txtTotalClicked(MouseEvent event) {
        double total = (Double.parseDouble(txtItemPrices.getText().toString()))*(Integer.parseInt(txtQty.getText().toString()));

        txtTotal.setText(""+total);
    }
}
