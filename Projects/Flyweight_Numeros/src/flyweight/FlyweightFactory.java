package flyweight;
import java.util.HashMap;
import java.util.Map;

public class NumberFactory {
    private static Map<String, Number> cache = new HashMap<>();

    public static Number getFlyweight(String repeatingState) {
        Number result = cache.get(repeatingState);
        if (result == null) {
            result = new Number(repeatingState);
            cache.put(repeatingState, result);
        }

        return result;
    }
}
