package products;
import decorators.ProductDecorator;
import interfaces.ProductInterface;

public class ChantillyTopping extends ProductDecorator {
    protected double basePrice = 3.0;
    protected String description = " + Chantilly";

    public ChantillyTopping(ProductInterface base) {
        super(base);
    }

    public double returnPrice() {
        return super.returnPrice() + this.basePrice;
    }

    public String getDescription() {
        return super.getDescription() + this.description;
    }
}
