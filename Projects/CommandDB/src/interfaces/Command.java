package interfaces;

public interface Command<T, R> {
    R execute (T arg);
}
