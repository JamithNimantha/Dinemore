package lk.ijse.dinemore.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.dinemore.common.Notification;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXButton btnSignIn;

    @FXML
    private JFXComboBox<String> cmbUserRole;

    @FXML
    private JFXPasswordField txtPassword;


    @FXML
    void btnSignInOnAction(ActionEvent event) throws IOException {
        String value = cmbUserRole.getValue();
        Stage stage = (Stage) btnSignIn.getScene().getWindow();
        if (value.equals("Admin")){
            if (txtUsername.getText().equals("admin") && txtPassword.getText().equals("1234")){
                Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dinemore/view/admin/AdminDash.fxml"));
                Scene scene = new Scene(parent);
                stage.setResizable(false);
                stage.setScene(scene);
                stage.setTitle("Admin Dash Board");
                stage.show();
            }else {
                Notification.createError("Invalid Login","Incorrect username or password");
            }
        }if (value.equals("Chef")){
            Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dinemore/view/chef/ChefDash.fxml"));
            Scene scene = new Scene(parent);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }if (value.equals("Rider")){
            Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dinemore/view/rider/RiderDash.fxml"));
            Scene scene = new Scene(parent);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

        }if (value.equals("Tel Operator")){
            Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dinemore/view/teloperator/TelOpDash.fxml"));
            Scene scene = new Scene(parent);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

        }else {

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getRoles();

    }

    private void getRoles(){
        ObservableList<String> roles = FXCollections.observableArrayList("Tel Operator", "Chef", "Rider", "Admin");
        cmbUserRole.setItems(roles);
    }
}
