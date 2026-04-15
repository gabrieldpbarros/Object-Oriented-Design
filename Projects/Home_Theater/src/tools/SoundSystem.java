package tools;
import interfaces.SoundSystemInterface;

public class SoundSystem implements SoundSystemInterface {
    private String[] modes = { "graves", "pop", "rock", "jazz", "custom" };
    private String curr_mode;
    private int curr_mode_index;
    private boolean on;

    public SoundSystem() {
        this.on = false;
        this.curr_mode = modes[0];
        this.curr_mode_index = 0;
    }

    public void turnOn() {
        if (!on) System.out.println("Ligando sistema de som.");
        else System.out.println("Sistema de som já está ligado.");

        this.on = true;
    }

    public void turnOff() {
        if (on) System.out.println("Desligando sistema de som.");
        else System.out.println("Sistema de som já está desligado.");

        this.on = false;
    }

    public void equalize() {
        // Trocamos para a equalização "custom"
        this.curr_mode_index = modes.length - 1;
        this.updateMode();
        System.out.println("Entrando no modo equalização de som.");
    }

    public void cycleSoundMode() {
        int max_modes = modes.length;
        if (this.curr_mode_index == max_modes - 1) curr_mode_index = 0;
        else curr_mode_index++;

        this.updateMode();
    }

    private void updateMode() {
        this.curr_mode = this.modes[this.curr_mode_index];
        System.out.printf("Alterando modo de som para %s%n", this.curr_mode);
    }
}