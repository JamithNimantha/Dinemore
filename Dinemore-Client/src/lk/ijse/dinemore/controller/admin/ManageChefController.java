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
import lk.ijse.dinemore.model.ChefDTO;
import lk.ijse.dinemore.proxy.ProxyHandler;
import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.custom.ChefService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ManageChefController implements Initializable{

    @FXML
    private TableView<ChefDTO> tblChef;

    @FXML
    private JFXTextField txtId;

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

    private ChefService chefService;

    private void getAllChefs(){
        try {
            List<ChefDTO> allChefs = chefService.getAllChefs();
            tblChef.setItems(FXCollections.observableArrayList(allChefs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            chefService = (ChefService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.CHEF);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblChef.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblChef.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblChef.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("mobile"));
        tblChef.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblChef.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("nic"));
        getAllChefs();
        Platform.runLater(() ->txtName.requestFocus() );
    }
    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        try {
            boolean b = chefService.deleteChef(txtId.getText());
            if (b){
                Notification.createSuccesful("Removed Success","Chef Removed Successfully");
                getAllChefs();
                clearFeilds();
            }else {
                Notification.createError("Cannot be Removed","Error while Removing Chef");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void   btnSaveOnAction(ActionEvent event) {
        try {
            ChefDTO chefDTO =new ChefDTO(
                    txtName.getText(),
                    txtMobile.getText(),
                    txtAddress.getText(),
                    txtNIC.getText()
            );
            boolean result = chefService.addChef(chefDTO);
            if (result){
                Notification.createSuccesful("Added Success","Chef Added Successfully");
                getAllChefs();
                clearFeilds();
            }else {
                Notification.createError("Cannot be Added","Error while adding Chef");
                System.out.println("Error Occured...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        try {
            boolean isUpdated = chefService.updateChef(new ChefDTO(
                    Integer.parseInt(txtId.getText()),
                    txtName.getText(),
                    txtMobile.getText(),
                    txtAddress.getText(),
                    txtNIC.getText()
            ));
            if (isUpdated){
                Notification.createSuccesful("Updated Success","Chef Updatef Successfully");
                getAllChefs();
                clearFeilds();
            }else {
                Notification.createError("Cannot be Updated","Error while Updating Chef");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    void tblChefOnClicked(MouseEvent event) {
        if (tblChef.getSelectionModel().getSelectedIndex()!=-1){
            ChefDTO selectedItem = tblChef.getSelectionModel().getSelectedItem();
            txtId.setText(String.valueOf(selectedItem.getId()));
            txtName.setText(selectedItem.getName());
            txtMobile.setText(selectedItem.getMobile());
            txtAddress.setText(selectedItem.getAddress());
            txtNIC.setText(selectedItem.getNic());
        }


    }
    @FXML
    void txtSearchOnAction(ActionEvent event) {
        try {
            ChefDTO chefDTO = chefService.searchChef(txtSearch.getText());
            if (chefDTO!=null){
                tblChef.setItems(FXCollections.observableArrayList(chefDTO));
            }else{
                Notification.createError("Cannot be Searched","Error while Searching ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void clearFeilds(){
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtNIC.clear();
        txtMobile.clear();
        txtSearch.clear();
    }


}
