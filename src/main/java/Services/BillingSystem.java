package Services;

import Models.Product;
import Models.Tax;

import java.util.ArrayList;
import java.util.List;

public class BillingSystem {
    private List<Tax> taxes;
    private List<Product> products;
    private BillingSystemHelper billingSystemHelper;

    public BillingSystem(List<Tax> taxes, List<Product> products) {
        this.taxes = taxes;
        this.products = products;
        this.billingSystemHelper = new BillingSystemHelper();
    }

   public  List<Product> calculateFinalPrice(){

        List<Product> products = getProducts();
        List<Tax> taxes = getTaxes();
        for(Product product : products){
            double finalPrice = getBillingSystemHelper().getFinalPrice(taxes, product);
            product.setFinalPrice(finalPrice);
        }
        return products;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public BillingSystemHelper getBillingSystemHelper() {
        return billingSystemHelper;
    }

    public void setBillingSystemHelper(BillingSystemHelper billingSystemHelper) {
        this.billingSystemHelper = billingSystemHelper;
    }
}
