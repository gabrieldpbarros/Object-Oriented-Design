package tools;
import interfaces.*;

public class Receiver implements ReceiverInterface {
    public void sendVideo(String target,
                          MediaPlayerInterface media_player,
                          ProjectorInterface projector,
                          TVInterface tv) {
        switch (target) {
            case "Multimidia":
                media_player.turnOn();
                media_player.play();
                break;
            case "Projetor":
                projector.turnOn();
                break;
            case "TV":
                tv.turnOn();
                break;
        }
    }

    public void sendAudio(String target,
                          MediaPlayerInterface media_player,
                          SoundSystemInterface sound_system,
                          TVInterface tv) {
        switch (target) {
            case "Multimidia":
                media_player.turnOn();
                media_player.play();
                break;
            case "Sistema de som":
                sound_system.turnOn();
                break;
            case "TV":
                tv.turnOn();
                break;
        }
    }
}
