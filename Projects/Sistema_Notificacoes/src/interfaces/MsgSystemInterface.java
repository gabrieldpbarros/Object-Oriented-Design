package interfaces;
import java.util.Map;
import services.Receiver;

public interface MsgSystemInterface {
    private void sendMsg(String msg, String noti_type, Receiver user) {}
    void receiveMsg(Map<String, Map<String, String>> receivers);
}
