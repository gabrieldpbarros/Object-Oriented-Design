package adapters;
import api.SMSVivo;
import interfaces.SMSAdapter;
import services.Receiver;

public class VivoAdapter implements SMSAdapter {
    private SMSVivo provedora;

    public VivoAdapter (SMSVivo provedora) {
        this.provedora = provedora;
    }

    public void sendMsg(Receiver user, String msg) {
        /*
        * Supondo um serviço que utilize o nome do usuário para buscar na chamada de API
        * */
        this.provedora.enviaMsg(user, msg);
    }
}
