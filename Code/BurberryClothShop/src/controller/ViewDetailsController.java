package controller;

import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;
import model.Item;
import model.Supplier;
import model.tm.CustomerTm;
import model.tm.ItemTm;
import model.tm.SupplierTm;

import java.awt.event.ItemEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewDetailsController implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private TreeTableColumn<?, ?> rowAddress;

    @FXML
    private TreeTableColumn<?, ?> rowContact;

    @FXML
    private TreeTableColumn<?, ?> rowContact1;

    @FXML
    private TreeTableColumn<?, ?> rowGender;

    @FXML
    private TreeTableColumn<?, ?> rowGender1;

    @FXML
    private TreeTableColumn<?, ?> rowId;

    @FXML
    private TreeTableColumn<?, ?> rowId1;

    @FXML
    private TreeTableColumn<?, ?> rowName;

    @FXML
    private TreeTableColumn<?, ?> rowName1;

    @FXML
    private TreeTableView<CustomerTm> table;

    @FXML
    private TreeTableView<SupplierTm> table1;

    @FXML
    private AnchorPane viewDetailsPane;

    @FXML
    private TreeTableColumn<?, ?> rowCode;

    @FXML
    private TreeTableColumn<?, ?> rowDescription;

    @FXML
    private TreeTableColumn<?, ?> rowKind;

    @FXML
    private TreeTableColumn<?, ?> rowQty;

    @FXML
    private TreeTableColumn<?, ?> rowUnitPrice;

    @FXML
    private TreeTableView<ItemTm> table2;

    @FXML
    private PieChart pie_chart;

    List<Customer> list = new ArrayList<>();
    List<Supplier> list1 = new ArrayList<>();
    List<Item> list2 = new ArrayList<>();

    @FXML
    void btnBackClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) viewDetailsPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/HomePage.fxml"))));
        stage.show();
    }

    @FXML
    void btnChartClicked(MouseEvent event) throws SQLException, ClassNotFoundException {
        loadChart();
    }

    @FXML
    void btnCustomersClicked(MouseEvent event) throws SQLException, ClassNotFoundException {
       loadTable();
    }

    @FXML
    void btnItemsClicked(MouseEvent event) throws SQLException, ClassNotFoundException {
        loadTable2();
    }

    @FXML
    void btnSuppliersClicked(MouseEvent event) throws SQLException, ClassNotFoundException {
        loadTable1();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rowId.setCellValueFactory(new TreeItemPropertyValueFactory<>("id"));
        rowName.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
        rowAddress.setCellValueFactory(new TreeItemPropertyValueFactory<>("address"));
        rowContact.setCellValueFactory(new TreeItemPropertyValueFactory<>("contact"));
        rowGender.setCellValueFactory(new TreeItemPropertyValueFactory<>("gender"));

        rowId1.setCellValueFactory(new TreeItemPropertyValueFactory<>("id"));
        rowName1.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
        rowContact1.setCellValueFactory(new TreeItemPropertyValueFactory<>("contact"));
        rowGender1.setCellValueFactory(new TreeItemPropertyValueFactory<>("gender"));

        rowCode.setCellValueFactory(new TreeItemPropertyValueFactory<>("code"));
        rowDescription.setCellValueFactory(new TreeItemPropertyValueFactory<>("description"));
        rowUnitPrice.setCellValueFactory(new TreeItemPropertyValueFactory<>("unitPrice"));
        rowKind.setCellValueFactory(new TreeItemPropertyValueFactory<>("kind"));
        rowQty.setCellValueFactory(new TreeItemPropertyValueFactory<>("qty"));

        table.setVisible(false);
        table1.setVisible(false);
        table2.setVisible(false);
        pie_chart.setVisible(false);
    }

    public void loadTable() throws SQLException, ClassNotFoundException {
        table1.setVisible(false);
        table2.setVisible(false);
        pie_chart.setVisible(false);

            ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM customers");
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                list.add(new Customer(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));

                for (Customer customer : list) {
                    tmList.add(new CustomerTm(
                            customer.getId(),
                            customer.getName(),
                            customer.getAddress(),
                            customer.getContact(),
                            customer.getGender()
                    ));
                }

                TreeItem<CustomerTm> treeItem = new RecursiveTreeItem<>(tmList, RecursiveTreeObject::getChildren);
                table.setRoot(treeItem);
                table.setShowRoot(false);

                table.setVisible(true);
            }
    }

    public void loadTable1() throws SQLException, ClassNotFoundException {
        table.setVisible(false);
        table2.setVisible(false);
        pie_chart.setVisible(false);

        ObservableList<SupplierTm> tmList= FXCollections.observableArrayList();

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM suppliers");
        ResultSet resultSet = pstm.executeQuery();

        while(resultSet.next()){
            list1.add(new Supplier(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));

            for(Supplier supplier:list1){
                tmList.add(new SupplierTm(
                        supplier.getId(),
                        supplier.getName(),
                        supplier.getContact(),
                        supplier.getGender()
                ));
            }

            TreeItem<SupplierTm> treeItem = new RecursiveTreeItem<>(tmList, RecursiveTreeObject::getChildren);
            table1.setRoot(treeItem);
            table1.setShowRoot(false);

            table1.setVisible(true);
        }
    }

    public void loadTable2() throws SQLException, ClassNotFoundException {
        table.setVisible(false);
        table1.setVisible(false);
        pie_chart.setVisible(false);

        ObservableList<ItemTm> tmList= FXCollections.observableArrayList();

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM items");
        ResultSet resultSet = pstm.executeQuery();

        while(resultSet.next()){
            list2.add(new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getString(4),
                    resultSet.getInt(5)
            ));

            for(Item item:list2){
                tmList.add(new ItemTm(
                        item.getCode(),
                        item.getDescription(),
                        item.getUnitPrice(),
                        item.getKind(),
                        item.getQty()
                ));
            }

            TreeItem<ItemTm> treeItem = new RecursiveTreeItem<>(tmList, RecursiveTreeObject::getChildren);
            table2.setRoot(treeItem);
            table2.setShowRoot(false);

            table2.setVisible(true);
        }
    }

    public void loadChart() throws SQLException, ClassNotFoundException {
        table.setVisible(false);
        table1.setVisible(false);
        table2.setVisible(false);

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM bills");
        ResultSet resultSet = pstm.executeQuery();

        int kids = 0;
        int male = 0;
        int female = 0;

        while(resultSet.next()){
            String code = resultSet.getString(6);

            PreparedStatement pstm1 = connection.prepareStatement("SELECT * FROM items WHERE code=?");
            pstm1.setString(1,code);
            ResultSet resultSet1 = pstm1.executeQuery();

            while(resultSet1.next()){
                String kind = resultSet1.getString(4);

                switch(kind){
                    case "Kids" : kids++;break;
                    case "Male" : male++;break;
                    case "Female" : female++;
                }
            }
        }

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Kids",kids),
                        new PieChart.Data("Male",male),
                        new PieChart.Data("Female",female));

        pie_chart.setData(pieChartData);
        pie_chart.setTitle("Sales Percentage Types");

        pie_chart.setVisible(true);
    }
}
