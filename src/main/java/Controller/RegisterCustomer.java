package Controller;

import Model.Customer;
import Model.CustomerDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerCustomer")
public class RegisterCustomer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();

        String firsName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String state = req.getParameter("state");
        String city = req.getParameter("city");
        String address = req.getParameter("address");

        if(!firsName.equals("") && !lastName.equals("") && !email.equals("") && !password.equals("") && !state.equals("") && !city.equals("") && !address.equals("")){
            Customer customer = new Customer(firsName, lastName, email, password, state, city, address);

            int status = customerDAO.addCustomer(customer);

            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("registercustomer.jsp").forward(req, resp);
        }
    }
}
