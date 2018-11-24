package lk.ijse.dinemore.dao.custom.impl;

import lk.ijse.dinemore.dao.custom.MenuDAO;
import lk.ijse.dinemore.entity.Menu;
import lk.ijse.dinemore.resource.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class MenuDAOImpl implements MenuDAO {
    private SessionFactory sessionFactory;

    public MenuDAOImpl() {
        sessionFactory= HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean save(Menu entity) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();

            session.persist(entity);

            session.getTransaction().commit();
        }catch (HibernateException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Menu entity) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();

            Menu menu = session.get(Menu.class, entity.getId());
            menu.setName(entity.getName());
            menu.setDescription(entity.getDescription());
            menu.setPrice(entity.getPrice());

            session.getTransaction().commit();
        }catch (HibernateException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Menu menu = session.get(Menu.class, Integer.parseInt(s));
            session.remove(menu);

            session.getTransaction().commit();
        }catch (HibernateException e){
            return false;
        }
        return true;
    }

    @Override
    public Menu search(String s) throws Exception {
        return null;
    }

    @Override
    public List<Menu> getAll() throws Exception {
        List list;

        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();

            list = session.createCriteria(Menu.class).list();

            session.getTransaction().commit();
        }
        return list;
    }
}
