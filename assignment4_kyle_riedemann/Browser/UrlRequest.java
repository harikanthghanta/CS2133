import java.io.*;
import java.net.Socket;

/**
 * Created by kyle on 3/21/15.
 */
public class UrlRequest {
    public static final int DEFAULT_PORT = 80;
    public String rawHTML = "";
    UrlFormatter urlFormatter;

    public String getRawHTML(){
        return rawHTML;
    }

    public String downloadRawHtml(String url){
        return downloadRawHtml(url, DEFAULT_PORT);
    }

    public String downloadRawHtml(String host, int port){
        Socket socket = null;

        //need to rename these, not very descriptive names
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;

        //probably just a temp variable, can use the entered url later
        String formattedRequest = "";

        urlFormatter = new UrlFormatter(host);
        formattedRequest = urlFormatter.createRequest();
        host = urlFormatter.getHostRequest();


        try {
            socket = new Socket(host, port);
        } catch (IOException e){
            e.printStackTrace();
        }

        if (socket != null && socket.isConnected()) {
            try {
                printWriter = new PrintWriter(socket.getOutputStream());
            } catch (IOException e){
                System.out.println("failed to create print writer");
            }

            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e){
                System.out.println("failed to create buffered reader");
            }

            System.out.println("Current request is:\n" + formattedRequest + "\n\n");
            printWriter.print(formattedRequest);
            printWriter.flush();

            String pageLine = "";
            try {
                while ((pageLine = bufferedReader.readLine()) != null){
                    rawHTML += pageLine;
                }
            } catch (IOException e){
                System.out.println("cannot get the next line from the buffered reader");
            }
        }

        return rawHTML;
    }
}
