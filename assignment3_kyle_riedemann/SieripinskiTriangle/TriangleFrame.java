import javax.swing.*;
import java.awt.*;

/**
 * Created by kyle on 2/23/15.
 */
public class TriangleFrame extends JFrame {
    public final String TITLE = "Sierpinski's Triangle";
    public final int HEIGHT = 400;
    public final int WIDTH = 400;

    /**
     * Constructor for this class that opens a frame containing the TrianglePanel
     */
    public TriangleFrame(){
        setSize(HEIGHT, WIDTH);
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        TrianglePanel trianglePanel = new TrianglePanel();
        container.add(trianglePanel);
        setVisible(true);
    }
}
