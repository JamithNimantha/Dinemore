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
import lk.ijse.dinemore.common.Notification;
import lk.ijse.dinemore.model.MenuDTO;
import lk.ijse.dinemore.proxy.ProxyHandler;
import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.custom.MenuService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class ManageMenuController implements Initializable {

    @FXML
    private TableView<MenuDTO> tblMenu;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private TextField txtSearch;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnRemove;

    private MenuService menuService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            menuService = (MenuService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.MENU);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblMenu.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblMenu.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblMenu.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblMenu.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("price"));
        getAllChefs();

    }

    private void getAllChefs(){
        try {
            List<MenuDTO> allMenus = menuService.getAllMenus();
            tblMenu.setItems(FXCollections.observableArrayList(allMenus));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        try {
            boolean isDeleted = menuService.deleteMenu(txtID.getText());
            if (isDeleted){
                Notification.createSuccesful("Remove Success","Menu Remove Successfully");
                getAllChefs();
                clearFeilds();
            }else {
                Notification.createError("Cannot be Removed","Error while removing Menu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        try {
            boolean isAdded = menuService.addMunu(new MenuDTO(
                    txtName.getText(),
                    txtDescription.getText(),
                    Double.parseDouble(txtPrice.getText())
            ));
            if (isAdded){
                Notification.createSuccesful("Added Success","Menu Added Successfully");
                getAllChefs();
                clearFeilds();
            }else {
                Notification.createError("Cannot be Added","Error while adding Menu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        try {
            boolean isUpdated = menuService.updateMenu(new MenuDTO(
                    Integer.parseInt(txtID.getText()),
                    txtName.getText(),
                    txtDescription.getText(),
                    Double.parseDouble(txtPrice.getText())
            ));
            if (isUpdated){
                Notification.createSuccesful("Updated Success","Menu updated Successfully");
                getAllChefs();
                clearFeilds();
            }else {
                Notification.createError("Cannot be updated","Error while updated Menu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void tbleMenuOnMouseClicked(MouseEvent event) {
        MenuDTO selectedItem = tblMenu.getSelectionModel().getSelectedItem();
        if(selectedItem!=null){
            txtID.setText(Integer.toString(selectedItem.getId()));
            txtName.setText(selectedItem.getName());
            txtDescription.setText(selectedItem.getDescription());
            txtPrice.setText(Double.toString(selectedItem.getPrice()));
        }
    }

    @FXML
    void txtDescriptionOnAction(ActionEvent event) {

    }

    @FXML
    void txtID(ActionEvent event) {

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtPriceOnAction(ActionEvent event) {

    }
    private void clearFeilds(){
        txtID.clear();
        txtName.clear();
        txtDescription.clear();
        txtPrice.clear();
        txtSearch.clear();
    }


}
