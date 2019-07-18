package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

@WebServlet("/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("email");
        req.getSession().removeAttribute("password");

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            boolean dontDeleteCookie = Stream.of(cookies).filter(c -> c.getName().equals("rememberme")).count() > 0;
            if (!dontDeleteCookie) {
                for (Cookie cookie : cookies) {
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
            }
        }

        req.getRequestDispatcher("").forward(req, resp);
    }
}
