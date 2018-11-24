package lk.ijse.dinemore.business;

import lk.ijse.dinemore.business.custom.impl.ChefBOImpl;
import lk.ijse.dinemore.business.custom.impl.MenuBOImpl;

public class BOFactory {
    public static BOFactory boFactory;
    public enum BOTypes{
        CHEF,MENU
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
            case MENU:
                return new MenuBOImpl();
            default:
                return null;
        }
    }
}
