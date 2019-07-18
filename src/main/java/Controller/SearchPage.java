package Controller;

import Model.Product;
import Model.ProductDAOImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchPage extends HttpServlet{

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            ProductDAOImpl productDAO = new ProductDAOImpl();

            String searchTerm = req.getParameter("searchTerm");

            List<Product> products;
            if(searchTerm==null || searchTerm.equals("")){
                products = productDAO.getAllProducts();
            }
            else {
                products = productDAO.getProductsByName(searchTerm);
            }

            String email = req.getParameter("email");

            req.setAttribute("email", email);

            req.setAttribute("products", products);

//            req.getRequestDispatcher("home.jsp").forward(req, resp);

            Gson obj = new Gson();
            String json = obj.toJson(products);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req,resp);
        }
}
