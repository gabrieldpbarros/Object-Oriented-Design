package server;
import interfaces.IEntity;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private static final String FILENAME = "../db/banco_pessoas.dat";
    private static Database instance;
    private Map<Integer, IEntity> entities;

    private Database() {
        this.entities = new HashMap<>();
        this.load();
    }

    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    private void load() {
        File file = new File(FILENAME);
        File dir = file.getParentFile();
        if (dir != null && !dir.exists())
            dir.mkdirs();
        if (!file.exists()) return;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILENAME))) {
            this.entities = (Map<Integer, IEntity>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading database.");
        }
    }

    public void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            out.writeObject(this.entities);
        } catch (IOException e) {
            System.err.println("Error saving database.");
        }
    }

    public void addEntity(IEntity entity) { this.entities.put(entity.getId(), entity); }
    public void removeEntity(int id) { this.entities.remove(id); }
    public Map<Integer, IEntity> getAllEntities() { return this.entities; }
    public IEntity getEntity(int id) { return this.entities.get(id); }
}
