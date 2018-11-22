package lk.ijse.dinemore.business;

import lk.ijse.dinemore.business.custom.impl.ChefBOImpl;

public class BOFactory {
    public static BOFactory boFactory;
    public enum BOTypes{
        CHEF
    }

    public BOFactory() {
    }

    public static BOFactory getInstance(){
        if (boFactory==null){
            boFactory= new BOFactory();
        }
        return boFactory;
    }
    public SuperBO getBOTypes(BOTypes boTypes){
        switch (boTypes){
            case CHEF:
                return  new ChefBOImpl();
            default:
                return null;
        }
    }
}
