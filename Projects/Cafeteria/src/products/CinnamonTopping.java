package products;
import decorators.ProductDecorator;
import interfaces.ProductInterface;

public class CinnamonTopping extends ProductDecorator {
    protected double basePrice = 3.5;
    protected String description = " + Canela";

    public CinnamonTopping(ProductInterface base) {
        super(base);
    }

    public double returnPrice() {
        return super.returnPrice() + this.basePrice;
    }

    public String getDescription() {
        return super.getDescription() + this.description;
    }
}
