package Servlets;

import Model.Room;
import Model.RoomsDB;
import Model.User;
import Model.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sklar on 9/7/2016.
 */
@WebServlet(name = "searchroom", urlPatterns = {"/searchroom"})
public class SearchRoomsServlet extends HttpServlet {
    private RoomsDB roomsDB;
    private ArrayList<Room> rooms;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        roomsDB = (RoomsDB) getServletContext().getAttribute("roomsdb");
        String naam = request.getParameter("Naam");

        if (request.getParameter("minMeter").isEmpty()) {
            request.getRequestDispatcher("/huurder").forward(request, response);
            return;
        }
        if (request.getParameter("maxMeter").isEmpty()) {
            request.getRequestDispatcher("/huurder").forward(request, response);
            return;
        }
        if (request.getParameter("minPrijs").isEmpty()) {
            request.getRequestDispatcher("/huurder").forward(request, response);
            return;
        }
        if (request.getParameter("maxPrijs").isEmpty()) {
            request.getRequestDispatcher("/huurder").forward(request, response);
            return;
        }

        //Parse exceptions afvangen
        int minMeter = 0;
        int maxMeter = 0;
        int minPrijs = 0;
        int maxPrijs = 0;
        try {
            minMeter = Integer.parseInt(request.getParameter("minMeter"));
            maxMeter = Integer.parseInt(request.getParameter("maxMeter"));
            minPrijs = Integer.parseInt(request.getParameter("minPrijs"));
            maxPrijs = Integer.parseInt(request.getParameter("maxPrijs"));
        } catch (Exception e) {
            request.getRequestDispatcher("/huurder.html").forward(request, response);
            return;
        }

        //Min kleiner dan max afvangen
        if (minMeter > maxMeter) {
            int temp = maxMeter;
            maxMeter = minMeter;
            minMeter = temp;
        }
        if (minPrijs > maxPrijs) {
            int temp = maxPrijs;
            maxPrijs = minPrijs;
            minPrijs = temp;
        }

        //Search magic
        rooms = roomsDB.getRooms();
        for (Room room : rooms) {
            if (naam.isEmpty()) {
                if (room.getPrijs() >= minPrijs && room.getPrijs() <= maxPrijs && room.getVierkanteMeters() >= minMeter && room.getVierkanteMeters() <= maxMeter) {
                    builder.append(room.toString() + "<br><br>");
                }
            }
            if (!naam.isEmpty()) {
                if (room.getPrijs() >= minPrijs && room.getPrijs() <= maxPrijs && room.getVierkanteMeters() >= minMeter && room.getVierkanteMeters() <= maxMeter && room.getNaam().equals(naam)) {
                    builder.append(room.toString() + "<br><br>");
                }
            }
            if (naam.equals("1") && minPrijs == 1 && maxPrijs == 1 & maxMeter == 1 && minMeter == 1) {
                builder.append(room.toString() + "<br><br>");
            }
        }

        //Uitpritnen
        response.getWriter().println("<html>" +
                "<body>" +
                "Rooms found: " + builder +
                "<a href=\"index.html\"><h1>Index!!!!!!!</h1></a>" +
                "</body>" +
                "</html>");
    }

    /*
    Weg sturen als hij niet door een post komt
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.html").forward(request,response);
    }
}
