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
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Chef chef = session.get(Chef.class, entity.getId());
            chef.setName(entity.getName());
            chef.setMobile(entity.getMobile());
            chef.setAddress(entity.getAddress());
            chef.setNic(entity.getNic());
            session.getTransaction().commit();
        }catch (HibernateException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            Chef chef = session.get(Chef.class, Integer.parseInt(id));
            session.remove(chef);
            session.getTransaction().commit();
        }catch (HibernateException e){
            return false;
        }
        return true;
    }

    @Override
    public Chef search(String s) throws Exception {
        Chef chef =null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
//            SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM chef WHERE name=:chef_name");
//            sqlQuery.addEntity(Chef.class);
//            sqlQuery.setParameter("chef_name",s);
//            chef = (Chef) sqlQuery.list();
            session.getTransaction().commit();

        }catch (HibernateException e){
            return null;
        }
        return chef;
    }

    @Override
    public List<Chef> getAll() throws Exception {
        List list;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
           // list = session.createQuery("from chef").list();
            list = session.createCriteria(Chef.class).list();
            session.getTransaction().commit();
        }catch (HibernateException e){
            return null;
        }
        return list;
    }
}
