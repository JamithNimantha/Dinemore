package lk.ijse.dinemore.business.custom.impl;

import lk.ijse.dinemore.business.custom.TelOperatorBO;
import lk.ijse.dinemore.dao.custom.TelOperatorDAO;
import lk.ijse.dinemore.dao.custom.impl.TelOperatorDAOImpl;
import lk.ijse.dinemore.entity.TelOperator;
import lk.ijse.dinemore.model.TelOperatorDTO;
import java.util.ArrayList;
import java.util.List;

public class TelOperatorBOImpl implements TelOperatorBO {
    TelOperatorDAO telOperatorDAO;

    public TelOperatorBOImpl() {
        telOperatorDAO=new TelOperatorDAOImpl();
    }

    @Override
    public boolean addTelOperator(TelOperatorDTO telOperatorDTO) throws Exception {
        System.out.println(telOperatorDTO+"boimpl");
        return telOperatorDAO.save(new TelOperator(
                telOperatorDTO.getName(),
                telOperatorDTO.getMobile(),
                telOperatorDTO.getAddress(),
                telOperatorDTO.getNic()
        ));
       // return true;
    }

    @Override
    public boolean updateTelOperator(TelOperatorDTO telOperatorDTO) throws Exception {
        return telOperatorDAO.update(new TelOperator(
                telOperatorDTO.getId(),
                telOperatorDTO.getName(),
                telOperatorDTO.getMobile(),
                telOperatorDTO.getAddress(),
                telOperatorDTO.getNic()
        ));
    }

    @Override
    public boolean deleteTelOperator(String id) throws Exception {
        return telOperatorDAO.delete(id);
    }

    @Override
    public List<TelOperatorDTO> getAllTelOperator() throws Exception {
        List<TelOperator> all = telOperatorDAO.getAll();
        List<TelOperatorDTO> telOperatorDTOS  = new ArrayList<>();
        for (TelOperator telOperator:all) {
            telOperatorDTOS.add(new TelOperatorDTO(
                    telOperator.getId(),
                    telOperator.getName(),
                    telOperator.getMobile(),
                    telOperator.getAddress(),
                    telOperator.getNic()
            ));
        }
        return telOperatorDTOS;
    }

    @Override
    public TelOperatorDTO searchTelOperator(String name) throws Exception {
        return null;
    }
}
