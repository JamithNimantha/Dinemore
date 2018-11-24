package lk.ijse.dinemore.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.dinemore.model.TelOperatorDTO;
import lk.ijse.dinemore.proxy.ProxyHandler;
import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.SuperService;
import lk.ijse.dinemore.service.custom.TelOperatorService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ManageTelOperatorController implements Initializable {

    @FXML
    private TableView<TelOperatorDTO> tblTelOp;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private TextField txtSearch;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtNIC;

    @FXML
    private JFXTextField txtMobile;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnRemove;

    private TelOperatorService telOperatorService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            telOperatorService = (TelOperatorService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.TELOPERATOR);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblTelOp.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblTelOp.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblTelOp.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("mobile"));
        tblTelOp.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblTelOp.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("nic"));
        loadTable();

    }
    private void loadTable(){
        List<TelOperatorDTO> allTelOperators ;
        try {
            allTelOperators = telOperatorService.getAllTelOperators();
            tblTelOp.setItems(FXCollections.observableArrayList(allTelOperators));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        try {
            boolean isDeleted = telOperatorService.deleteTelOperator(txtID.getText());
            if (isDeleted){
                System.out.println("Tel  deleted...");
                loadTable();
            }else {
                System.out.println("not deleted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    void btnSave(ActionEvent event) {
        try {
            boolean isAdded = telOperatorService.addTelOperator(new TelOperatorDTO(
                    txtName.getText(),
                    txtMobile.getText(),
                    txtMobile.getText(),
                    txtNIC.getText()
            ));
            if (isAdded){
                System.out.println("added");
                loadTable();

            }else {
                System.out.println("not added");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        try {
            boolean isUpdated = telOperatorService.updateTelOperator(new TelOperatorDTO(
                    Integer.parseInt(txtID.getText()),
                    txtName.getText(),
                    txtMobile.getText(),
                    txtAddress.getText(),
                    txtNIC.getText()
            ));
            if (isUpdated){
                System.out.println("updated");
                loadTable();
            }else {
                System.out.println("not updated");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void searchOnAction(ActionEvent event) {

    }

    @FXML
    void tblTelOpOnAction(MouseEvent event) {
        if (tblTelOp.getSelectionModel().getSelectedIndex()!=-1){
            TelOperatorDTO selectedItem = tblTelOp.getSelectionModel().getSelectedItem();
            txtID.setText(String.valueOf(selectedItem.getId()));
            txtName.setText(txtName.getText());
            txtMobile.setText(selectedItem.getMobile());
            txtAddress.setText(selectedItem.getAddress());
            txtNIC.setText(selectedItem.getNic());
        }

    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtIDOnAction(ActionEvent event) {

    }

    @FXML
    void txtMobileOnAction(ActionEvent event) {

    }

    @FXML
    void txtNICOnAction(ActionEvent event) {

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {

    }


}
