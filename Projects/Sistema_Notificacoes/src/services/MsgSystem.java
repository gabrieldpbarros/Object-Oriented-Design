package services;
import factories.NotiFactory;
import interfaces.MsgSystemInterface;
import java.util.Map;

public class MsgSystem implements MsgSystemInterface  {
    private static MsgSystem instance;
    private String sys_name = "UNIFESP_NOTIFICATIONS";
    private String sys_server = "email do professor";

    private MsgSystem() {} // padrão Singleton

    public static MsgSystem getInstance() { // impede novas instâncias desnecessárias
        if (instance == null)
            instance = new MsgSystem();
        return instance;
    }

    private void sendMsg(String msg, String noti_type, Receiver user) {
        var notification = NotiFactory.create();
        notification.processMsg(msg, noti_type, user);
    }

    public void receiveMsg(Map<String, Map<String, String>> receivers) {
        receivers.forEach((user_name, info_dict) -> {
            var user = new Receiver(user_name);

            info_dict.forEach((noti_type, msg) -> {
                this.sendMsg(msg, noti_type, user);
            });
        });
    }
}
