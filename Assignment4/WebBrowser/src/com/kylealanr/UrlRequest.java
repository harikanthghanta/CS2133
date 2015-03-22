package com.kylealanr;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.rmi.UnexpectedException;

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

    public String downloadRawHtml(String url, int port){
        Socket socket = null;

        //need to rename these, not very descriptive names
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;

        //probably just a temp variable, can use the entered url later
        String validatedURL = "";


        //make sure the URL starts with http://
        if(!(url.startsWith("http://")) && port == 80){
            url = "http://" + url;
        } else if (!(url.startsWith("https://")) && port == 443){
            url = "https://" + url;
        }

        urlFormatter = new UrlFormatter(url);
        validatedURL = urlFormatter.createRequest();
        url = urlFormatter.getHostRequest();


        try {
            socket = new Socket(url, port);
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

            printWriter.print(validatedURL);
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
