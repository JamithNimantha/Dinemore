package lk.ijse.dinemore.reservation;

import java.rmi.Remote;

public interface Reservation extends Remote {
    public abstract boolean reserve(Object id) throws Exception;
    public abstract boolean release(Object id) throws Exception;
}
