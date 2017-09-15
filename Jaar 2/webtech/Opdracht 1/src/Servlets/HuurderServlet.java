package Servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "huurder", urlPatterns = {"/huurder.html"})
public class HuurderServlet extends HttpServlet {
    /**
     * Get methode voor servlet
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Html printen, niet veel bijzonders
        response.getWriter().println("<html>" +
                "<head>" +
                "\n" +
                "    <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
                "    <link href=\"css/media_queries.css\" rel=\"stylesheet\" type=\"text/css\">" +
                "</head>");

        response.getWriter().println("<body>");

        response.getWriter().println("<br><a href=\"index.html\" class=\"submit\">home</a>");
        response.getWriter().println("<br><div class=\"l_r_Box\">\n" +
                "            <div class=\"header\"><h1>Search room form</h1></div>\n" +
                "            <div class=\"error\">Als max kleiner is dan min worden ze omgedraaid! TIP: Geef overal 1 mee om alle resultaten te krijgen</div>"+
                "            <form name=\"form_searchroom\" class=\"login\" action=\"searchroom\" method=\"post\">\n" +
                "                <input type=\"text\" name=\"Naam\" class=\"username\"placeholder=\"Naam\"/><br/>\n" +
                "                <div class=\"soort\">\n" +
                "                    <input type=\"number\" name=\"minMeter\" value=\"minMeter\" id=\"minMeter\"/>" +
                "                    <label for=\"minMeter\">Min meter</label><br/>" +
                "                    <input type=\"number\" name=\"maxMeter\" value=\"maxPrijs\" id=\"maxMeter\"/>\n" +
                "                    <label for=\"maxMeter\">Max meter</label><br/>\n" +
                "                    <br>" +
                "                    <input type=\"number\" name=\"minPrijs\" value=\"minPrijs\" id=\"minPrijs\"/>" +
                "                    <label for=\"minPrijs\">Min prijs</label><br/>" +
                "                    <input type=\"number\" name=\"maxPrijs\" value=\"maxPrijs\" id=\"maxPrijs\"/>\n" +
                "                    <label for=\"maxPrijs\">Max prijs</label><br/>\n" +
                "                </div>\n" +
                "                <input type=\"submit\" class=\"submit\" name=\"Send\" value=\"Send\"/>\n" +
                "                <input type=\"reset\" class=\"reset\" name=\"Reset\" valie=\"Reset\"/><br/>\n" +
                "            </form>\n" +
                "        </div>");

        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

}
