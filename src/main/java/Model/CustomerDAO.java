package Model;

import java.util.List;

public interface CustomerDAO {
    boolean isCustomer(String email, String password);
    int addCustomer(Customer customer);
    Customer getCustomer(int id);
    Customer getCustomer(String email);
    List<Customer> getAllCustomers();

}
