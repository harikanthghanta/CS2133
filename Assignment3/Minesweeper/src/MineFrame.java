import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    Container container;
    Container mainContainer;

    //difficulty constants
    public static final int EASY = 1;
    public static final int MEDIUM = 2;
    public static final int HARD = 3;
    public static final int BOMBASTIC = 4;

    MineFrame(){
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        container = getContentPane();
        container.setLayout(new BorderLayout());


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

        scorePanel = new ScorePanel(game);
        minePanel = new MinePanel(game, this);

        container.add(getMenu(), BorderLayout.NORTH);

        mainContainer = new Container();
        mainContainer.setLayout(new BorderLayout());



        mainContainer.add(scorePanel, BorderLayout.NORTH);
        mainContainer.add(minePanel, BorderLayout.CENTER);

        container.add(mainContainer);

        setVisible(true);
    }

    public void showNew(boolean won){
        Container container = getContentPane();

        game.isLoser = false;
        game.isWinner = false;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image im = toolkit.getImage("assets/simple_bomb.png");
        im = im.getScaledInstance(20, 20, 0);

        ImageIcon imageIcon = new ImageIcon(im);

        Object[] setValue = {"EASY", "MEDIUM", "HARD", "BOMBASTIC", "QUIT"};

        String message = "";
        if(won){
            message = "You win! Pick a difficulty to start a new game.";
        } else if(!won){
            message = "Pick a difficulty to start a new game, or maybe just quit";
        } else {
            message = "Pick a difficulty to start a new game.";
        }

        int difficlty = JOptionPane.showOptionDialog(null, message, "New Game", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, imageIcon, setValue, setValue[1]);

        switch (difficlty){
            case 0:
                System.out.println("EASY");
                game.newGame(EASY);
                break;
            case 1:
                System.out.println("MEDIUM");
                game.newGame(MEDIUM);
                break;
            case 2:
                System.out.println("HARD");
                game.newGame(HARD);
                break;
            case 3:
                System.out.println("BOMBASTIC");
                game.newGame(BOMBASTIC);
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("EASY");
                game.newGame(EASY);
                break;
        }

        mainContainer.remove(scorePanel);
        mainContainer.remove(minePanel);

        scorePanel = new ScorePanel(game);
        minePanel = new MinePanel(game, this);

        mainContainer.add(scorePanel, BorderLayout.NORTH);
        mainContainer.add(minePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    //TODO finish this menu
    private JMenuBar getMenu(){
        JMenuBar jMenuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu gameMemu = new JMenu("Game");

        jMenuBar.add(fileMenu);
        jMenuBar.add(gameMemu);

        return jMenuBar;
    }

    private class MenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

    public void setScoreMoves(int x){
        scorePanel.setMoves(x);
    }

    public void setScoreBombs(int x){
        scorePanel.setBombs(x);
    }
}
