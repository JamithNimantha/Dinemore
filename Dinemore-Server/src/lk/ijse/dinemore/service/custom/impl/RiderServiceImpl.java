package lk.ijse.dinemore.service.custom.impl;

import lk.ijse.dinemore.business.BOFactory;
import lk.ijse.dinemore.business.custom.RiderBO;
import lk.ijse.dinemore.model.RiderDTO;
import lk.ijse.dinemore.service.custom.RiderService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RiderServiceImpl extends UnicastRemoteObject implements RiderService {
    RiderBO riderBO ;

    public RiderServiceImpl() throws RemoteException {
       riderBO= (RiderBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.RIDER);
    }

    @Override
    public boolean addRider(RiderDTO riderDTO) throws Exception {
        return riderBO.addRider(riderDTO);
    }

    @Override
    public boolean updateRider(RiderDTO riderDTO) throws Exception {
        return riderBO.updateRider(riderDTO);
    }

    @Override
    public boolean deleteRider(String id) throws Exception {
        return riderBO.deleteRider(id);
    }

    @Override
    public List<RiderDTO> getAllRiders() throws Exception {
           return riderBO.getAllRiders();

    }

    @Override
    public RiderDTO searchRiders(String name) throws Exception {
        return riderBO.searchRider(name);
    }
}
