package lk.ijse.dinemore.dao;

import java.util.List;

public interface CrudDAO <T,ID> extends SuperDAO {
    public boolean save(T entity) throws Exception;

    public boolean update(T entity) throws Exception;

    public boolean delete(ID id) throws Exception;

    public T search(ID id) throws Exception;

    public List<T> getAll() throws Exception;
}
