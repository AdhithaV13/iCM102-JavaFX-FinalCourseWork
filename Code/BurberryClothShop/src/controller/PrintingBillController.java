package controller;

import db.DBConnection;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class PrintingBillController implements Initializable {

    @FXML
    private AnchorPane printingBillPane;

    @FXML
    private Button btnBack;

    @FXML
    private Label txtCode;

    @FXML
    private Label txtDate;

    @FXML
    private Button btnPrint;

    @FXML
    private Label txtFinal;

    @FXML
    private Label txtPrice;

    @FXML
    private Label txtQty;

    @FXML
    private Label txtTotal;

    @FXML
    void btnBackClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage)printingBillPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/HomePage.fxml"))));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateDateAndTime();
        try {
            setLabels();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void generateDateAndTime(){
        Timeline date = new Timeline(new KeyFrame(
                Duration.ZERO,
                actionEvent -> txtDate.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        ), new KeyFrame(Duration.seconds(1)));
        date.setCycleCount(Animation.INDEFINITE);
        date.play();
    }

    public void setLabels() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM bills ORDER BY billId DESC LIMIT 1");
        ResultSet resultSet = pstm.executeQuery();

        while(resultSet.next()){
            txtCode.setText(resultSet.getString(6));
            txtPrice.setText(""+resultSet.getDouble(7));
            txtQty.setText(""+resultSet.getInt(8));
            txtTotal.setText("= "+resultSet.getDouble(9));

            Double total = resultSet.getDouble(9);

            txtFinal.setText("= "+(total-((total/100)*20)));
        }
    }

    @FXML
    void btnPrintClicked(MouseEvent event) throws JRException, SQLException, ClassNotFoundException {
        JasperDesign design = JRXmlLoader.load("reports/Bill.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint,false);
    }

}
