package services;
import factories.NotiFactory;

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

    private void sendMsg(String msg, Receiver user) {
        var notification = NotiFactory.create();
        notification.processMsg(msg);

        user.showNotification(notification.getMsg());
    }

    public void recieveMsg(String msg, String[] receivers) {
        for (String receiver : receivers) {
            var user = new Receiver(receiver);
            this.sendMsg(msg, user);
        }
    }
}
