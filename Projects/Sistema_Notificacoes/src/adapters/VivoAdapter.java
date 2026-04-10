package adapters;
import api.SMSVivo;
import interfaces.SMSAdapter;
import services.Receiver;

public class VivoAdapter implements SMSAdapter {
    private SMSVivo provider;

    public VivoAdapter(SMSVivo provider) { this.provider = provider; }

    public void sendMsg(Receiver user, String msg) {
        /*
        * Supondo um serviço que utilize o nome do usuário para buscar na chamada de API
        * */
        this.provider.enviaMsg(user, msg);
    }
}
