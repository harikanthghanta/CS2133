import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kyle on 2/23/15.
 *
 * The frame that contains the panels representing the game state.
 */
public class MineFrame extends JFrame {
    private static long serialVersionUID = -5061264484551653426L;

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
    public static final int SAVE = 100;
    public static final int LOAD = 101;

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

        game.isLoser = false;
        game.isWinner = false;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image im = toolkit.getImage("assets/simple_bomb.png");
        im = im.getScaledInstance(20, 20, 0);

        ImageIcon imageIcon = new ImageIcon(im);

        Object[] setValue = {"EASY", "MEDIUM", "HARD", "BOMBASTIC", "QUIT"};

        String message = "";
        String title = "";
        if(won){
            title = "Winner!";
            message = "You win! Pick a difficulty to start a new game.";
        } else if(!won){
            title = "Loser!";
            message = "Pick a difficulty to start a new game, or maybe just quit";
        } else {
            title = "New Game";
            message = "Pick a difficulty to start a new game.";
        }

        int difficlty = JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, imageIcon, setValue, setValue[1]);

        switch (difficlty){
            case EASY:
                System.out.println("EASY");
                game.newGame(EASY);
                break;
            case MEDIUM:
                System.out.println("MEDIUM");
                game.newGame(MEDIUM);
                break;
            case HARD:
                System.out.println("HARD");
                game.newGame(HARD);
                break;
            case BOMBASTIC:
                System.out.println("BOMBASTIC");
                game.newGame(BOMBASTIC);
                break;
            default:
                System.out.println("EASY");
                game.newGame(EASY);
                break;
        }

        refreshGame();
    }

    public void newGame(int difficulty){
        switch (difficulty){
            case EASY:
                System.out.println("EASY");
                game.newGame(EASY);
                break;
            case MEDIUM:
                System.out.println("MEDIUM");
                game.newGame(MEDIUM);
                break;
            case HARD:
                System.out.println("HARD");
                game.newGame(HARD);
                break;
            case BOMBASTIC:
                System.out.println("BOMBASTIC");
                game.newGame(BOMBASTIC);
                break;
            default:
                System.out.println("EASY");
                game.newGame(EASY);
                break;
        }

        refreshGame();
    }

    private JMenuBar getMenu(){
        JMenuBar jMenuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu gameMenu = new JMenu("Game");

        JMenuItem easyItem = new JMenuItem("EASY");
        JMenuItem mediumItem = new JMenuItem("MEDIUM");
        JMenuItem hardItem = new JMenuItem("HARD");
        JMenuItem bombasticItem = new JMenuItem("BOMBASTIC");

        easyItem.addActionListener(new MenuListener(EASY));
        mediumItem.addActionListener(new MenuListener(MEDIUM));
        hardItem.addActionListener(new MenuListener(HARD));
        bombasticItem.addActionListener(new MenuListener(BOMBASTIC));

        JMenuItem saveGame = new JMenuItem("SAVE");
        JMenuItem loadGame = new JMenuItem("LOAD");

        saveGame.addActionListener(new MenuListener(SAVE));
        loadGame.addActionListener(new MenuListener(LOAD));

        fileMenu.add(saveGame);
        fileMenu.add(loadGame);

        gameMenu.add(easyItem);
        gameMenu.add(mediumItem);
        gameMenu.add(hardItem);
        gameMenu.add(bombasticItem);

        jMenuBar.add(fileMenu);
        jMenuBar.add(gameMenu);

        return jMenuBar;
    }

    private class MenuListener implements ActionListener {
        int action;

        MenuListener(int action){
            this.action = action;
        }

        public void actionPerformed(ActionEvent e) {
            switch (action){
                case EASY:
                    System.out.println("EASY");
                    newGame(EASY);
                    break;
                case MEDIUM:
                    newGame(MEDIUM);
                    System.out.println("MEDIUM");
                    break;
                case HARD:
                    newGame(HARD);
                    System.out.println("HARD");
                    break;
                case BOMBASTIC:
                    newGame(BOMBASTIC);
                    System.out.println("BOMBASTIC");
                    break;
                case SAVE:
                    fileOptions(SAVE);
                    System.out.println("SAVE");
                    break;
                case LOAD:
                    fileOptions(LOAD);
                    System.out.println("LOAD");
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }

        }
    }

    public void fileOptions(int action){
        if(action == SAVE){
            String filePath = "";
            JFileChooser jFileChooser = new JFileChooser();
            int returnVal = jFileChooser.showSaveDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION){
                filePath = jFileChooser.getSelectedFile().getPath();
                game.saveGame(filePath);
                refreshGame();
            } else {
                System.out.println("Save canceled");
            }
        } else if(action == LOAD){
            String filePath = "";
            JFileChooser jFileChooser = new JFileChooser();
            int returnVal = jFileChooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION){
                filePath = jFileChooser.getSelectedFile().getPath();
                game.loadGame(filePath);
                refreshGame();
            } else {
                System.out.println("Load canceled");
            }
        }
    }

    public void refreshGame(){
        mainContainer.remove(scorePanel);
        mainContainer.remove(minePanel);

        scorePanel = new ScorePanel(game);
        scorePanel.game = this.game;
        scorePanel.paintComponent(getGraphics());

        minePanel = new MinePanel(game, this);
        minePanel.game = this.game;
        minePanel.paintComponent(getGraphics());

        mainContainer.add(scorePanel, BorderLayout.NORTH);
        mainContainer.add(minePanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
