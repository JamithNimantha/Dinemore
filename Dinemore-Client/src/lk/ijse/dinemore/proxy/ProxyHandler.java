package lk.ijse.dinemore.proxy;

import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.SuperService;
import lk.ijse.dinemore.service.custom.ChefService;
import lk.ijse.dinemore.service.custom.MenuService;
import lk.ijse.dinemore.service.custom.RiderService;
import lk.ijse.dinemore.service.custom.TelOperatorService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ProxyHandler implements ServiceFactory {
    private static ProxyHandler proxyHandler;
    private ServiceFactory serviceFactory;
    private ChefService chefService;
    private MenuService menuService;
    private TelOperatorService telOperatorService;
    private RiderService riderService;


    private ProxyHandler() {

        try {
            serviceFactory =(ServiceFactory) Naming.lookup("rmi://127.0.0.1:5050/dinemore");
            chefService = (ChefService) serviceFactory.getService(ServiceType.CHEF);
            menuService = (MenuService) serviceFactory.getService(ServiceType.MENU);
            telOperatorService= (TelOperatorService) serviceFactory.getService(ServiceType.TELOPERATOR);
            riderService= (RiderService) serviceFactory.getService(ServiceType.RIDER);

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ProxyHandler getInstance(){
        if (proxyHandler==null){
            proxyHandler=new ProxyHandler();
        }
        return proxyHandler;
    }

    @Override
    public SuperService getService(ServiceType serviceType) throws Exception {
        switch (serviceType){
            case CHEF:
                return chefService;
            case MENU:
                return menuService;
            case TELOPERATOR:
                return telOperatorService;
            case RIDER:
                return riderService;
             default:
                 return null;
        }
    }
}
