package com.kyleriedemann;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by kyle on 3/24/15.
 */
public class RobotInstructor {
    Socket robotSocket = null;
    PrintWriter commandWriter = null;

    //connection info
    final String HOST = "lear.cs.okstate.edu";
    final int PORT = 9090;

    //JSON constants to land and takeoff
    final String TAKEOFF_MSG = "{\"op\":\"publish\",\"topic\":\"/ardrone/takeoff\",\"msg\":{}}";
    final String LAND_MSG = "{\"op\":\"publish\",\"topic\":\"/ardrone/land\",\"msg\":{}}";

    //status codes
    final int SUCCESS = 1;
    final int FAILURE = 0;

    RobotInstructor(){
        try {
            robotSocket = new Socket(HOST, PORT);
            commandWriter = new PrintWriter(robotSocket.getOutputStream());
            System.out.println("socket created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createSocket(){
        try {
            robotSocket = new Socket(HOST, PORT);
            commandWriter = new PrintWriter(robotSocket.getOutputStream());
            System.out.println("socket created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int commandTakeoff(){
        if(robotSocket != null && commandWriter != null){
            commandWriter.print(TAKEOFF_MSG);
            commandWriter.flush();

            return SUCCESS;
        } else {
            return FAILURE;
        }
    }

    public int commandLand(){
        if(robotSocket != null && commandWriter != null){
            commandWriter.print(LAND_MSG);
            commandWriter.flush();

            return SUCCESS;
        } else {
            return FAILURE;
        }
    }
}
