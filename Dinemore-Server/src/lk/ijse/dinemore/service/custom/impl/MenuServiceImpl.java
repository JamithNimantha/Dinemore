package lk.ijse.dinemore.service.custom.impl;

import lk.ijse.dinemore.business.BOFactory;
import lk.ijse.dinemore.business.SuperBO;
import lk.ijse.dinemore.business.custom.MenuBO;
import lk.ijse.dinemore.model.MenuDTO;
import lk.ijse.dinemore.service.custom.MenuService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MenuServiceImpl extends UnicastRemoteObject implements MenuService {
    private MenuBO menuBO;

    public MenuServiceImpl() throws RemoteException {
        menuBO = (MenuBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.MENU);
    }

    @Override
    public boolean addMunu(MenuDTO menuDTO) throws Exception {

        return menuBO.addMenu(menuDTO);
    }

    @Override
    public List<MenuDTO> getAllMenus() throws Exception {
        return menuBO.getAllMeal();
    }

    @Override
    public MenuDTO seachMenu(String name) throws Exception {
        return menuBO.searchMenu(name);
    }

    @Override
    public boolean deleteMenu(String id) throws Exception {
        return menuBO.deleteMenu(id);
    }

    @Override
    public boolean updateMenu(MenuDTO menuDTO) throws Exception {
        return menuBO.updateMenu(menuDTO);
    }
}
