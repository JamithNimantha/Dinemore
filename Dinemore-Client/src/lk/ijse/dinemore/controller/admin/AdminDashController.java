package lk.ijse.dinemore.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;

public class AdminDashController {


    @FXML
    private JFXButton btnMenu;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnDash;

    @FXML
    private JFXButton btnCustomer;

    @FXML
    private JFXButton btnTelOp;

    @FXML
    private JFXButton btnChef;

    @FXML
    private JFXButton btnRider;

    @FXML
    private JFXButton btnReport;

    @FXML
    private JFXButton btnSettings;

    @FXML
    private AnchorPane pnlMain;


    @FXML
    void btnChefOnAction(ActionEvent event) {
      //  btnChef.requestFocus();
      //  btnChef.setRipplerFill(Color.DARKBLUE);
       // btnChef.setFocusTraversable(false);
        try {
            Node child=FXMLLoader.load(this.getClass().getResource("/lk/ijse/dinemore/view/admin/ManageChef.fxml"));
            if (!pnlMain.getChildren().isEmpty()){
                pnlMain.getChildren().remove(0);
            }
            pnlMain.getChildren().add(child);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnMenuOnAction(ActionEvent event) {

    }

    @FXML
    void btnReportOnAction(ActionEvent event) {

    }

    @FXML
    void btnRiderOnAction(ActionEvent event) {

    }

    @FXML
    void btnSettingsOnAction(ActionEvent event) {

    }

    @FXML
    void btnTelOpOnAction(ActionEvent event) {

    }

}
