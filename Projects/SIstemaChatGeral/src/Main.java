import colleagues.BaseColleague;
import colleagues.User;
import mediator.Mediator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var user1 = new User("Banana");
        var user2 = new User("Arlindo");
        var user3 = new User("Ubuntu");
        var user4 = new User("Elon Musk");

        List<BaseColleague> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        var mediator = new Mediator(userList);

        user1.sendMessage("Fala gurizada");
        user3.sendMessage("Opa meus queridos");
        user4.sendMessage("AOBA");
        user1.sendMessage("Tirei 0 em SO galeris");
        user3.sendMessage("OTARIO, tirei 2");
    }
}
