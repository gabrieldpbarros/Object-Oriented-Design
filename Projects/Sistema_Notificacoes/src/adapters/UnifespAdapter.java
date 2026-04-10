package adapters;
import api.SMSUnifesp;
import interfaces.SMSAdapter;
import services.Receiver;

public class UnifespAdapter implements SMSAdapter {
    private SMSUnifesp provider;

    public UnifespAdapter(SMSUnifesp provider) { this.provider = provider; }

    public void sendMsg(Receiver user, String msg) {
        /*
         * Supondo um serviço que utilize o nome do usuário para buscar na chamada de API
         * */
        this.provider.mandaMsg(user, msg);
    }
}
