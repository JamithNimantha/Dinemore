package lk.ijse.dinemore.business.custom.impl;

import lk.ijse.dinemore.business.custom.MenuBO;
import lk.ijse.dinemore.dao.custom.MenuDAO;
import lk.ijse.dinemore.dao.custom.impl.MenuDAOImpl;
import lk.ijse.dinemore.entity.Menu;
import lk.ijse.dinemore.model.MenuDTO;

import java.util.ArrayList;
import java.util.List;

public class MenuBOImpl implements MenuBO {
    MenuDAO menuDAO;

    public MenuBOImpl() {
        menuDAO=new MenuDAOImpl();
    }

    @Override
    public boolean addMenu(MenuDTO menuDTO) throws Exception {
        return menuDAO.save(new Menu(
                menuDTO.getName(),
                menuDTO.getDescription(),
                menuDTO.getPrice()
                ));
    }

    @Override
    public boolean updateMenu(MenuDTO menuDTO) throws Exception {
        return menuDAO.update(new Menu(
                menuDTO.getId(),
                menuDTO.getName(),
                menuDTO.getDescription(),
                menuDTO.getPrice()
        ));
    }

    @Override
    public boolean deleteMenu(String id) throws Exception {
        return menuDAO.delete(id);
    }

    @Override
    public List<MenuDTO> getAllMeal() throws Exception {
        List<Menu> all = menuDAO.getAll();
        List<MenuDTO> menuDTOS = new ArrayList<>();
        for (Menu menu:all) {
            menuDTOS.add(new MenuDTO(
                    menu.getId(),
                    menu.getName(),
                    menu.getDescription(),
                    menu.getPrice()
                    ));
        }
        return menuDTOS;
    }

    @Override
    public MenuDTO searchMenu(String name) throws Exception {

        return null;
    }
}
