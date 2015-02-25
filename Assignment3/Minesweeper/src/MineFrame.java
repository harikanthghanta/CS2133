import javax.swing.*;
import java.awt.*;

/**
 * Created by kyle on 2/23/15.
 */
public class MineFrame extends JFrame {
    public final String TITLE = "Minesweeper";
    public final int HEIGHT = 800;
    public final int WIDTH = 800;
    ScorePanel scorePanel;
    MinePanel minePanel;
    Game game;

    //difficulty constants
    public static final int EASY = 1;
    public static final int MEDIUM = 2;
    public static final int HARD = 3;
    public static final int BOMBASTIC = 4;

    MineFrame(){
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image im = toolkit.getImage("assets/simple_bomb.png");
        im = im.getScaledInstance(20, 20, 0);

        ImageIcon imageIcon = new ImageIcon(im);

        Object[] setValue = {"EASY", "MEDIUM", "HARD", "BOMBASTIC"};

        int difficlty = JOptionPane.showOptionDialog(null, "Please pick a difficulty", "Minesweeper", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, imageIcon, setValue, setValue[1]);

        switch (difficlty){
            case 0:
                System.out.println("EASY");
                game = new Game(EASY);
                break;
            case 1:
                System.out.println("MEDIUM");
                game = new Game(MEDIUM);
                break;
            case 2:
                System.out.println("HARD");
                game = new Game(HARD);
                break;
            case 3:
                System.out.println("BOMBASTIC");
                game = new Game(BOMBASTIC);
                break;
            default:
                System.out.println("EASY");
                game = new Game(EASY);
                break;
        }

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
