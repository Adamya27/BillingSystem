package Services;

import Models.Product;
import Models.Tax;

import java.util.ArrayList;
import java.util.List;

public class BillingSystemHelper {

    public boolean isTaxRelevant(Tax tax, Product product){
        if(tax.getMaxPrice() < product.getBasePrice()){
            return false;
        }
        if(tax.getMinPrice() > product.getBasePrice()){
            return false;
        }
        return true;
    }

    public double getFinalPrice(List<Tax> taxes, Product product){
        double discountAmount = getDiscountAmount(product.getBasePrice(), product.getDiscount());
        double totalTax = 0.0;

        for(Tax tax: taxes){
            if(isTaxRelevant(tax, product)){
                totalTax += getTotalTax(product.getBasePrice(), tax);
            }
        }
        return product.getBasePrice() + totalTax - discountAmount;

    }

    public double getDiscountAmount(double basePrice, double discount){
        return basePrice*discount/100;
    }

    public double getTotalTax(double basePrice, Tax tax){

        if(tax.getType().equals("fixed")){
            return tax.getTaxAmount();
        }

        return basePrice * tax.getTaxAmount()/100;

    }
}
