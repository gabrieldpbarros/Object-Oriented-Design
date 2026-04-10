import java.util.HashMap;
import java.util.Map;
import services.MsgSystem;

public class Main {
    public static void main(String[] args) {
        var msg_system = MsgSystem.getInstance();
        Map<String, Map<String, String>> users = new HashMap<>();
        Map<String, String> user_details = new HashMap<>();

        user_details.put("Email", "Bom dia, Clebinho!");
        users.put("Clebinho", user_details);
        user_details.clear();

        user_details.put("SMS VIVO", "Aproveite a nova promoção da VIVO, Joana!");
        users.put("Joana", user_details);
        user_details.clear();

        user_details.put("SMS", "Desconto especial do IFood só pra você, Pedrinho!");
        users.put("Pedrinho", user_details);
        user_details.clear();

        user_details.put("Push", "Alerta de tempestade em São José dos Campos");
        users.put("Agostinho", user_details);
        user_details.clear();

        msg_system.recieveMsg(users);
    }
}