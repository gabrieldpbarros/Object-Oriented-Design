import java.util.HashMap;
import java.util.Map;
import proxy.MsgSystemProxy;
import services.MsgSystem;


public class Main {
    public static void main(String[] args) {
        MsgSystem msg_system = MsgSystem.getInstance();
        MsgSystemProxy msg_system_proxy = new MsgSystemProxy(msg_system);
        Map<String, Map<String, String>> users = new HashMap<>();

        users.put("Clebinho", Map.of("Email", "Bom dia, Clebinho!"));
        users.put("Joana", Map.of("SMS VIVO", "Aproveite a nova promoção da VIVO, Joana!"));
        users.put("Pedrinho", Map.of("SMS", "Desconto especial do IFood só pra você, Pedrinho!"));
        users.put("Agostinho", Map.of("Push", "Alerta de tempestade em São José dos Campos"));
        users.put("Mariana", Map.of("SMS UNIFESP", "Lembrete de envio de AC."));

        msg_system_proxy.receiveMsg(users);
    }
}