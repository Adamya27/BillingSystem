
import Models.Product;
import Models.Tax;
import Services.BillingSystem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BillingSystemDriver {
    public static void main(String args[]) throws IOException, ParseException {


        JSONObject taxObj = (JSONObject) new JSONParser().parse(new FileReader("/Users/b0212222/Downloads/BillingSystem/src/main/resources/Taxes.json"));
        Set<String> taxKeys = taxObj.keySet();
        List<Tax> taxes = new ArrayList<>();
        for (String key : taxKeys){
            String taxName = key;
            JSONObject obj = (JSONObject) taxObj.get(key);
            String taxType = obj.get("type").toString();
            String minPr = obj.get("minPrice") != null ? obj.get("minPrice").toString() : "0";
            String maxPr = obj.get("maxPrice") != null ? obj.get("maxPrice").toString() : "100000000";
            String taxRate = obj.get("tax").toString();
            double minPrice = Double.parseDouble(minPr);
            double maxPrice =Double.parseDouble(maxPr);
            double taxAmount = Double.parseDouble(taxRate);
            Tax tax = new Tax(taxName, taxType, taxAmount, minPrice, maxPrice);
            taxes.add(tax);
        }

        JSONArray productObj = (JSONArray) new JSONParser().parse(new FileReader("/Users/b0212222/Downloads/BillingSystem/src/main/resources/Products.json"));
        List<Product> products = new ArrayList<>();
        for( Object product: productObj){
            JSONObject productObject = (JSONObject) product;
            String itemName = productObject.get("item").toString();
            String discount = productObject.get("discount") != null ? productObject.get("discount").toString() : "0";
            double discountAmount = Double.parseDouble(discount);
            String basePrice = productObject.get("basePrice").toString();
            double basePriceAmount = Double.parseDouble(basePrice);
            Product prod = new Product(itemName, basePriceAmount, discountAmount);
            products.add(prod);
        }

        BillingSystem billingSystem = new BillingSystem(taxes, products);
        List<Product> finalProduct = billingSystem.calculateFinalPrice();

        FileWriter fileWriter = new FileWriter("/Users/b0212222/Downloads/BillingSystem/src/main/resources/Output.json");

       fileWriter.write(finalProduct.toString());
        fileWriter.close();
    }
}
