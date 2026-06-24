package commands;
import interfaces.Command;
import interfaces.IEntity;
import server.Arguments;
import server.Database;

import java.util.Map;

public class AllCommand implements Command<Arguments, Map<Integer, IEntity>> {
    private Database database;

    public AllCommand(Database database) {
        this.database = database;
    }

    @Override
    public Map<Integer, IEntity> execute(Arguments args) {
        if (args.size() > 0)
            throw new IllegalArgumentException("Too much arguments. Usage: all");
        return this.database.getAllEntities();
    }
}
