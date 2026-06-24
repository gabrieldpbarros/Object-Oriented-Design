package commands;
import interfaces.Command;
import interfaces.IEntity;
import server.Arguments;
import server.Database;

public class GetCommand implements Command<Arguments, IEntity> {
    private Database database;

    public GetCommand(Database database) {
        this.database = database;
    }

    @Override
    public IEntity execute(Arguments args) {
        if (args.size() != 1)
            throw new IllegalArgumentException("Wrong amount of arguments. Usage: get <id>");
        int id = args.getArg(0);
        return this.database.getEntity(id);
    }
}
