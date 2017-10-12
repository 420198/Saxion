package Servlets;

import Model.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sklar on 9/7/2016.
 */
@WebServlet(name = "showpersons", urlPatterns = {"/showpersons"})
public class ShowPersonsServlet extends HttpServlet {
    private Cookie cookie;
    private Cookie cookieDate;
    private String dateStr;
    private Cookie[] cookies;
    private int count;
    private UserDB userdb;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        userdb = (UserDB)getServletContext().getAttribute("userdb");
        cookies = request.getCookies();

        //Nieuwe date
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        //Koekjes ophalen uit de koektrommel en gelijk zetten naar een koekje dat tijdelijk word opgeslagen
        for (int i = 0; i < cookies.length; i++) {
            if(cookies[i].getName().equals("pageCount")){
                cookie = cookies[i];
                break;
            }
            if(cookies[i].getName().equals("cookieDate")){
                cookie = cookies[i];
                break;
            }
        }

        //Kijken of het koekje null is en dan een nieuw koekje bakken, anders oude waarde pakken
        if(cookie == null){
            cookie = new Cookie("pageCount", "1");
            cookie.setMaxAge(60*60*24*7);
            count = 1;
        }else{
            count = Integer.parseInt(cookie.getValue());
        }

        if(cookieDate == null){
            cookieDate = new Cookie("cookieDate", dateFormat.format(date));
            dateStr = cookieDate.getValue();
            cookieDate.setMaxAge(60*60*24*7);
        }else{
            dateStr = cookieDate.getValue();
        }

        //Printen
        response.getWriter().println("<html>" +
                "<head>" +
                "</head>" +
                "<body>" +
                "Laatst bezocht: " + dateStr +
                "<br>Hoeveel keer bezocht: " + count +
                "<br>Huurders:  " + userdb.printHuurders() +
                "<br>Verhuurders: " + userdb.printVerhuurders() +
                "</body>" +
                "</html>");
        //Nieuwe values en toevoege
        count++;
        cookie.setValue(String.valueOf(count));
        cookieDate.setValue(dateFormat.format(date));
        response.addCookie(cookie);
        response.addCookie(cookieDate);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
