package lk.ijse.dinemore.dao.custom.impl;

import lk.ijse.dinemore.dao.custom.TelOperatorDAO;
import lk.ijse.dinemore.entity.TelOperator;
import lk.ijse.dinemore.resource.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TelOperatorDAOImpl implements TelOperatorDAO {
    private SessionFactory sessionFactory;

    public TelOperatorDAOImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean save(TelOperator entity) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            System.out.println(session);
            session.getTransaction().begin();

            System.out.println(entity);
            session.persist(entity);
            System.out.println(entity);

            session.getTransaction().commit();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(TelOperator entity) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();

            TelOperator telOperator = session.get(TelOperator.class, entity.getId());
            telOperator.setName(entity.getName());
            telOperator.setMobile(entity.getMobile());
            telOperator.setAddress(entity.getAddress());
            telOperator.setNic(entity.getNic());

            session.getTransaction().commit();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();

            TelOperator telOperator = session.get(TelOperator.class, Integer.parseInt(s));
            session.remove(telOperator);

            session.getTransaction().commit();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public TelOperator search(String s) throws Exception {
        return null;
    }

    @Override
    public List<TelOperator> getAll() throws Exception {
        List list;
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();

            list = session.createCriteria(TelOperator.class).list();

            session.getTransaction().commit();
        }catch (Exception e){
            return null;
        }
        return list;

    }
}
