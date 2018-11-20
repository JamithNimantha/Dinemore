package lk.ijse.dinemore.service.impl;

import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.SuperService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory {

    public ServiceFactoryImpl() throws RemoteException {
    }

    @Override
    public SuperService getService(ServiceType serviceType) throws Exception {
        return null;
    }
}
