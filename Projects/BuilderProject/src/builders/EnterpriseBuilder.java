package builders;
import clients.Enterprise;
import clients.Person;

public class EnterpriseBuilder extends BaseBuilder {
    private String personName;
    private String personId;
    private String entepriseName;
    private Person owner;
    private Enterprise enterprise;

    public EnterpriseBuilder() {}

    public EnterpriseBuilder setPersonName(String personName) {
        this.personName = personName;
        return this;
    }

    public EnterpriseBuilder setPersonId(String personId) {
        this.personId = personId;
        return this;
    }

    public EnterpriseBuilder setEntepriseName(String entepriseName) {
        this.entepriseName = entepriseName;
        return this;
    }

    public EnterpriseBuilder setOwner(Person owner) {
        this.owner = owner;
        return this;
    }

    @Override
    public void buildPart() {
        this.enterprise = new Enterprise(this.entepriseName, this.owner);
    }

    public Enterprise getResult() {
        return this.enterprise;
    }
}
