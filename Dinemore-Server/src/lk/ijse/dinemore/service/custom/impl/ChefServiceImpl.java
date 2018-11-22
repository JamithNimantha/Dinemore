package lk.ijse.dinemore.service.custom.impl;

import lk.ijse.dinemore.business.BOFactory;
import lk.ijse.dinemore.business.custom.ChefBO;
import lk.ijse.dinemore.model.ChefDTO;
import lk.ijse.dinemore.service.custom.ChefService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ChefServiceImpl extends UnicastRemoteObject implements ChefService {

    private ChefBO chefBO;

    public ChefServiceImpl() throws RemoteException {
        chefBO = (ChefBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.CHEF);
    }

    @Override
    public boolean addChef(ChefDTO chefDTO) throws Exception {
        return chefBO.addChef(chefDTO);
    }

    @Override
    public List<ChefDTO> getAllChefs() throws Exception {
        return chefBO.getAllChefs();
    }

    @Override
    public boolean deleteChef(String id) throws Exception {
        return false;
    }

    @Override
    public boolean updateChef(ChefDTO chefDTO) throws Exception {
        return false;
    }
}
