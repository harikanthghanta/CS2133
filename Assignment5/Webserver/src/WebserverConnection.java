import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kyle on 4/7/15.
 */
public class WebserverConnection implements Runnable {
    public static final String INDEX_HTML = "index.html";
    private final String HTTTP_RESPONSE_GOOD = "HTTP/1.1 200 OK\\r\\n";
    private final String HTTTP_RESPONSE_NOT_FOUND = "HTTP/1.1 404 Not Found\\r\\n\\r\\n";
    private final String HTTTP_RESPONSE_INTERNAL_ERROR = "HTTP/1.1 500 Internal Server Error\\r\\n\\r\\n";

    private final String CONTENT_HTML = "Content-type: text/html\\r\\n\\r\\n";
    private final String CONTENT_JPG = "Content-type: image/jpg\\r\\n\\r\\n";

    private Socket socket;

    WebserverConnection(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        String input = "";

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (bufferedReader.readLine() != null){
                String line = bufferedReader.readLine();
                if(line.startsWith("GET")){
                    break;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        String fileName = fileNameRegex(input);

        

    }

    public String fileNameRegex(String input) {

        String file = "";

        if(input == null){
            return INDEX_HTML;
        }

        Matcher matcher = Pattern.compile("GET\\s\\/(.*?)\\sHTTP\\/1\\.1", Pattern.DOTALL | Pattern.CASE_INSENSITIVE).matcher(input);
        try {
            while (matcher.find()){
                file = matcher.group(1);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        if(file == "/" || file == "") {
            return INDEX_HTML;
        } else {
            return file;
        }
    }
}
