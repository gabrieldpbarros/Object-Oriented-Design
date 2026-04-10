package services;
import interfaces.ReceiverInterface;

public class Receiver implements ReceiverInterface{
    public String user;

    public Receiver(String user) { this.user = user; }

    private void showNotification(String msg) {
        System.out.printf("%s: %s%n", this.user, msg);
    }

    public void receiveNotification(String msg) { this.showNotification(msg); }
}