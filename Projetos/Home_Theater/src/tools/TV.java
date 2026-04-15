package tools;
import interfaces.TVInterface;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TV implements TVInterface {
    private String[] inputs = { "HDMI_1", "HDMI_2", "ANTENA", "BLUETOOTH" };
    private String curr_input;
    private boolean on;

    public TV() {
        this.on = false;
        this.curr_input = inputs[0];
    }

    public void turnOn() {
        if (!on) System.out.println("Ligando TV.");
        else System.out.println("TV já está ligada.");

        this.on = true;
    }

    public void turnOff() {
        if (on) System.out.println("Desligando TV.");
        else System.out.println("TV já está ligada.");

        this.on = false;
    }

    public void changeInput() {
        int inputs_qt = this.inputs.length;

        System.out.println("Selecione o número da entrada:");
        for (int i = 0; i < inputs_qt; i++) {
            System.out.printf("%d - %s", i + 1, this.inputs[i]);
            if (this.inputs[i].equals(this.curr_input))
                System.out.print(" (ATUAL)");
            System.out.printf("%n");
        }

        int new_input = 0;
        boolean entrada_invalida = true;
        Scanner scan = new Scanner(System.in);

        while (entrada_invalida) {
            try {
                new_input = scan.nextInt();
                if (new_input < 1 || new_input > inputs_qt)
                    System.out.println("Insira uma entrada dentro do limite.");
                else
                    entrada_invalida = false;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite apenas números.");
                scan.next();
            }
        }

        this.curr_input = this.inputs[new_input - 1];
    }
}
