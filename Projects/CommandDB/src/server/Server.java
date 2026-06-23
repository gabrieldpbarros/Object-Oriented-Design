package server;
import interfaces.Command;
import interfaces.IEntity;
import interfaces.IServer;
import java.util.Map;

public class Server implements IServer {
    private Database database;
    private Map<String, Command> commands;

    public Server() {

    }

    public void initServer() {

    }

    @Override
    public void service(String cmd, IEntity entity) {
        Command command = (Command) commands.get(cmd);
    }
}
