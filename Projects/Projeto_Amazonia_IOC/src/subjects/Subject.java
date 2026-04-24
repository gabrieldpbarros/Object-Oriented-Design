package subjects;
import interfaces.ObserverInterface;
import interfaces.SubjectInterface;
import java.util.ArrayList;
import java.util.List;


public class Subject implements SubjectInterface {
    private List<ObserverInterface> observers = new ArrayList<ObserverInterface>();

    public void addObserver(ObserverInterface observer) {
        observers.add(observer);
    }

    public void removeObserver(ObserverInterface observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (ObserverInterface obs : observers) {
            obs.update(this);
        }
    }

}
