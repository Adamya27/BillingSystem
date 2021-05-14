package Models;

public class Product {
    private String name;
    private double basePrice;
    private double discount;
    private double finalPrice;

    public Product(String name, double basePrice, double discount) {
        this.name = name;
        this.basePrice = basePrice;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return '{' +
                "name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", discount=" + discount +
                ", finalPrice=" + finalPrice +
                '}';
    }
}
