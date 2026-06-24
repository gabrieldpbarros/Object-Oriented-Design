package server;
import interfaces.IEntity;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private static Database instance;
    private Map<Integer, IEntity> entities;

    private Database() {
        this.entities = new HashMap<>();
    }

    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    public void addEntity(IEntity entity) { this.entities.put(entity.getId(), entity); }
    public void removeEntity(int id) { this.entities.remove(id); }
    public Map<Integer, IEntity> getAllEntities() { return this.entities; }
    public IEntity getEntity(int id) { return this.entities.get(id); }
}
