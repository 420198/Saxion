package Servlets;

import Model.Huurder;
import Model.User;
import Model.UserDB;
import Model.Verhuurder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sklar on 8/31/2016.
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    UserDB udb;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //Kijken of de parameters empty zijn
        if((username.isEmpty() || password.isEmpty()) || (username.isEmpty() && password.isEmpty())){
            request.getRequestDispatcher("/WEB-INF/fouteinlog.html").forward(request, response);
            return;
        }

        //Huurder of verhuurder zetten
        udb = (UserDB)getServletContext().getAttribute("userdb");
        User user = null;
        for (int i = 0; i < udb.getUsers().size(); i++) {
            if(udb.getUsers().get(i).getUsername().equals(username)){
                if(udb.getUsers().get(i) instanceof Verhuurder){
                    user= new Verhuurder(username,password);
                }else{
                    user = new Huurder(username,password);
                }
            }
        }

        //Proberen user in te loggen
        if(udb.login(user)){
            getServletContext().setAttribute("user", user);
            response.sendRedirect("/huurder.html");
        }else{
            getServletContext().getRequestDispatcher("/WEB-INF/fouteinlog.html").forward(request, response);
        }
    }

    /*
    Weg sturen als hij niet via post is gekomen
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/fouteinlog.html").forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
