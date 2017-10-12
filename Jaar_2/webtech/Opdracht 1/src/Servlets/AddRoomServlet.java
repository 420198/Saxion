package Servlets;

import Model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "addroom", urlPatterns = {"/addroom"})
public class AddRoomServlet extends HttpServlet {
    private RoomsDB roomsDB;
    private UserDB userDB;

    /**
     * Post functie, voegt een room toe en vangt fouten af
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)getServletContext().getAttribute("user");
        String naam =request.getParameter("naam");
        String vierkantemeters = request.getParameter("vierkantemeters");
        String prijs = request.getParameter("prijs");

        //checks voor emptyness
        if(naam.isEmpty()){
            request.getRequestDispatcher("/addroom.html").forward(request, response);
            return;
        }
        if(vierkantemeters.isEmpty() || Integer.parseInt(vierkantemeters)<=0){
            request.getRequestDispatcher("/addroom.html").forward(request, response);
            return;
        }
        if(prijs.isEmpty() || Double.parseDouble(prijs) <=0){
            request.getRequestDispatcher("/addroom.html").forward(request, response);
            return;
        }

        //Proberen room toe te voegen
        roomsDB = (RoomsDB)getServletContext().getAttribute("roomsdb");
        try {
            if (user instanceof Verhuurder) {
                roomsDB.addRoom(
                        new Room(naam,
                                Integer.parseInt(vierkantemeters),
                                Double.parseDouble(prijs),
                                new Verhuurder(user.getUsername(), user.getPassword())
                        )
                );
            }
        }catch (Exception e){
            request.getRequestDispatcher("/index.html").forward(request, response);
            return;
        }
        request.getRequestDispatcher("/index.html").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Als hij op de servlet komt zonder ingelogd te zijn of zonder post word hij weg gestuurd op basis van inloggen
        this.userDB = (UserDB) getServletContext().getAttribute("userdb");
        if(userDB.isLoggedIn()){
            request.getRequestDispatcher("/login.html").forward(request, response);
            return;
        }
        request.getRequestDispatcher("/addroom.html").forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
