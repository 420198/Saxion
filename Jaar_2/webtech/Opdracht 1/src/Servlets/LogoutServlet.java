package Servlets;

import Model.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sklar on 9/4/2016.
 */
@WebServlet(name = "logout", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {
    UserDB userDB;
    /*
    Proberen uit te loggen
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       userDB = (UserDB)getServletContext().getAttribute("userdb");
        if(userDB.isLoggedIn()){
            userDB.logout();
            getServletContext().removeAttribute("user");
            request.getSession().invalidate();
            response.sendRedirect("/index.html");
            return;
        }else{
            response.sendRedirect("/index.html");
        }
    }

    /*
    Weg sturen als hij niet via post is gekomen
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/fouteregistratie.html").forward(req, resp);
    }
}
