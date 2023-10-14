package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

    @FXML
    private Button btnAddACustomer;

    @FXML
    private Button btnAddASupplier;

    @FXML
    private Button btnAddAnItem;

    @FXML
    private Button btnPrintABill;

    @FXML
    private Button btnViewDetails;

    @FXML
    private AnchorPane homePagePane;

    @FXML
    void btnAddACustomerClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) homePagePane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AddCustomer.fxml"))));
        stage.show();
    }

    @FXML
    void btnAddASupplierClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) homePagePane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AddSupplier.fxml"))));
        stage.show();
    }

    @FXML
    void btnAddAnItemClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) homePagePane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AddItem.fxml"))));
        stage.show();
    }

    @FXML
    void btnPrintABillClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) homePagePane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/PrintBill.fxml"))));
        stage.show();
    }

    @FXML
    void btnViewDetailsOnClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) homePagePane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ViewDetails.fxml"))));
        stage.show();
    }

}
