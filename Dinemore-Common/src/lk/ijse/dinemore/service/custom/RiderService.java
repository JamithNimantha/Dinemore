package lk.ijse.dinemore.service.custom;

import lk.ijse.dinemore.model.RiderDTO;
import lk.ijse.dinemore.service.SuperService;

import java.util.List;

public interface RiderService extends SuperService {
    public boolean addRider(RiderDTO riderDTO) throws Exception;

    public boolean updateRider(RiderDTO riderDTO) throws Exception;

    public boolean deleteRider(String id) throws Exception;

    public List<RiderDTO> getAllRiders() throws Exception;

    public RiderDTO searchRiders(String name) throws Exception;
}
