package interfaces;

public interface ReceiverInterface {
    void sendVideo(String target,
                   MediaPlayerInterface media_player_interface,
                   ProjectorInterface projector_interface,
                   TVInterface tv_interface);
    void sendAudio(String target,
                   MediaPlayerInterface media_player_interface,
                   SoundSystemInterface sound_system_interface,
                   TVInterface tv_interface);
}
