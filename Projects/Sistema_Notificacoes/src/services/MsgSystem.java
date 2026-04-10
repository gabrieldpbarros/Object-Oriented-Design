package services;
import factories.NotiFactory;
import java.util.Map;

public class MsgSystem {
    private static MsgSystem instance;
    private String sys_name = "UNIFESP_NOTIFICATIONS";
    private String sys_server = "email do professor";
    private int max_attempts = 3;

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

    public void recieveMsg(Map<String, Map<String, String>> receivers) {
        receivers.forEach((user_name, info_dict) -> {
            var user = Receiver.getInstance(user_name);
            System.out.println(user);
            info_dict.forEach((noti_type, msg) -> {
                this.sendMsg(msg, noti_type, user);
            });
        });
    }
}
