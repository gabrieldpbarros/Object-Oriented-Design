package products;
import interfaces.ProductInterface;

public class Tea implements ProductInterface {
    private double basePrice = 8.0;
    private String description = "Chá";

    public double returnPrice() {
        return this.basePrice;
    }

    public String getDescription() {
        return this.description;
    }
}
