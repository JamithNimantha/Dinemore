package lk.ijse.dinemore.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXButton btnSignIn;

    @FXML
    private JFXComboBox<?> cmbUserRole;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    void btnSignInOnAction(ActionEvent event) {

    }

}
