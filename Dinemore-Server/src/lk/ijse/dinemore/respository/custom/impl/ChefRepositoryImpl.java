package lk.ijse.dinemore.respository.custom.impl;

import lk.ijse.dinemore.entity.Chef;
import lk.ijse.dinemore.respository.custom.ChefRepository;
import org.hibernate.Session;

import java.util.List;

public class ChefRepositoryImpl implements ChefRepository {
    @Override
    public void setSession(Session session) {

    }

    @Override
    public boolean save(Chef chef) throws Exception {
        return false;
    }

    @Override
    public void delete(Chef chef) throws Exception {

    }

    @Override
    public void update(Chef chef) throws Exception {

    }

    @Override
    public Chef findById(String s) throws Exception {
        return null;
    }

    @Override
    public List<Chef> findAll() throws Exception {
        return null;
    }
}
