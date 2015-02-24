import javax.swing.*;
import java.awt.*;

/**
 * Created by kyle on 2/23/15.
 */
public class MineFrame extends JFrame {
    public final String TITLE = "Minesweeper";
    public final int HEIGHT = 500;
    public final int WIDTH = 500;

    MineFrame(Board board){
        setSize(HEIGHT, WIDTH);
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        MinePanel minePanel = new MinePanel(board);
        container.add(minePanel);
        setVisible(true);
    }
}
