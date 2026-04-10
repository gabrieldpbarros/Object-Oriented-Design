package factories;
import services.Notification;

public class NotiFactory {
    public static Notification create() {
        return new Notification();
    }
}
