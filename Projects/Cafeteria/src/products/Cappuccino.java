package products;
import interfaces.ProductInterface;

public class Cappuccino implements ProductInterface {
    private double basePrice = 10.0;
    private String description = "Cappuccino";

    public double returnPrice() {
        return this.basePrice;
    }

    public String getDescription() {
        return this.description;
    }
}
