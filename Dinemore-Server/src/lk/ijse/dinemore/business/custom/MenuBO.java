package lk.ijse.dinemore.business.custom;

import lk.ijse.dinemore.business.SuperBO;
import lk.ijse.dinemore.model.MenuDTO;

import java.util.List;

public interface MenuBO extends SuperBO {

    public boolean addMenu(MenuDTO menuDTO) throws Exception;

    public boolean updateMenu(MenuDTO menuDTO) throws Exception;

    public boolean deleteMenu(String id) throws Exception;

    public List<MenuDTO> getAllMeal() throws Exception;

    public MenuDTO searchMenu(String name) throws Exception;

}
