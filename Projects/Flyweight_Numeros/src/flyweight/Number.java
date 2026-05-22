package flyweight;
import interfaces.IFlyweight;

public class Number implements IFlyweight {
    private String repeatingState;

    public Number(String repeatingState) {
        this.repeatingState = repeatingState;
    }

    @Override
    public void operation(String uniqueState) {

    }
}
