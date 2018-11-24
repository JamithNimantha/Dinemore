package lk.ijse.dinemore.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
      //  btnChef.setStyle(" -fx-accent: #0093ff;");
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
        try {
            Node child = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dinemore/view/admin/ManageMenu.fxml"));
            if (!pnlMain.getChildren().isEmpty()){
                pnlMain.getChildren().remove(0);
            }
            pnlMain.getChildren().add(child);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnReportOnAction(ActionEvent event) {
        try {
            Node child = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dinemore/view/admin/Reports.fxml"));
            if (!(pnlMain.getChildren().isEmpty())){
                pnlMain.getChildren().remove(0);
            }
            pnlMain.getChildren().add(child);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnRiderOnAction(ActionEvent event) {
        try {
            Node child = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dinemore/view/admin/ManageRider.fxml"));
            if (!(pnlMain.getChildren().isEmpty())){
                pnlMain.getChildren().remove(0);
            }
            pnlMain.getChildren().add(child);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSettingsOnAction(ActionEvent event) {

    }
    @FXML
    void btnLogoutOnAction(ActionEvent event) {
        try {
            Stage stage = (Stage) btnLogout.getScene().getWindow();
            Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dinemore/view/Login.fxml"));
            Scene scene =  new Scene(parent);
            stage.resizableProperty().setValue(Boolean.FALSE);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // Platform.exit();
    }

    @FXML
    void btnTelOpOnAction(ActionEvent event) {
        try {
            Node child = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dinemore/view/admin/ManageTelOperator.fxml"));
            if (!(pnlMain.getChildren().isEmpty())){
                pnlMain.getChildren().remove(0);
            }
            pnlMain.getChildren().add(child);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
