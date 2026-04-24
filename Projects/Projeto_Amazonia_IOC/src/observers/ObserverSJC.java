package observers;
import interfaces.ObserverInterface;
import interfaces.SubjectInterface;
import subjects.Sensor;

import java.util.HashMap;
import java.util.Map;

public class ObserverSJC implements ObserverInterface {
    private String name = "SÃO JOSÉ DOS CAMPOS";
    private Map<String, Double> lastTemps;
    private Map<String, Double> lastpHs;
    private Map<String, Double> lastHumidities;

    public ObserverSJC() {
        this.lastTemps = new HashMap<>();
        this.lastpHs = new HashMap<>();
        this.lastHumidities = new HashMap<>();
    }

    public void showLastUpdate() {
        System.out.println("ÚLTIMAS ATUALIZAÇÕES DO SENSOR " + this.name);

        System.out.println("--- TEMPERATURAS ---");
        this.lastTemps.forEach( (String key, Double value) -> {
            System.out.println(key + ": " + value);
        });

        System.out.println("--- PHs ---");
        this.lastpHs.forEach( (String key, Double value) -> {
            System.out.println(key + ": " + value);
        });

        System.out.println("--- UMIDADES RELATIVAS ---");
        this.lastHumidities.forEach( (String key, Double value) -> {
            System.out.println(key + ": " + value);
        });
    }

    public void update(SubjectInterface s) {
        String sensorName = ((Sensor) s).getName();

        this.lastTemps.put(sensorName, ((Sensor) s).geTemp());
        this.lastpHs.put(sensorName, ((Sensor) s).getpH());
        this.lastHumidities.put(sensorName, ((Sensor) s).getAirHumidity());

        showLastUpdate();
    }
}
