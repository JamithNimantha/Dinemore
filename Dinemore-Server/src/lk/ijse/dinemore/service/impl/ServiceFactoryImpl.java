package lk.ijse.dinemore.service.impl;

import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.SuperService;
import lk.ijse.dinemore.service.custom.impl.ChefServiceImpl;
import lk.ijse.dinemore.service.custom.impl.MenuServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory {
    public static ServiceFactory serviceFactory;

    public ServiceFactoryImpl() throws RemoteException {
    }
    public ServiceFactory getInstance() throws RemoteException{
        if (serviceFactory==null){
            serviceFactory=new ServiceFactoryImpl();

        }
        return serviceFactory;
    }

    @Override
    public SuperService getService(ServiceType serviceType) throws Exception {
       switch (serviceType){
           case CHEF:
               return new ChefServiceImpl();
           case MENU:
               return new MenuServiceImpl();
           default:
               return null;
       }
    }
}
