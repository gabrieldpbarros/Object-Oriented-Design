package interfaces;

import services.Receiver;

public interface NotiInterface {
    private void sendEmail(Receiver user) {};
    private void sendSMS(Receiver user, String metadata) {};
    private void sendPush(Receiver user) {};
    void processMsg(String msg, String noti_type, Receiver user);
    String getMsg();
}
