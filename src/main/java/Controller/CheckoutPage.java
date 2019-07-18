package Controller;

import Model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet("/checkout")
public class CheckoutPage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDAOImpl productDAO = new ProductDAOImpl();

        String stringIds = req.getParameter("productsOnCart");
        if(stringIds== null)
        {
            stringIds = (String) req.getSession().getAttribute("productsOnCart");
        }

        String email = req.getParameter("email");

        if(stringIds!=null && !stringIds.equals("")) {
            List<Integer> ids = Stream.of(stringIds.split(",")).map(p -> Integer.parseInt(p)).collect(Collectors.toList());
            List<Product> productsOncart = new ArrayList<>();

            for(Integer id : ids){
                productsOncart.add(productDAO.getProduct(id));
            }

            CustomerDAOImpl customerDAO = new CustomerDAOImpl();
            Customer customer = customerDAO.getCustomer(email);


            req.setAttribute("products", productsOncart);
            req.setAttribute("totalprice", productDAO.getTotalPrice(productsOncart));

            req.setAttribute("customer", customer);

            req.getRequestDispatcher("checkout.jsp").forward(req, resp);
        }
        else
        {
            req.getRequestDispatcher("").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
