package com.kylealanr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        Socket socket;
        PrintWriter printWriter;
        BufferedReader bufferedReader;

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

        try {
            socket = new Socket(url, port);
        } catch (IOException e){
            System.out.println("IO Exception");
        }

        return "";
    }
}
