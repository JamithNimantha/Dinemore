package lk.ijse.dinemore.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.dinemore.common.Notification;
import lk.ijse.dinemore.model.RiderDTO;
import lk.ijse.dinemore.proxy.ProxyHandler;
import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.custom.RiderService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ManageRiderController implements Initializable {

    @FXML
    private TextField txtSearch;

    @FXML
    private TableView<RiderDTO> tbleRider;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXTextField txtName;

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
    private JFXButton btnUdpate;

    @FXML
    private JFXButton btnRemove;

    private RiderService riderService;

    private void loadTable(){
        try {
            List<RiderDTO> allRiders = riderService.getAllRiders();
            tbleRider.setItems(FXCollections.observableArrayList(allRiders));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            riderService = (RiderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.RIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tbleRider.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tbleRider.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tbleRider.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("mobile"));
        tbleRider.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tbleRider.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("nic"));
        loadTable();
        Platform.runLater(() ->txtName.requestFocus() );

    }

    private void clearFeilds(){
        txtID.clear();
        txtName.clear();
        txtAddress.clear();
        txtMobile.clear();
        txtNIC.clear();
        txtSearch.clear();
    }


    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        try {
            boolean isDeleted = riderService.deleteRider(txtID.getText());
            System.out.println(isDeleted);
            if (isDeleted){
                Notification.createSuccesful("Removed Success","Rider Removed Successfully");
                loadTable();
                clearFeilds();
            }else {
                Notification.createError("Cannot be Removed","Error while Removing Rider");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        try {
            boolean isSaved = riderService.addRider(new RiderDTO(
                    txtName.getText(),
                    txtAddress.getText(),
                    txtMobile.getText(),
                    txtNIC.getText()
            ));
            if (isSaved){
                Notification.createSuccesful("Added Success","Rider Added Successfully");
                loadTable();
                clearFeilds();
            }else {
                Notification.createError("Cannot be Added","Error while adding Rider");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        try {
            boolean isUpdated = riderService.updateRider(new RiderDTO(
                    Integer.parseInt(txtID.getText()),
                    txtName.getText(),
                    txtMobile.getText(),
                    txtAddress.getText(),
                    txtNIC.getText()
            ));
            if (isUpdated){
                Notification.createSuccesful("Updated Success","Rider Updated Successfully");
                loadTable();
                clearFeilds();
            }else {
                Notification.createError("Cannot be Updated","Error while Updating Rider");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void searchOnAction(ActionEvent event) {

    }

    @FXML
    void tbleRiderOnMouseClicked(MouseEvent event) {
        if(tbleRider.getSelectionModel().getSelectedIndex()!=-1){
            RiderDTO selectedItem = tbleRider.getSelectionModel().getSelectedItem();
            txtID.setText(Integer.toString(selectedItem.getId()));
            txtName.setText(selectedItem.getName());
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
    void txtNICOnAction(ActionEvent event) {

    }

    @FXML
    void txtNameName(ActionEvent event) {

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {

    }


}
