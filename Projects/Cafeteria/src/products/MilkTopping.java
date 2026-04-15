package products;
import decorators.ProductDecorator;
import interfaces.ProductInterface;

public class MilkTopping extends ProductDecorator {
    protected double basePrice = 2.5;
    protected String description = " + Leite";

    public MilkTopping(ProductInterface base) {
        super(base);
    }

    public double returnPrice() {
        return super.returnPrice() + this.basePrice;
    }

    public String getDescription() {
        return super.getDescription() + this.description;
    }
}
