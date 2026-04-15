package interfaces;
import services.Receiver;

public interface SMSAdapter {
    void sendMsg(Receiver user, String msg);
}
