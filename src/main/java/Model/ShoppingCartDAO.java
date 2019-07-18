package Model;

import java.util.List;

public interface ShoppingCartDAO {
    int addToCart(ShoppingCart shoppingCart);
    ShoppingCart getShoppingCart();
}