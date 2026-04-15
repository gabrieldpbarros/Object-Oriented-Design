package products;
import interfaces.ProductInterface;

public class Espresso implements ProductInterface {
    private double basePrice = 5.0;
    private String description = "Café expresso";

    public double returnPrice() {
        return this.basePrice;
    }

    public String getDescription() {
        return this.description;
    }
}
