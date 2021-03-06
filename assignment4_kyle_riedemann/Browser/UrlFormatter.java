import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kyle on 3/15/15.
 *
 * class to create the request to send in the connection socket
 *
 * Example:
 * GET /wiki/Hypertext_Transfer_Protocol HTTP/1.1\r\n
 * Host: en.wikipedia.org\r\n
 * \r\n
 */
public class UrlFormatter {
    public String enteredString = "";
    public URL confirmedURL;
    private String fileRequest = "";
    private String hostRequest = "";
    private final String DEFAULT_PROTOCOL = "HTTP/1.1";

    UrlFormatter(String url){
        this.enteredString = url;
        parseURL();
    }

    public String getHostRequest() {
        return hostRequest;
    }

    public void parseURL(){
        try {
            //make sure the URL starts with http://
            if(!(enteredString.startsWith("http://"))){
                enteredString = "http://" + enteredString;
            }

            confirmedURL = new URL(enteredString);
            fileRequest = ( (fileRequest = confirmedURL.getFile().trim()).equals("")) ? "/" : fileRequest;
            System.out.println("File request: '"+fileRequest+"'");
            hostRequest = confirmedURL.getHost();
        } catch (MalformedURLException e){
            System.out.println("Malformed URL exception");
        }
    }

    public String createRequest(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GET "+fileRequest+" "+DEFAULT_PROTOCOL+"\n");
        stringBuilder.append("host: "+hostRequest+" \n\n");

        return stringBuilder.toString();
    }

    public void setEnteredString(String enteredString) {
        this.enteredString = enteredString;
        System.out.println(enteredString);
    }
}
