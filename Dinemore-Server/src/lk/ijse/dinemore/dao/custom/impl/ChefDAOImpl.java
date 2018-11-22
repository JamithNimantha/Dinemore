package lk.ijse.dinemore.dao.custom.impl;

import lk.ijse.dinemore.dao.custom.ChefDAO;
import lk.ijse.dinemore.entity.Chef;
import lk.ijse.dinemore.resource.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ChefDAOImpl implements ChefDAO {
    private SessionFactory sessionFactory;

    public ChefDAOImpl() {
        sessionFactory= HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean save(Chef entity) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        }catch (HibernateException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Chef entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Chef search(String s) throws Exception {
        return null;
    }

    @Override
    public List<Chef> getAll() throws Exception {
        return null;
    }
}
