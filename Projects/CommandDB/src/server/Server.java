package server;
import commands.AllCommand;
import commands.DeleteCommand;
import commands.GetCommand;
import commands.NewCommand;
import interfaces.Command;
import interfaces.IEntity;
import interfaces.IServer;
import java.util.HashMap;
import java.util.Map;

public class Server implements IServer {
    private Database database;
    private Map<String, Command> commands;

    public Server() {
        initServer();
        initCommands();
    }

    private void initServer() { this.database = Database.getInstance(); }
    private void initCommands() {
        this.commands = new HashMap<>();
        this.commands.put("new", new NewCommand(this.database));
        this.commands.put("delete", new DeleteCommand(this.database));
        this.commands.put("all", new AllCommand(this.database));
        this.commands.put("get", new GetCommand(this.database));
    }

    public void save() { this.database.save(); }

    @Override
    public Object service(String cmd, Arguments args) {
        Command command = commands.get(cmd);
        if (command == null)
            return "Command not found";
        return command.execute(args);
    }
}
