import observers.ObserverPoA;
import observers.ObserverRJ;
import observers.ObserverSJC;
import observers.ObserverSP;
import subjects.Sensor;

public class Main {
    public static void main(String[] args) {
        // SENSORES
        System.out.println("--- SENSORES ---");
        var negro = new Sensor(29.3, 6.9, 78.0);
        negro.setName("Rio Negro");
        System.out.println("SENSOR " + negro.getName());
        System.out.println("INSTÂNCIA " + negro);

        var solimoes = new Sensor(32.2, 7.2, 80.8);
        solimoes.setName("Rio Solimões");
        System.out.println("SENSOR " + solimoes.getName());
        System.out.println("INSTÂNCIA " + solimoes);

        var madeira = new Sensor(29.0, 6.7, 76.3);
        madeira.setName("Rio Madeira");
        System.out.println("SENSOR " + madeira.getName());
        System.out.println("INSTÂNCIA " + madeira);

        var jurua = new Sensor(30.0, 7.0, 92.1);
        jurua.setName("Rio Juruá");
        System.out.println("SENSOR " + jurua.getName());
        System.out.println("INSTÂNCIA " + jurua);

        var purus = new Sensor(28.1, 7.3, 76.3);
        purus.setName("Rio Purus");
        System.out.println("SENSOR " + purus.getName());
        System.out.println("INSTÂNCIA " + purus);

        // Observadores
        System.out.println("--- OBSERVADORES ---");

        var obsPoA = new ObserverPoA();
        System.out.println(obsPoA);
        negro.addObserver(obsPoA);
        solimoes.addObserver(obsPoA);
        purus.addObserver(obsPoA);

        var obsRJ = new ObserverRJ();
        System.out.println(obsRJ);
        solimoes.addObserver(obsRJ);
        madeira.addObserver(obsRJ);

        var obsSJC = new ObserverSJC();
        System.out.println(obsSJC);
        solimoes.addObserver(obsSJC);

        var obsSP = new ObserverSP();
        System.out.println(obsSP);
        negro.addObserver(obsSP);
        solimoes.addObserver(obsSP);
        jurua.addObserver(obsSP);

        // Atualizações
        System.out.println("--- ATUALIZAÇÕES ---");
        negro.setTemp(29.9); 
        solimoes.setpH(6.8);
        negro.setAirHumidity(79.3);
        purus.setpH(7.1);
        jurua.setTemp(29.0);
        purus.setAirHumidity(78.0);
    }
}
