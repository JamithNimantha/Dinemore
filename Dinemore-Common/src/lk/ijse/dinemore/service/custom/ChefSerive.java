package lk.ijse.dinemore.service.custom;

import lk.ijse.dinemore.model.ChefDTO;

import java.util.List;

public interface ChefSerive {
    public boolean addChef(ChefDTO chefDTO) throws Exception;

    public List<ChefDTO> getAllChefs() throws Exception;

    public boolean deleteChef(String id) throws Exception;

    public boolean updateChef(ChefDTO chefDTO) throws Exception;
}
