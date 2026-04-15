package decorators;
import interfaces.ProductInterface;

public class ProductDecorator implements ProductInterface {
    protected ProductInterface product;

    public ProductDecorator(ProductInterface base) {
        this.product = base;
    }

    public double returnPrice() {
        return product.returnPrice();
    }

    public String getDescription() {
        return product.getDescription();
    }
}
