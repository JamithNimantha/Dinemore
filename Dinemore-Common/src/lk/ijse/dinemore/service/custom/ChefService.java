package lk.ijse.dinemore.service.custom;

import lk.ijse.dinemore.model.ChefDTO;
import lk.ijse.dinemore.service.SuperService;

import java.util.List;

public interface ChefService extends SuperService {
    public boolean addChef(ChefDTO chefDTO) throws Exception;

    public List<ChefDTO> getAllChefs() throws Exception;

    public ChefDTO searchChef(String id)throws Exception;

    public boolean deleteChef(String id) throws Exception;

    public boolean updateChef(ChefDTO chefDTO) throws Exception;
}
