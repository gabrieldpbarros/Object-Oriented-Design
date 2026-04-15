package products;
import decorators.ProductDecorator;
import interfaces.ProductInterface;

public class ChocolateTopping extends ProductDecorator {
    protected double basePrice = 4.0;
    protected String description = " + Chocolate";

    public ChocolateTopping(ProductInterface base) {
        super(base);
    }

    public double returnPrice() {
        return super.returnPrice() + this.basePrice;
    }

    public String getDescription() {
        return super.getDescription() + this.description;
    }
}
