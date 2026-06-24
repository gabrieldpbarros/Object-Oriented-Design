package commands;
import entities.Person;
import interfaces.Command;
import server.Arguments;
import server.Database;

public class NewCommand implements Command<Arguments, Void> {
    private Database database;

    public NewCommand(Database database) {
        this.database = database;
    }

    @Override
    public Void execute(Arguments args) {
        int id = args.getArg(0);
        String name = args.getArg(1);
        this.database.addEntity(new Person(id, name));
        return null;
    }
}
