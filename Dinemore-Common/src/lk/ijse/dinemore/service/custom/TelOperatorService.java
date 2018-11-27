package lk.ijse.dinemore.service.custom;

import lk.ijse.dinemore.model.TelOperatorDTO;
import lk.ijse.dinemore.service.SuperService;

import java.util.List;

public interface TelOperatorService extends SuperService {

    public boolean addTelOperator(TelOperatorDTO telOperatorDTO) throws Exception;

    public boolean updateTelOperator(TelOperatorDTO telOperatorDTO) throws Exception;

    public boolean deleteTelOperator(String id) throws Exception;

    public List<TelOperatorDTO> getAllTelOperators() throws Exception;

    public TelOperatorDTO searchTelOperator(String name) throws Exception;

}
