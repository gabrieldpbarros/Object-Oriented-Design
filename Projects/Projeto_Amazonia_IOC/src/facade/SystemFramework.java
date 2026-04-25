package facade;
import interfaces.ObserverInterface;
import observers.GeneralObserver;
import subjects.Sensor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemFramework {
    private static SystemFramework instance; // padrão Singleton
    private Map<String, Sensor> sensorDict = new HashMap<>();
    private Map<String, ObserverInterface> observersDict = Map.of(
            "PORTO ALEGRE", null,
            "RIO DE JANEIRO", null,
            "SÃO JOSÉ DOS CAMPOS", null,
            "SÃO PAULO", null
    );

    private SystemFramework() {}
    public static SystemFramework getInstance() {
        if (instance == null)
            instance = new SystemFramework();
        return instance;
    }

    private ObserverInterface getObserverInstance(String observerName) {
        var observerInstance = observersDict.get(observerName);
        if (observerInstance != null)
            return observerInstance;
        else
            return new GeneralObserver(observerName);
    }

    public void createNewSensor(String sensorName) {
        var newSensor = new Sensor(0.0, 0.0, 0.0);
        newSensor.setName(sensorName);

        sensorDict.put(sensorName, newSensor);
    }

    public void createNewObserver(String observerName, List<String> sensorNames) {
        if (!observersDict.containsKey((observerName)))
            System.out.println("ERRO: Nome de instituição de pesquisa inválido: " + observerName);
        else {
            var newObserver = getObserverInstance(observerName);

            sensorNames.forEach((name) -> {
                var correspondingSensor = sensorDict.get(name);
                if (correspondingSensor != null)
                    correspondingSensor.addObserver(newObserver);
            });
        }
    }
}
