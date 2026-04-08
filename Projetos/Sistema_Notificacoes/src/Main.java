import services.MsgSystem;

public class Main {
    public static void main(String[] args) {
        var msg_system = MsgSystem.getInstance();
        String[] users = { "notificacao email:", "notificacao SMS:", "notificacao push:" };
        String msg = "tomou na jabiroca";
        msg_system.recieveMsg(msg, users);
    }
}