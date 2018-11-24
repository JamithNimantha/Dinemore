package lk.ijse.dinemore.business.custom.impl;

import lk.ijse.dinemore.business.custom.RiderBO;
import lk.ijse.dinemore.dao.custom.RiderDAO;
import lk.ijse.dinemore.dao.custom.impl.RiderDAOImpl;
import lk.ijse.dinemore.entity.Rider;
import lk.ijse.dinemore.model.RiderDTO;

import java.util.ArrayList;
import java.util.List;

public class RiderBOImpl implements RiderBO {
    private RiderDAO riderDAO;

    public RiderBOImpl() {
        riderDAO= new RiderDAOImpl();
    }

    @Override
    public boolean addRider(RiderDTO riderDTO) throws Exception {
        return riderDAO.save(new Rider(
                riderDTO.getName(),
                riderDTO.getAddress(),
                riderDTO.getMobile(),
                riderDTO.getNic()
        )) ;
    }

    @Override
    public boolean updateRider(RiderDTO riderDTO) throws Exception {
        return riderDAO.save(new Rider(
                riderDTO.getId(),
                riderDTO.getName(),
                riderDTO.getAddress(),
                riderDTO.getMobile(),
                riderDTO.getNic()
        ));
    }

    @Override
    public boolean deleteRider(String id) throws Exception {
        return riderDAO.delete(id);
    }

    @Override
    public RiderDTO searchRider(String name) throws Exception {
        return null;
    }

    @Override
    public List<RiderDTO> getAllRiders() throws Exception {
        List<Rider> all = riderDAO.getAll();
        List<RiderDTO> riderDTOS = new ArrayList<>();
        for (Rider r:all){
            riderDTOS.add(new RiderDTO(
                            r.getId(),
                            r.getName(),
                            r.getMobile(),
                            r.getAddress(),
                            r.getNic()
                    ));
        }

        return riderDTOS;

    }
}
