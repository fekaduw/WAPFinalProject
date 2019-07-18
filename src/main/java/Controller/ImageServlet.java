package Controller;

import Model.Product;
import Model.ProductDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getPathInfo().substring(1));
        ProductDAOImpl productDAO = new ProductDAOImpl();
        Product product = productDAO.getProduct(productId);

//        resp.setHeader("Content-Type", getServletContext().getMimeType(image.getFilename()));
//        resp.setHeader("Content-Length", String.valueOf(image.getLength()));
//        resp.setHeader("Content-Disposition", "inline; filename=\"" + image.getFilename() + "\"");

        BufferedInputStream input = null;
        BufferedOutputStream output = null;

        try {
            if(product.getPicture()!=null) {
                input = new BufferedInputStream(product.getPicture());
                output = new BufferedOutputStream(resp.getOutputStream());
                byte[] buffer = new byte[8192];
                for (int length = 0; (length = input.read(buffer)) > 0; ) {
                    output.write(buffer, 0, length);
                }
            }
        } finally {
            if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
            if (input != null) try { input.close(); } catch (IOException logOrIgnore) {}
        }
    }
}
