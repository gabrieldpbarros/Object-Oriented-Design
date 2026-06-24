package server;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Arguments implements Iterable<Object> {
    private List<Object> args = new ArrayList<>();

    public Arguments(Object... args) {
        this.args.addAll(Arrays.asList(args));
    }

    public <T> T getArg(int index) { return (T) args.get(index); }
    public int size() { return args.size(); }

    @Override
    public Iterator<Object> iterator() {
        return args.iterator();
    }
}
