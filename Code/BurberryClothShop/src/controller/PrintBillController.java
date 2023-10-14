package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    void btnPrintClicked(MouseEvent event) {

    }

}
