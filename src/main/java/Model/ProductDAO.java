package Model;

import java.util.List;

public interface ProductDAO {
     int addProduct(Product product);
     Product getProduct(int id);
     List<Product> getProductsByName(String searchTerm);
     List<Product> getAllProducts();
     double getTotalPrice(List<Product> products);
}
