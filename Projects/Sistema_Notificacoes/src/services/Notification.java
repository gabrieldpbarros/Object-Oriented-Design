package services;
import adapters.UnifespAdapter;
import adapters.VivoAdapter;
import api.SMSUnifesp;
import api.SMSVivo;
import interfaces.NotiInterface;

public class Notification implements NotiInterface {
    private String msg;

    private void sendEmail(Receiver user) {
        /*
         * Implementação genérica de envio de email
         * */
        System.out.println("EMAIL");
        user.receiveNotification(this.msg);
    }

    private void sendSMS(Receiver user, String metadata) {
        /*
        * Implementação genérica de envio de SMS
        * */
        System.out.println("SMS");
        if (metadata.contains("VIVO")) {
            var provider_vivo = SMSVivo.getInstance();
            var adapter = new VivoAdapter(provider_vivo);
            adapter.sendMsg(user, this.msg);
        } else if (metadata.contains("UNIFESP")) {
            var provider_unifesp = SMSUnifesp.getInstance();
            var adapter = new UnifespAdapter((provider_unifesp));
            adapter.sendMsg(user, this.msg);
        } else user.receiveNotification(this.msg);
    }

    private void sendPush(Receiver user) {
        /*
         * Implementação genérica de envio de push notification
         * */
        System.out.println("PUSH NOTIFICATION");
        user.receiveNotification(this.msg);
    }

    public void processMsg(String msg, String noti_type, Receiver user) {
        this.msg = msg;

        if (noti_type.contains("Email")) {
            this.sendEmail(user);
        } else if (noti_type.contains("SMS")) {
            this.sendSMS(user, noti_type);
        } else if (noti_type.contains("Push")) {
            this.sendPush(user);
        } else {
            System.out.print("ERRO: Tipo de envio não suportado pelo sistema. Tente outra forma de notificação.");
        }
    }

    public String getMsg() {
        return this.msg;
    }
}