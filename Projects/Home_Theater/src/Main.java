import facade.HomeTheaterFacade;
import tools.*;

public class Main {
    public static void main(String[] args) {
        // Fachada
        HomeTheaterFacade home_theater = new HomeTheaterFacade(new AmbientLight(),
                                                                  new MediaPlayer(),
                                                                  new Projector(),
                                                                  new Receiver(),
                                                                  new SoundSystem(),
                                                                  new TV());
        // Teste de instâncias
        System.out.println("INSTANCIAS");
        System.out.println(home_theater.ambient_light);
        System.out.println(home_theater.media_player);
        System.out.println(home_theater.projector);
        System.out.println(home_theater.receiver);
        System.out.println(home_theater.sound_system);
        System.out.println(home_theater.tv);

        // Teste da fachada
        System.out.println("OPERACOES FACHADA");
        System.out.println("|Assistir filme|");
        home_theater.assistirFilme();
        System.out.println("|Ouvir musica|");
        home_theater.ouvirMusica();

        // Teste de controle
        System.out.println("OPERACOES SUBSISTEMAS");
        home_theater.ambient_light.turnOn();
        home_theater.sound_system.cycleSoundMode();
        home_theater.tv.changeInput();
        home_theater.tv.changeInput();
    }
}