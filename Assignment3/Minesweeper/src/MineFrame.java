import javax.swing.*;
import java.awt.*;

/**
 * Created by kyle on 2/23/15.
 */
public class MineFrame extends JFrame {
    public final String TITLE = "Minesweeper";
    public final int HEIGHT = 600;
    public final int WIDTH = 600;

    MineFrame(Game game){
        setSize(HEIGHT, WIDTH);
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        MinePanel minePanel = new MinePanel(game);
        ScorePanel scorePanel = new ScorePanel(game);

        container.add(scorePanel, BorderLayout.NORTH);
        container.add(minePanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
