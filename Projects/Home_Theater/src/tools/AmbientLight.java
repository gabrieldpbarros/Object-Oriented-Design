package tools;
import interfaces.AmbientLightInterface;

public class AmbientLight implements AmbientLightInterface {
    private String[] modes = { "mode1", "mode2", "mode3" };
    private String curr_mode;
    private int curr_mode_index;
    private boolean on;

    public AmbientLight() {
        this.on = false;
        this.curr_mode = modes[0];
        this.curr_mode_index = 0;
    }

    public void turnOn() {
        if (!on) System.out.println("Ligando luz ambiente.");
        else System.out.println("Luz ambiente já está ligada.");

        this.on = true;
    }

    public void turnOff() {
        if (on) System.out.println("Desligando luz ambiente.");
        else System.out.println("Luz ambiente já está desligada.");

        this.on = false;
    }

    public void enterCustomMode() { System.out.println("Customizando aparência da luz ambiente."); }

    public void cycleLightMode() {
        int max_modes = modes.length;
        if (this.curr_mode_index == max_modes - 1) curr_mode_index = 0;
        else curr_mode_index++;

        this.updateMode();
    }

    private void updateMode() { this.curr_mode = this.modes[this.curr_mode_index]; }
}