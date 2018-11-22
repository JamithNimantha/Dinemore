package lk.ijse.dinemore.startup;

import lk.ijse.dinemore.service.impl.ServiceFactoryImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartUpServer {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname","127.0.0.1");
            Registry registry = LocateRegistry.createRegistry(5050);
            registry.bind("dinemore", new ServiceFactoryImpl().getInstance());
            System.out.println("Server has been Started");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
