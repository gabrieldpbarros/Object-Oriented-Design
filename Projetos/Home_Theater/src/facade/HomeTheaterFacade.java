package facade;
import interfaces.*;

public class HomeTheaterFacade implements HomeTheaterInterface {
    public AmbientLightInterface ambient_light;
    public MediaPlayerInterface media_player;
    public ProjectorInterface projector;
    public ReceiverInterface receiver;
    public SoundSystemInterface sound_system;
    public TVInterface tv;

    public HomeTheaterFacade(AmbientLightInterface ambient_light,
                             MediaPlayerInterface media_player,
                             ProjectorInterface projector,
                             ReceiverInterface receiver,
                             SoundSystemInterface sound_system,
                             TVInterface tv) {
        this.ambient_light = ambient_light;
        this.media_player = media_player;
        this.projector = projector;
        this.receiver = receiver;
        this.sound_system = sound_system;
        this.tv = tv;
    }

    public void assistirFilme() {
        this.ambient_light.turnOff();
        this.receiver.sendVideo("Projetor", this.media_player, this.projector, this.tv);
        this.receiver.sendAudio("Sistema de som", this.media_player, this.sound_system, this.tv);
    }

    public void ouvirMusica() {
        this.ambient_light.turnOn();
        this.receiver.sendVideo("Multimidia", this.media_player, this.projector, this.tv);
        this.receiver.sendAudio("Sistema de som", this.media_player, this.sound_system, this.tv);
    }
}
