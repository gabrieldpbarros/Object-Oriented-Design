package colleagues;

public class User extends BaseColleague {
    public User(String name) {
        super(name);
    }

    public void sendMessage(String msg) {
        this.mediator.messageOperation(msg, this);
    }

    public void recieveMessage(String msg) {
        System.out.println("NOVA MENSAGEM PARA " + this.getName() + ":");
        System.out.println(msg);
    }
}
