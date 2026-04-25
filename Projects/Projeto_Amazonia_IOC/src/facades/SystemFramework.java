package facades;
import interfaces.ObserverInterface;
import observers.GeneralObserver;
import subjects.Sensor;
import java.util.*;

public class SystemFramework {
    private static SystemFramework instance; // padrão Singleton
    private Map<String, Sensor> sensorDict = new HashMap<>();
    private Map<String, ObserverInterface> observersDict = new HashMap<>();

    private SystemFramework() {
        observersDict.put("PORTO ALEGRE", null);
        observersDict.put("RIO DE JANEIRO", null);
        observersDict.put("SÃO JOSÉ DOS CAMPOS", null);
        observersDict.put("SÃO PAULO", null);
    }

    public static SystemFramework getInstance() {
        if (instance == null)
            instance = new SystemFramework();
        return instance;
    }

    private ObserverInterface getObserverInstance(String observerName) {
        var observerInstance = observersDict.get(observerName);

        if (observerInstance == null) {
            observerInstance = new GeneralObserver(observerName);
            observersDict.put(observerName, observerInstance);
        }
        return observerInstance;
    }

    public void createNewSensor(String sensorName) {
        var newSensor = new Sensor(0.0, 0.0, 0.0);
        newSensor.setName(sensorName);

        this.sensorDict.put(sensorName, newSensor);
    }

    public void insertObserver(String observerName, List<String> sensorNames) {
        if (sensorNames == null) return;

        if (!observersDict.containsKey((observerName)))
            System.out.println("ERRO: Nome de instituição de pesquisa inválido: " + observerName);
        else {
            var newObserver = getObserverInstance(observerName);

            sensorNames.forEach((name) -> {
                var correspondingSensor = this.sensorDict.get(name);
                if (correspondingSensor != null)
                    correspondingSensor.addObserver(newObserver);
            });
        }
    }

    public void showLastUpdates(String observerName) {
        if (!observersDict.containsKey((observerName)))
            System.out.println("ERRO: Nome de instituição de pesquisa não cadastrado: " + observerName);
        else {
            var observer = getObserverInstance(observerName);
            observer.showLastUpdate();
        }
    }

    public void generateRandomUpdate() {
        if (this.sensorDict.isEmpty()) {
            System.out.println("Nenhum sensor cadastrado para gerar atualizações.");
            return;
        }

        Random r = new Random();
        double randTemp = 25.0 + (40.0 - 25.0) * r.nextDouble();
        double randpH = 6.0 + (8.0 - 6.0) * r.nextDouble();
        double randHumidity = 50.0 + (100.0 - 50.0) * r.nextDouble();

        // Seleciona um sensor aleatorio
        List<String> keys = new ArrayList<>(this.sensorDict.keySet());
        int randIndex = r.nextInt(keys.size());
        String selectedKey = keys.get(randIndex);
        var selectedSensor = this.sensorDict.get(selectedKey);

        selectedSensor.setTemp(randTemp);
        selectedSensor.setpH(randpH);
        selectedSensor.setAirHumidity(randHumidity);
    }
}
