import javax.swing.*;
import javax.swing.text.StringContent;
import java.awt.*;

/**
 * Created by kyle on 2/23/15.
 */
public class MessageFrame extends JFrame {
    private final String TITLE = "Message in a Bottle";
    private final int WINDOW_HEIGHT = 900;
    private final int WINDOW_WIDTH = 500;

    /**
     * Constructor for this class that opens a frame containing the MessagePanel
     */
    public MessageFrame(){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        MessagePanel messagePanel = new MessagePanel();
        container.add(messagePanel);
        setVisible(true);
    }
}
