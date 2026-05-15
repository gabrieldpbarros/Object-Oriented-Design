package colleagues;
import interfaces.IColleague;
import interfaces.IMediator;

public abstract class BaseColleague implements IColleague {
    protected IMediator mediator;
    protected String name;

    public BaseColleague(String name) {
        this.name = name;
    }

    public void setMediator(IMediator mediator) {
        this.mediator = mediator;
    }
    public String getName() { return this.name; }
}
