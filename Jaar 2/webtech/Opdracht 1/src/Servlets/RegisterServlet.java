package Servlets;

import Model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sklar on 8/31/2016.
 */
@WebServlet(name = "register", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String soort = request.getParameter("soort");
        User user;

        //Afvangen als er parameters empty zijn
        if ((username.isEmpty() || password.isEmpty()) || (username.isEmpty() && password.isEmpty())) {
            request.getRequestDispatcher("/WEB-INF/fouteregistratie.html").forward(request, response);
            return;
        }
        //Afhandelen van soort
        if(soort.isEmpty()){
            request.getRequestDispatcher("/WEB-INF/fouteregistratie.html").forward(request, response);
            return;
        } else if (soort.equals("Model.Huurder")) {
            user = new Huurder(username, password);
        } else {
            user = new Verhuurder(username, password);
        }

        //Registreren
        UserDB udb = (UserDB) getServletContext().getAttribute("userdb");
        if (udb.register(user)) {
            request.getRequestDispatcher("/login.html").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/fouteregistratie.html").forward(request, response);
        }
    }

    /*
    Weg sturen als hij niet via post is gekomen
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/fouteregistratie.html").forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

}
