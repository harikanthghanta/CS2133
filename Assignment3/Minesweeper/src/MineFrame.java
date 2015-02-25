import javax.swing.*;
import java.awt.*;

/**
 * Created by kyle on 2/23/15.
 */
public class MineFrame extends JFrame {
    public final String TITLE = "Minesweeper";
    public final int START_HEIGHT = 100;
    public final int START_WIDTH = 400;
    public final int HEIGHT = 800;
    public final int WIDTH = 800;
    ScorePanel scorePanel;
    MinePanel minePanel;

    MineFrame(){
        setSize(START_WIDTH, START_HEIGHT);
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();



        //TODO JOptions panel to select the difficulty

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image im = toolkit.getImage("assets/simple_bomb.png");
        im = im.getScaledInstance(20, 20, 0);

        ImageIcon imageIcon = new ImageIcon(im);

        Object[] setValue = {"EASY", "MEDIUM", "HARD", "BOMBASTIC"};

        int difficlty = JOptionPane.showOptionDialog(null, "Please pick a difficulty", "Minesweeper", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, imageIcon, setValue, setValue[1]);

        //TODO construct game object with specified difficulty here
        switch (difficlty){
            case 0:
                System.out.println("EASY");
                break;
            case 1:
                System.out.println("MEDIUM");
                break;
            case 2:
                System.out.println("HARD");
                break;
            case 3:
                System.out.println("BOMBASTIC");
                break;
            default:
                System.out.println("EASY");
                break;
        }

        //TODO pass the game we make here to these constructors
        /*
        container.remove(difficultyPanel);

        setSize(WIDTH, HEIGHT);

        minePanel = new MinePanel(game);
        scorePanel = new ScorePanel(game);

        container.add(scorePanel, BorderLayout.NORTH);
        container.add(minePanel, BorderLayout.CENTER);
        */
        setVisible(true);
    }

    public void setScoreMoves(int x){
        scorePanel.setMoves(x);
    }

    public void setScoreBombs(int x){
        scorePanel.setBombs(x);
    }
}
