package lk.ijse.dinemore.business;

import lk.ijse.dinemore.business.custom.impl.ChefBOImpl;
import lk.ijse.dinemore.business.custom.impl.MenuBOImpl;
import lk.ijse.dinemore.business.custom.impl.RiderBOImpl;
import lk.ijse.dinemore.business.custom.impl.TelOperatorBOImpl;

public class BOFactory {
    public static BOFactory boFactory;
    public enum BOTypes{
        CHEF,MENU,TELOPERATOR,RIDER
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
            case RIDER:
                return new RiderBOImpl();
            case TELOPERATOR:
                return new TelOperatorBOImpl();
            default:
                return null;
        }
    }
}
