package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    void btnAddClicked(MouseEvent event) {

    }

    @FXML
    void btnClearClicked(MouseEvent event) {
        txtCode.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
        txtKind.setText("");
        txtQty.setText("");
    }

}
