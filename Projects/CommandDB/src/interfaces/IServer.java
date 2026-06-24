package interfaces;
import server.Arguments;

public interface IServer {
    Object service(String cmd, Arguments args);
}
