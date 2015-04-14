import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by kyle on 4/1/15.
 */
public class Webserver {
    public static final int DEFUALT_PORT = 8000;

    public static void main (String args[]){
        ServerSocket socket = null;

        try {
            socket = new ServerSocket(DEFUALT_PORT);
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("starting server on localhost port 8000");

        while (true){
            try {
                Thread connectionThread = new Thread(new WebserverConnection(socket.accept()));
                connectionThread.start();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
