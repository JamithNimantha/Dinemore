package lk.ijse.dinemore.business.custom;

import lk.ijse.dinemore.business.SuperBO;
import lk.ijse.dinemore.model.RiderDTO;

import java.util.List;

public interface RiderBO extends SuperBO {
    public boolean addRider(RiderDTO riderDTO) throws Exception;

    public boolean updateRider(RiderDTO riderDTO) throws Exception;

    public boolean deleteRider(String id) throws Exception;

    public RiderDTO searchRider(String name) throws Exception;

    public List<RiderDTO> getAllRiders() throws Exception;


}
