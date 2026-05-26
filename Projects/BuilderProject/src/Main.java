import builders.EnterpriseBuilder;
import builders.PersonBuilder;

public class Main {
    public static void main(String[] args) {
        String name = "Clebinho";
        String id = "0126591110856";

        PersonBuilder pBuilder = new PersonBuilder()
                .setName(name)
                .setId(id);
        pBuilder.buildPart();
        var person = pBuilder.getResult();

        name = "Evenildo";
        id = "12345678980";
        String enterpriseName = "Gameplay Inc.";

        EnterpriseBuilder eBuilder = new EnterpriseBuilder()
                .setPersonName(name)
                .setPersonId(id)
                .setEntepriseName(enterpriseName);
        eBuilder.buildPart();
        var enterprise = eBuilder.getResult();
    }
}
