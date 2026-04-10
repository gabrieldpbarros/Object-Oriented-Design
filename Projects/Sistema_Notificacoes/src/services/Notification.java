package services;
import adapters.VivoAdapter;
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
            var provedora_vivo = SMSVivo.getInstance();
            var adaptador = new VivoAdapter(provedora_vivo);
            adaptador.sendMsg(user, this.msg);
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