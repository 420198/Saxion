package Servlets;

import Model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sklar on 9/8/2016.
 */
@WebServlet(name = "addroom.html", urlPatterns = {"/addroom.html"})
public class ViewRooms extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomsDB roomsDB = (RoomsDB) getServletContext().getAttribute("roomsdb");
        ArrayList<Room> rooms = new ArrayList<>();
        User user = (User) getServletContext().getAttribute("user");
        //Kamers ophalen
        for (Room room : roomsDB.getRooms()) {
            if (room.getVerhuurder().getUsername().equals(user.getUsername())) {
                rooms.add(room);
            }
        }

        //Weg sturen als user geen verhuurder is
        if (user instanceof Huurder) {
            request.getRequestDispatcher("/index.html").forward(request, response);
            return;
        }
        //Printen
        response.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Kamerverhuur</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form method=\"post\" action=\"addroom\">\n" +
                "        <label for=\"naam\">Naam</label>\n" +
                "        <input type=\"text\" id=\"naam\" name=\"naam\"> <br>\n" +
                "\n" +
                "        <label for=\"vierkantemeters\">Vierkante meters</label>\n" +
                "        <input type=\"number\" id=\"vierkantemeters\" name=\"vierkantemeters\"> <br>\n" +
                "\n" +
                "        <label for=\"prijs\">Prijs</label>\n" +
                "        <input type=\"number\" id=\"prijs\" step=\"0.01\" name=\"prijs\"> <br>\n" +
                "\n" +
                "        <input type=\"submit\">\n" +
                "    </form>\n");
        StringBuilder builder = new StringBuilder();
        for (Room room : rooms) {
            builder.append(room.toString() + "<br><br>");
        }

        response.getWriter().println("<br><br>Your rooms:<br>" + builder +
                "</body>\n" +
                "</html>");
    }
}
