package commands;
import interfaces.Command;
import server.Arguments;
import server.Database;

public class DeleteCommand implements Command<Arguments, Void> {
    private Database database;

    public DeleteCommand(Database database) {
        this.database = database;
    }

    @Override
    public Void execute(Arguments args) {
        for (Object arg : args) {
            int id = (Integer)arg;
            this.database.removeEntity(id);
        }
        return null;
    }
}
