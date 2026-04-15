package proxy;
import factories.NotiFactory;
import interfaces.MsgSystemInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import services.Receiver;

public class MsgSystemProxy implements MsgSystemInterface {
    private MsgSystemInterface base;
    private String sys_name = "UNIFESP_NOTIFICATIONS";
    private String sys_server = "email do professor";
    private int max_attempts = 3;

    public MsgSystemProxy (MsgSystemInterface base) { this.base = base; }

    private void sendMsg(String msg, String noti_type, Receiver user) {
        var notification = NotiFactory.create();
        notification.processMsg(msg, noti_type, user);
    }

    public void receiveMsg(Map<String, Map<String, String>> receivers) {
        System.out.println("Carregando proxy...");

        List<String> usuarios_processados = new ArrayList<>();

        receivers.forEach((String user_name, Map<String, String> info_dict) -> {
            info_dict.forEach((noti_type, msg) -> {
                boolean found = false;

                for (int i = 0; i < this.max_attempts; i++) {
                    System.out.printf("Pesquisando no proxy... (tentativa %d)%n", i+1);

                    if (user_name.contains("Mariana")) {
                        System.out.println("Usuário já carregado no proxy. Enviando mensagem...");

                        var user = new Receiver(user_name);
                        this.sendMsg(msg, noti_type, user);

                        usuarios_processados.add(user_name);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.printf("Usuário %s não encontrado.%n", user_name);
                }
            });
        });

        usuarios_processados.forEach(receivers::remove);

        if (!receivers.isEmpty()) {
            System.out.println("Alguns usuários não foram encontrados no proxy. Enviando para objeto base....");
            base.receiveMsg(receivers);
        }
    }
}
