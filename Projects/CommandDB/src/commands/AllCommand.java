package commands;
import interfaces.Command;
import interfaces.IEntity;
import server.Arguments;
import server.Database;

import java.util.Map;

public class AllCommand implements Command<Void, Map<Integer, IEntity>> {
    private Database database;

    public AllCommand(Database database) {
        this.database = database;
    }

    @Override
    public Map<Integer, IEntity> execute(Void args) {
        return this.database.getAllEntities();
    }
}
