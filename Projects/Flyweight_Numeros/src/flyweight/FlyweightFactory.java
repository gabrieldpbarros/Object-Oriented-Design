package flyweight;
import interfaces.IFlyweight;
import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private static Map<String, IFlyweight> cache = new HashMap<>();

    public static IFlyweight getNumber(String repeatingState) {
        var result = cache.get(repeatingState);
        if (result == null) {
            result = new Number(repeatingState);
            cache.put(repeatingState, result);
        }

        return result;
    }
}
