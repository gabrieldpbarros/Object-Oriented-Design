package subjects;

public class Sensor extends Subject {
    private String name;
    private double temp;
    private double pH;
    private double airHumidity;

    public Sensor(double initialTemp, double initialpH, double initialAirHumidity) {
        this.temp = initialTemp;
        this.pH = initialpH;
        this.airHumidity = initialAirHumidity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public double geTemp() {
        return this.temp;
    }

    public void setTemp(double newTemp) {
        this.temp = newTemp;
        notifyObservers();
    }

    public double getpH() {
        return this.pH;
    }

    public void setpH(double newpH) {
        this.pH = newpH;
        notifyObservers();
    }

    public double getAirHumidity() {
        return this.airHumidity;
    }

    public void setAirHumidity(double newAirHumidity) {
        this.airHumidity = newAirHumidity;
        notifyObservers();
    }
}
