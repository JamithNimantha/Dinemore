package lk.ijse.dinemore.business.custom;

import lk.ijse.dinemore.business.SuperBO;
import lk.ijse.dinemore.model.TelOperatorDTO;

import java.util.List;

public interface TelOperatorBO extends SuperBO {
    public boolean addTelOperator(TelOperatorDTO telOperatorDTO) throws Exception;

    public boolean updateTelOperator(TelOperatorDTO telOperatorDTO) throws Exception;

    public boolean deleteTelOperator(String id) throws Exception;

    public List<TelOperatorDTO> getAllTelOperator() throws Exception;

    public TelOperatorDTO searchTelOperator(String name) throws Exception;
}
