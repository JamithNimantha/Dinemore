package lk.ijse.dinemore.service;

import java.rmi.Remote;

public interface ServiceFactory extends Remote {
    public enum ServiceType{
        CHEF,MEMU
    }

    public SuperService getService(ServiceType serviceType) throws Exception ;
}
