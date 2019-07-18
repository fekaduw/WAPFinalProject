package Model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    private List<Product> productList;
    private String sessionId;
    private Timestamp date;
    private double totalPrice;

    public ShoppingCart() {
//        productList = new ArrayList<>();
//        List<Product> allProduct = ProductDummyData.populateProducts();
//        productList = allProduct.stream().filter(p->ids.contains(p.getId())).collect(Collectors.toList());
//
//        totalPrice = 0.0;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public double getTotalPrice() {
        totalPrice = productList.stream().map(p -> p.getPrice()).reduce(0.0, Double::sum);
        return totalPrice;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
