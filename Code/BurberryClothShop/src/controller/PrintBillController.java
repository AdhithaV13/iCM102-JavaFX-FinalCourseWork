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
import java.sql.ResultSet;
import java.sql.SQLException;

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
    void btnPrintClicked(MouseEvent event) throws SQLException, ClassNotFoundException {
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
    }

    public String generateCustomerName(){
        return "Hello";
    }

    public String generateSupplierName(){
        return "Hello";
    }

}
