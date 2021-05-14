package Models;

import java.util.UUID;

public class Tax {
    private String Name;
    private String taxID;
    private String type;
    private double taxAmount;
    private double minPrice;
    private double maxPrice;

    public Tax(String name, String type, double taxAmount, double minPrice, double maxPrice) {
        this.Name = name;
        this.type = type;
        this.taxAmount = taxAmount;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        UUID uid = UUID.randomUUID();
        this.taxID = uid.toString();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }
}
