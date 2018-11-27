package lk.ijse.dinemore.service.custom;

import lk.ijse.dinemore.model.MenuDTO;
import lk.ijse.dinemore.service.SuperService;

import java.util.List;

public interface MenuService extends SuperService {
    public boolean addMunu(MenuDTO menuDTO) throws Exception;

    public List<MenuDTO> getAllMenus() throws Exception;

    public MenuDTO seachMenu(String name) throws Exception;

    public boolean deleteMenu(String id) throws Exception;

    public boolean updateMenu(MenuDTO menuDTO) throws Exception;


}
