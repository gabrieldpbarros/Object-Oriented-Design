import facades.SystemFramework;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Framework
        var sysFramework = SystemFramework.getInstance();

        sysFramework.createNewSensor("Rio Negro");
        sysFramework.createNewSensor("Rio Solimões");
        sysFramework.createNewSensor("Rio Madeira");
        sysFramework.createNewSensor("Rio Juruá");
        sysFramework.createNewSensor("Rio Purus");

        sysFramework.insertObserver("PORTO ALEGRE", List.of("Rio Negro", "Rio Solimões", "Rio Purus"));
        sysFramework.insertObserver("RIO DE JANEIRO", List.of("Rio Solimões", "Rio Madeira"));
        sysFramework.insertObserver("SÃO JOSÉ DOS CAMPOS", List.of("Rio Solimões"));
        sysFramework.insertObserver("SÃO PAULO", List.of("Rio Negro", "Rio Solimões", "Rio Juruá"));

        sysFramework.generateRandomUpdate();
        sysFramework.generateRandomUpdate();
        sysFramework.generateRandomUpdate();
        sysFramework.generateRandomUpdate();
        sysFramework.generateRandomUpdate();
        sysFramework.generateRandomUpdate();
        sysFramework.generateRandomUpdate();
        sysFramework.generateRandomUpdate();
        sysFramework.generateRandomUpdate();

        sysFramework.showLastUpdates("PORTO ALEGRE");
        sysFramework.showLastUpdates("RIO DE JANEIRO");
        sysFramework.showLastUpdates("SÃO JOSÉ DOS CAMPOS");
        sysFramework.showLastUpdates("SÃO PAULO");
    }
}
