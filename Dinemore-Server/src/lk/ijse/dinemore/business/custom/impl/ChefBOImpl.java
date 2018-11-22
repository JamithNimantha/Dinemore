package lk.ijse.dinemore.business.custom.impl;

import lk.ijse.dinemore.business.custom.ChefBO;
import lk.ijse.dinemore.dao.custom.ChefDAO;
import lk.ijse.dinemore.dao.custom.impl.ChefDAOImpl;
import lk.ijse.dinemore.entity.Chef;
import lk.ijse.dinemore.model.ChefDTO;
import lk.ijse.dinemore.resource.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ChefBOImpl implements ChefBO {
   // private SessionFactory sessionFactory;

    private ChefDAO chefDAO;

    public ChefBOImpl(){
        //sessionFactory = HibernateUtil.getSessionFactory();
        chefDAO= new ChefDAOImpl();
    }

    @Override
    public boolean addChef(ChefDTO chefDTO) throws Exception {
//        boolean isSaved=false;
//        try (Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//            System.out.println("boimpl"+chefDTO);
//            ChefDTO dto = new ChefDTO(
//                    chefDTO.getName(),
//                    chefDTO.getMobile(),
//                    chefDTO.getAddress(),
//                    chefDTO.getNic());
//            session.save(dto);
//            isSaved = (session.save(dto)!= null);
//            session.getTransaction().commit();
//           // session.flush();
//            return isSaved;
//        }
        return chefDAO.save(new Chef(
                chefDTO.getName(),
                chefDTO.getMobile(),
                chefDTO.getAddress(),
                chefDTO.getNic()
        ));
    }

    @Override
    public boolean updateChef(ChefDTO chefDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteChef(String id) throws Exception {
        return false;
    }

    @Override
    public List<ChefDTO> getAllChefs() throws Exception {
        return null;
    }
}
