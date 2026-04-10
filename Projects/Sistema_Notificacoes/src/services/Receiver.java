package services;
import interfaces.ReceiverInterface;

public class Receiver implements ReceiverInterface{
    private static Receiver instance;
    public String user;

    private Receiver(String user) { this.user = user; }

    public static Receiver getInstance(String user) {
        if (instance == null)
            instance = new Receiver(user);
        return instance;
    }

    private void showNotification(String msg) {
        System.out.printf("%s: %s%n", this.user, msg);
    }

    public void receiveNotification(String msg) { this.showNotification(msg); }
}