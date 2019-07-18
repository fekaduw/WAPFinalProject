package Controller;

import Model.Product;
import Model.ProductDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/addProduct")
@MultipartConfig(maxFileSize = 16177215)

public class AddProduct extends HttpServlet {
    private static final int BUFFER_SIZE = 4096;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        Part picture = req.getPart("picture");

        if (!name.equals("") && price > 0 && picture != null) {
            InputStream inputStream = picture.getInputStream();

            ProductDAOImpl productDAOImpl = new ProductDAOImpl();
            Product product = new Product(name, price, description, inputStream);
            int status = productDAOImpl.addProduct(product);

            req.setAttribute("message", status > 0 ? "Successfully added the product." : "Sorry, the product could not be added.");
        }

        resp.sendRedirect("productlist");
    }
}
