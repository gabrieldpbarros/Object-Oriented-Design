package api;
import services.Receiver;

public class SMSUnifesp {
    private static SMSUnifesp instance;

    private SMSUnifesp() {}

    public static SMSUnifesp getInstance() { // impede novas instâncias desnecessárias
        if (instance == null)
            instance = new SMSUnifesp();
        return instance;
    }

    public void mandaMsg(Receiver user, String msg) {
        System.out.println("SISTEMA UNIFESP");
        System.out.println("ERRO: SEM CONEXÃO");
        user.receiveNotification(msg);
    }
}
