package Controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "checkoutFilter", urlPatterns = {"/checkout"})
public class CheckoutFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = ((HttpServletRequest)request).getSession(false);

        String productsOnCart = request.getParameter("productsOnCart");
        if(productsOnCart!=null) {
            session.setAttribute("productsOnCart", productsOnCart);
        }

        boolean isLoggedIn = session != null && session.getAttribute("email") != null && session.getAttribute("password") != null;
        String loginURI = ((HttpServletRequest)request).getContextPath() + "/login";
        boolean isLoginRequest = ((HttpServletRequest)request).getRequestURI().equals(loginURI);
        boolean isLoginPage = ((HttpServletRequest)request).getRequestURI().endsWith("home.jsp");


        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            //request.getRequestDispatcher("checkout").forward(request, resp);
            chain.doFilter(request, resp);
        } else {
            request.setAttribute("requestFrom", "checkout");
            request.getRequestDispatcher("login.jsp").forward(request, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }
}