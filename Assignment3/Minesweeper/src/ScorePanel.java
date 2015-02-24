import javax.swing.*;
import java.awt.*;

/**
 * Created by kyle on 2/24/15.
 */
public class ScorePanel extends JPanel {
    private JLabel bombsRemaining, movesTaken, bombImage;
    private int bombs, moves;
    private Image im;

    ScorePanel(Game game){
        bombs = game.gameBoard.bombs;
        moves = game.movesTaken;

        bombsRemaining = new JLabel("Bombs Remaining: " + game.gameBoard.bombs);
        movesTaken = new JLabel("Moves Taken: " + game.movesTaken);

        bombImage = new JLabel();


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        im = toolkit.getImage("assets/simple_bomb.png");
        im = im.getScaledInstance(20, 20, 0);

        ImageIcon imageIcon = new ImageIcon(im);

        bombImage.setIcon(imageIcon);


        add(bombsRemaining);
        add(bombImage);
        add(movesTaken);
    }

    public void setBombs(int bombs) {
        this.bombs = bombs;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        bombsRemaining.setText("Bombs Remaining: " + bombs);
        movesTaken.setText("Moves Taken: " + moves);
        repaint();
    }
}
