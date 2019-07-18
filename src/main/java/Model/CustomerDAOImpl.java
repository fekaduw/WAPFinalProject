package Model;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;

    @Override
    public boolean isCustomer(String email, String password) {
        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT  * FROM Customer WHERE email=? AND password=?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet == null) return false;

            resultSet.last();
            return resultSet.getRow() > 0;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public int addCustomer(Customer customer) {
        int status = 0;

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Customer(firstName, lastName, email, password, state, city, address) VALUES(?, ?, ?, ?, ?, ?,?)");
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPassword());
            preparedStatement.setString(5, customer.getState());
            preparedStatement.setString(6, customer.getCity());
            preparedStatement.setString(7, customer.getAddress());

            status = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }

    @Override
    public Customer getCustomer(String email) {
        Customer customer = new Customer();
        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Customer where email=?");
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                setCustomerData(resultSet, customer);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return customer;
    }

    @Override
    public Customer getCustomer(int id) {
        Customer customer = new Customer();
        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Customer where id=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                setCustomerData(resultSet, customer);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Customer");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                setCustomerData(resultSet, customer);
                customers.add(customer);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private void setCustomerData(ResultSet resultSet, Customer customer) throws SQLException {
        customer.setId(resultSet.getInt(1));
        customer.setFirstName(resultSet.getString(2));
        customer.setLastName(resultSet.getString(3));
        customer.setEmail(resultSet.getString(4));
        customer.setPassword(resultSet.getString(5));
        customer.setState(resultSet.getString(6));
        customer.setCity(resultSet.getString(7));
        customer.setAddress(resultSet.getString(8));
    }
}
