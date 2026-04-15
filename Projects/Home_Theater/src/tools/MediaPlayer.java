package tools;
import interfaces.MediaPlayerInterface;

public class MediaPlayer implements MediaPlayerInterface {
    private boolean on;
    private boolean playing;

    public MediaPlayer() {
        this.on = false;
        this.playing = false;
    }

    public void turnOn() {
        if (!on) System.out.println("Ligando multimídia.");
        else System.out.println("Multimídia já está ligado.");

        this.on = true;
    }

    public void turnOff() {
        if (on) System.out.println("Desligando multimídia.");
        else System.out.println("Multimídia já está desligado.");

        this.on = false;
    }

    public void play() {
        if (!playing) System.out.println("Começando mídia.");
        else System.out.println("Mídia já está tocando.");

        this.playing = true;
    }

    public void pause() {
        if (!playing) System.out.println("Pausando mídia.");
        else System.out.println("Mídia já está pausada.");

        this.playing = false;
    }
}
