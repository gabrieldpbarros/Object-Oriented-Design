package entities;
import interfaces.IEntity;

public class Person implements IEntity {
    private int id;
    private String name;

    @Override
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
}
