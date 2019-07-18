package Controller;

import Model.Customer;
import Model.CustomerDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginPage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String requestFrom = req.getParameter("requestFrom");

        boolean isRememberMeSelected = req.getParameter("rememberme") != null;

        HttpSession session = req.getSession();

        if(!email.equals("") && !password.equals("")){
            if(customerDAO.isCustomer(email, password)){
                //create session here...
                session.setAttribute("email", email);
                session.setAttribute("password", password);

                req.setAttribute("email", email);
                req.setAttribute("productsOnCart", session.getAttribute("productsOnCart"));

                if (isRememberMeSelected) {
                    Cookie cookieUserName = new Cookie("email", email);
                    cookieUserName.setMaxAge(60 * 60 * 24 * 30);
                    resp.addCookie(cookieUserName);

                    Cookie cookiePassword = new Cookie("password", password);
                    cookiePassword.setMaxAge(60 * 60 * 24 * 30);
                    resp.addCookie(cookiePassword);

                    Cookie remembermeCookie = new Cookie("rememberme", isRememberMeSelected?"true":"false");
                    remembermeCookie.setMaxAge(60 * 60 * 24 * 30);
                    resp.addCookie(remembermeCookie);
                } else {
                    Cookie[] cookies = req.getCookies();
                    if (cookies != null) {
                        for (Cookie cookie : cookies) {
                            cookie.setValue("");
                            cookie.setMaxAge(0);
                            resp.addCookie(cookie);
                        }
                    }
                }

                if(requestFrom!=null){
                    req.getRequestDispatcher("checkout").forward(req, resp);
                }else {
                    req.getRequestDispatcher("").forward(req, resp);
                }
            }else{
                //display error
                session.setAttribute("error", "Invalid user name or password.");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }else{
            //display error
            session.setAttribute("error", "Invalid user name or password.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
