package lk.ijse.dinemore.respository;

import org.hibernate.Session;

import java.util.List;

public interface SuperRepository<T,ID> {
    public void setSession(Session session);

    public boolean save(T t) throws Exception;

    public void delete(T t) throws Exception;

    public void update(T t) throws Exception;

    public T findById(ID id) throws Exception;

    public List<T> findAll() throws Exception;
}
