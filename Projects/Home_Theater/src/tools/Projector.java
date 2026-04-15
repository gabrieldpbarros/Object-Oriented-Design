package tools;
import interfaces.ProjectorInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Projector implements ProjectorInterface {
    private String[] inputs = { "HDMI_1", "HDMI_2", "USB_C" };
    private String curr_input;
    private boolean on;
    private boolean bt;
    private boolean resize;

    public Projector() {
        this.on = false;
        this.bt = false;
        this.resize = false;
        this.curr_input = inputs[0];
    }

    public void turnOn() {
        if (!on) System.out.println("Ligando projetor.");
        else System.out.println("Projetor já está ligado.");

        this.on = true;
    }

    public void turnOff() {
        if (on) System.out.println("Desligando projetor.");
        else System.out.println("Projetor já está desligado.");

        this.on = false;
    }

    public void changeInput() {
        int inputs_qt = this.inputs.length;

        System.out.println("Selecione o número da entrada:");
        for (int i = 0; i < inputs_qt; i++) {
            System.out.printf("%d - %s", i, this.inputs[i]);
            if (this.inputs[i].equals(this.curr_input))
                System.out.print(" (ATUAL)");
            System.out.print("%n");
        }

        int new_input = 0;
        boolean entrada_invalida = true;
        Scanner scan = new Scanner(System.in);

        while (entrada_invalida) {
            try {
                new_input = scan.nextInt();
                if (new_input < 0 || new_input >= inputs_qt)
                    System.out.println("Insira uma entrada dentro do limite.");
                else
                    entrada_invalida = false;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite apenas números.");
                scan.next();
            }
        }

        this.curr_input = this.inputs[new_input];
    }

    public void connectBT() {
        if (!bt) System.out.println("Conectando bluetooth.");
        else System.out.println("Bluetooth já está conectado.");

        this.bt = true;
    }

    public void disconnectBT() {
        if (bt) System.out.println("Desconectando bluetooth.");
        else System.out.println("Bluetooth já está desconectado.");

        this.bt = false;
    }

    public void resizingMode() {
        if (!this.resize) {
            System.out.println("Entrando no modo de redimensionamento.");
            this.resize = true;
        } else {
            System.out.println("Saindo do modo de redimensionamento.");
            this.resize = false;
        }
    }
}