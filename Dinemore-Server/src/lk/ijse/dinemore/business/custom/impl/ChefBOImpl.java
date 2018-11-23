package lk.ijse.dinemore.business.custom.impl;

import lk.ijse.dinemore.business.custom.ChefBO;
import lk.ijse.dinemore.dao.custom.ChefDAO;
import lk.ijse.dinemore.dao.custom.impl.ChefDAOImpl;
import lk.ijse.dinemore.entity.Chef;
import lk.ijse.dinemore.model.ChefDTO;
import lk.ijse.dinemore.resource.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ChefBOImpl implements ChefBO {

    private ChefDAO chefDAO;

    public ChefBOImpl(){
        chefDAO= new ChefDAOImpl();
    }

    @Override
    public boolean addChef(ChefDTO chefDTO) throws Exception {
        return chefDAO.save(new Chef(
                chefDTO.getName(),
                chefDTO.getMobile(),
                chefDTO.getAddress(),
                chefDTO.getNic()
        ));
    }

    @Override
    public boolean updateChef(ChefDTO chefDTO) throws Exception {
        return chefDAO.update(new Chef(
                chefDTO.getId(),
                chefDTO.getName(),
                chefDTO.getMobile(),
                chefDTO.getAddress(),
                chefDTO.getNic()
        ));
    }

    @Override
    public boolean deleteChef(String id) throws Exception {
        return chefDAO.delete(id);
    }

    @Override
    public ChefDTO searchChef(String id) throws Exception {
        Chef search = chefDAO.search(id);
        if (search!=null){
            return new ChefDTO(
                    search.getId(),
                    search.getName(),
                    search.getMobile(),
                    search.getAddress(),
                    search.getNic()
            );
        }
        return null;
    }

    @Override
    public List<ChefDTO> getAllChefs() throws Exception {
        List<Chef> all = chefDAO.getAll();
        List<ChefDTO> chefDTOS  = new ArrayList<>();
        for (Chef c:all) {
            chefDTOS.add(new ChefDTO(c.getId(),c.getName(),c.getMobile(),c.getAddress(),c.getNic()));
        }
        return chefDTOS;
    }
}
