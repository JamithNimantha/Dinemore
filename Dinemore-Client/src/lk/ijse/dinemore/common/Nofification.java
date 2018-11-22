package lk.ijse.dinemore.common;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class Nofification {
    private static void create(String title,String text,String grafic){
        Notifications notifications = Notifications.create()
                .title(title)
                .text(text)
                .position(Pos.TOP_LEFT)
                .hideAfter(Duration.millis(5000))
                .graphic(new ImageView(grafic));
        notifications.show();
    }
}
