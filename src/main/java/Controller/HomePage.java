package Controller;

import Model.Product;
import Model.ProductDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomePage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductDAOImpl productDAO = new ProductDAOImpl();

        List<Product> products = productDAO.getAllProducts();

        String email = req.getParameter("email");

        req.setAttribute("email", email);

        req.setAttribute("products", products);

        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
