package httpServer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by sklar on 12/22/2016.
 */
public class Headers {
    private String statusheader = "HTTP/1.1 ";
    private String statuscode = "200 OK";
    private String date = "Date: ";
    private String server = "Server: The_Boss_1337";
    private String contentType = "Content-Type: text/html; charset=UTF-8";
    private String contentLength = "Content-Length: ";
    private String connection = "Connection: close";
    private String lastModified = "Last-Modified: ";
    private String authentication = "WWW-Authenticate: Basic";

    /**
     * Constructor to create a headers object, needs length of the body of a request
     * @param contentLength int length of body
     */
    public Headers(int contentLength) {
        this.contentLength += contentLength;
        date += getServerTime();
        lastModified += getServerTime();
    }

    /**
     * Get the formatted time to send in the header
     * @return String
     */
    private String getServerTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(calendar.getTime());
    }

    /**
     * Set the content-type / mimetype
     * @param contentType String
     */
    public void setContentType(String contentType) {
        this.contentType = this.contentType.replace("text/html", contentType);
    }

    /**
     * Public method to get the headers that are set in this class
     * @param authentication boolean Do you want the authentication-header?
     * @return String headers
     */
    public String getHeaders(boolean authentication) {
        if(authentication) {
            return this.getDefaultHeaders() + this.authentication + "\r\n" + connection + "\r\n\r\n";
        }

        return this.getDefaultHeaders() + connection + "\r\n\r\n";
    }

    /**
     * Get the default set of headers that is almost always used
     * @return String
     */
    private String getDefaultHeaders(){
        return statusheader + statuscode + "\r\n" +
                date + "\r\n" +
                server + "\r\n" +
                contentType + "\r\n" +
                lastModified + "\r\n" +
                contentLength + "\r\n";
    }

    /**
     * Get headers for a "moved"-response
     * @param movedToUrl String
     * @return String headers
     */
    public String getMoved(String movedToUrl){
        return "HTTP/1.1 301 Moved Permanently\r\n" + "Location: " + movedToUrl;
    }

    /**
     * Set a status code
     * @param code int
     */
    public void setStatuscode(int code) {
        switch(code){
            case 500 :
                this.statuscode = "500 Internal Server Error";
                break;
            case 401 :
                this.statuscode = "401 Not Authorized";
                break;
            case 404 :
                this.statuscode = "404 Not Found";
            default :
                this.statuscode = "200 OK";
                break;
        }
    }
}
