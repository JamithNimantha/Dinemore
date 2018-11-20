package lk.ijse.dinemore.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.dinemore.model.ChefDTO;
import lk.ijse.dinemore.proxy.ProxyHandler;
import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.SuperService;
import lk.ijse.dinemore.service.custom.ChefService;

public class ManageChefController {

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

    public ManageChefController() {
        try {
            chefService = (ChefService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.CHEF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }

    @FXML
    public Boolean  btnSaveOnAction(ActionEvent event) {
//        Boolean result=false;
//        try {
//            ChefDTO chefDTO = new ChefDTO(Integer.parseInt(txtId.getText()),txtName.getText(),txtMobile.getText(),txtAddress.getText(),txtNIC.getText());
//            result = chefService.addChef(chefDTO);
//            System.out.println(chefDTO);
//
//            if (result){
//                System.out.println("Chef added...");
//            }else {
//                System.out.println("Error Occured");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
        return null;

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

}
