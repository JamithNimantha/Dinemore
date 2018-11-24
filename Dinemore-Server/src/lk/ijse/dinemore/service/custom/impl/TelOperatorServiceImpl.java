package lk.ijse.dinemore.service.custom.impl;

import lk.ijse.dinemore.business.BOFactory;
import lk.ijse.dinemore.business.custom.TelOperatorBO;
import lk.ijse.dinemore.business.custom.impl.TelOperatorBOImpl;
import lk.ijse.dinemore.model.TelOperatorDTO;
import lk.ijse.dinemore.service.custom.TelOperatorService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class TelOperatorServiceImpl extends UnicastRemoteObject implements TelOperatorService {
    private TelOperatorBO telOperatorBO;

    public TelOperatorServiceImpl() throws RemoteException {
//        telOperatorBO= (TelOperatorBO) BOFactory.getInstance().getBOTypes(BOFactory.BOTypes.TELOPERATOR);
        telOperatorBO= new TelOperatorBOImpl();
    }

    @Override
    public boolean addTelOperator(TelOperatorDTO telOperatorDTO) throws Exception {
        System.out.println(telOperatorDTO+"serviceimpl"+telOperatorBO);
        return telOperatorBO.addTelOperator(telOperatorDTO);
    }

    @Override
    public boolean updateTelOperator(TelOperatorDTO telOperatorDTO) throws Exception {
        return telOperatorBO.updateTelOperator(telOperatorDTO);
    }

    @Override
    public boolean deleteTelOperator(String id) throws Exception {
        return telOperatorBO.deleteTelOperator(id);
    }

    @Override
    public List<TelOperatorDTO> getAllTelOperators() throws Exception {
         return  telOperatorBO.getAllTelOperator();

    }

    @Override
    public TelOperatorDTO searchTelOperator(String name) throws Exception {
        return telOperatorBO.searchTelOperator(name);
    }
}
