import javax.swing.*;
import java.awt.*;

/**
 * Created by kyle on 2/23/15.
 */
public class MineFrame extends JFrame {
    public final String TITLE = "Minesweeper";
    public final int HEIGHT = 600;
    public final int WIDTH = 600;
    ScorePanel scorePanel;
    MinePanel minePanel;

    MineFrame(Game game){
        setSize(HEIGHT, WIDTH);
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        minePanel = new MinePanel(game);
        scorePanel = new ScorePanel(game);

        container.add(scorePanel, BorderLayout.NORTH);
        container.add(minePanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void setScoreMoves(int x){
        scorePanel.setMoves(x);
    }

    public void setScoreBombs(int x){
        scorePanel.setBombs(x);
    }
}
