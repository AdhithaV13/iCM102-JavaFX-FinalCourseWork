package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewDetailsController implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private TreeTableColumn<?, ?> rowAddress;

    @FXML
    private TreeTableColumn<?, ?> rowContact;

    @FXML
    private TreeTableColumn<?, ?> rowGender;

    @FXML
    private TreeTableColumn<?, ?> rowId;

    @FXML
    private TreeTableColumn<?, ?> rowName;

    @FXML
    private AnchorPane viewDetailsPane;

    @FXML
    private TreeTableView<?> table;

    @FXML
    void btnBackClicked(MouseEvent event) {

    }

    @FXML
    void btnChartClicked(MouseEvent event) {

    }

    @FXML
    void btnCustomersClicked(MouseEvent event) {

    }

    @FXML
    void btnItemsClicked(MouseEvent event) {

    }

    @FXML
    void btnSuppiersClicked(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //table.setVisible(false);
    }
}
