package Model;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    static Connection connection;
    static PreparedStatement preparedStatement;

    @Override
    public int addProduct(Product product) {
        int status = 0;
        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Product(name, price, picture, description) VALUES(?, ?,?,?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());

            if(product.getPicture()!=null)
            //preparedStatement.setBlob(3, product.getPicture());

            preparedStatement.setBlob(3, product.getPicture());
            preparedStatement.setString(4, product.getDescription());

            status = preparedStatement.executeUpdate();
            connection.close();

        } catch (Exception e) {

        }
        return status;
    }

    @Override
    public double getTotalPrice(List<Product> products) {
        return products.stream().map(p->p.getPrice()).reduce(0.0, Double::sum);
    }

    @Override
    public Product getProduct(int id) {
        Product product = new Product();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Product where id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getInt(3));
                product.setPicture(resultSet.getBlob(4).getBinaryStream());
                product.setDescription(resultSet.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return product;
    }

    @Override
    public List<Product> getProductsByName(String searchTerm) {

        List<Product> products = new ArrayList<>();
        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Product where name like ?");
            preparedStatement.setString(1, "%"+searchTerm+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getInt(3));
                Blob picBlob = resultSet.getBlob(4);
                if(picBlob!=null) {
                    product.setPicture(picBlob.getBinaryStream());
                }

                product.setDescription(resultSet.getString(5));

                products.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return products;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Product");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getInt(3));
                Blob picBlob = resultSet.getBlob(4);
                if(picBlob!=null) {
                    product.setPicture(picBlob.getBinaryStream());
                }

                product.setDescription(resultSet.getString(5));

                products.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return products;
    }
}

