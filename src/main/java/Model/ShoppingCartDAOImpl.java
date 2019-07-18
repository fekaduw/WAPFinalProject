package Model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDAOImpl implements ShoppingCartDAO {

    static Connection connection;
    static PreparedStatement preparedStatement;

    @Override
    public int addToCart(ShoppingCart shoppingCart) {
        int status = 0;
        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO ShoppingCart VALUES (?,?,?)");

//            Timestamp date = new Timestamp(new java.util.Date().getTime());

            for(Product product : shoppingCart.getProductList()){
                preparedStatement.setInt(1, product.getId());
                preparedStatement.setTimestamp(2, shoppingCart.getDate());
                preparedStatement.setString(3, shoppingCart.getSessionId());
                status = preparedStatement.executeUpdate();
            }

            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }

    @Override
    public ShoppingCart getShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM ShoppingCart");

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt(1));
                products.add(product);

                shoppingCart.setProductList(products);
                shoppingCart.setSessionId(resultSet.getString(2));
                shoppingCart.setDate(resultSet.getTimestamp(3));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return shoppingCart;
    }
}
