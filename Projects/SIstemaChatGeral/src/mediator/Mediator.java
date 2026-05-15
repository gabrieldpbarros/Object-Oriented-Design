package mediator;
import colleagues.BaseColleague;
import interfaces.IMediator;
import java.util.List;

public class Mediator implements IMediator {
    private List<BaseColleague> users;

    public Mediator(List<BaseColleague> users) {
        this.users = users;

        for (BaseColleague user : users)
            user.setMediator(this);
    }

    public void addUser(BaseColleague user) {
        this.users.add(user);
    }

    public boolean removeUser(String name) {
        boolean exists = false;
        for (BaseColleague user : users) {
            if (user.getName().equals(name)) {
                users.remove(user);
                exists = true;
            }
        }
        return exists;
    }

    @Override
    public void messageOperation(String msg, BaseColleague sender) {
        for (BaseColleague user : users)
            if (user != sender)
                user.recieveMessage(msg);
    }
}
