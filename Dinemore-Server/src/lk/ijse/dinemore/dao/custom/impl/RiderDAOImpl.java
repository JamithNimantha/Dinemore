package lk.ijse.dinemore.dao.custom.impl;

import lk.ijse.dinemore.dao.custom.RiderDAO;
import lk.ijse.dinemore.entity.Rider;
import lk.ijse.dinemore.resource.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class RiderDAOImpl implements RiderDAO {
    private SessionFactory sessionFactory;

    public RiderDAOImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean save(Rider entity){
        System.out.println(entity+"daoimpl"+sessionFactory);
        System.out.println(sessionFactory);
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();

            session.persist(entity);

            session.getTransaction().commit();
        }catch (Exception e){
        return false;
        }
        return true;
    }

    @Override
    public boolean update(Rider entity) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();

            Rider rider = session.get(Rider.class, entity.getId());
            rider.setName(entity.getName());
            rider.setAddress(entity.getAddress());
            rider.setMobile(entity.getMobile());
            rider.setNic(entity.getNic());

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
            Rider rider = session.get(Rider.class, Integer.parseInt(s));
            session.remove(rider);
            session.getTransaction().commit();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Rider search(String s) throws Exception {
        return null;
    }

    @Override
    public List<Rider> getAll() throws Exception {
        List list;
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();

            list = session.createCriteria(Rider.class).list();

            session.getTransaction().commit();


        }catch (Exception e){
            return null;
        }
        System.out.println(list);
        return list;
    }
}
