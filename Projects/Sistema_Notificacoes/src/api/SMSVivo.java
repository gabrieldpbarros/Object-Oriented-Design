package api;
import services.Receiver;

public class SMSVivo {
    private static SMSVivo instance;

    private SMSVivo() {}

    public static SMSVivo getInstance() { // impede novas instâncias desnecessárias
        if (instance == null)
            instance = new SMSVivo();
        return instance;
    }

    public void enviaMsg(Receiver user, String msg) {
        System.out.println("SISTEMA VIVO");
        user.receiveNotification(msg);
    }
}
