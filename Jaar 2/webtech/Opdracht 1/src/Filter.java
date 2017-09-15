import Model.User;
import Model.UserDB;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sklar on 9/4/2016.
 */
@WebFilter(filterName = "filter", urlPatterns = "*")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest hReq = (HttpServletRequest) req;
        UserDB userDB = (UserDB) hReq.getServletContext().getAttribute("userdb");

        //Filter voor addroom
        if (((HttpServletRequest) req).getRequestURI().equals("/addroom.html")) {
            if (!userDB.isLoggedIn()) {
                ((HttpServletResponse) resp).sendRedirect("/login.html");
                return;
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
