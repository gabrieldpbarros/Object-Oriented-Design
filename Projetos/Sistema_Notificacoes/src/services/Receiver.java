package services;
import interfaces.ReceiverInterface;

public class Receiver implements ReceiverInterface{
    private String msg_override;

    public Receiver(String msg_override) {
        this.msg_override = msg_override;
    }

    public void showNotification(String msg) {
        System.out.println(msg_override + " " + msg);
    }
}
