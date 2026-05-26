package builders;
import clients.Person;

public class PersonBuilder extends BaseBuilder {
    private String name;
    private String id;
    private Person person;

    public PersonBuilder() {}

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public void buildPart() {
        this.person = new Person(this.name, this.id);
    }

    public Person getResult() {
        return this.person;
    }
}
