package lk.ijse.dinemore.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lk.ijse.dinemore.common.DBConnection;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.util.HashMap;

public class ReportsController {

    @FXML
    private JFXButton btnChef;

    @FXML
    private JFXButton btnTelOp;

    @FXML
    private JFXButton btnMenu;

    @FXML
    private JFXButton btnRiderReport;

    @FXML
    void btnChefOnAction(ActionEvent event) {
        try {
            jasper("/lk/ijse/dinemore/reports/Chefs.jasper");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    void btnMenuOnAction(ActionEvent event) {
        try {
            jasper("/lk/ijse/dinemore/reports/Menu.jasper");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    void btnRiderReportOnAction(ActionEvent event) {
        try {
            jasper("/lk/ijse/dinemore/reports/Riders.jasper");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnTelOpOnAction(ActionEvent event) {
        try {
            jasper("/lk/ijse/dinemore/reports/TelOperator.jasper");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void jasper(String path) throws Exception{
            InputStream resourceAsStream = getClass().getResourceAsStream(path);
            HashMap map = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);

    }

}
