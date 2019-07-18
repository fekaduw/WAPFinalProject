package Model;

import java.util.ArrayList;
import java.util.List;

public class ProductDummyData {
    public static List<Product> populateProducts() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Bike");
        product1.setPrice(45);

        Product product2 = new Product();
        product1.setId(2);
        product1.setName("Watch");
        product1.setPrice(35);


        Product product3 = new Product();
        product1.setId(3);
        product1.setName("Bike");
        product1.setPrice(50);

        Product product4 = new Product();
        product1.setId(4);
        product1.setName("Watch");
        product1.setPrice(15);

        Product product5 = new Product();
        product1.setId(5);
        product1.setName("Watch");
        product1.setPrice(25);

        Product product6 = new Product();
        product1.setId(6);
        product1.setName("Camera");
        product1.setPrice(345);

        Product product7 = new Product();
        product1.setId(7);
        product1.setName("Camera");
        product1.setPrice(280);

        Product product8 = new Product();
        product1.setId(8);
        product1.setName("Flower");
        product1.setPrice(10);

        Product product9 = new Product();
        product1.setId(9);
        product1.setName("Flower");
        product1.setPrice(15);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);
        products.add(product8);
        products.add(product9);
        return products;
    }
}
