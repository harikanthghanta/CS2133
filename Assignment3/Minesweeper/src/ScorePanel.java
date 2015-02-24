import javax.swing.*;
import java.awt.*;

/**
 * Created by kyle on 2/24/15.
 */
public class ScorePanel extends JPanel {
    ScorePanel(Game game){
        JLabel bombsRemaining = new JLabel("Bombs Remaining: " + game.gameBoard.bombs);
        JLabel movesTaken = new JLabel("Moves Taken: " + game.movesTaken);

        JLabel bombImage = new JLabel();


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image im = toolkit.getImage("assets/simple_bomb.png");
        im = im.getScaledInstance(20, 20, 0);

        ImageIcon imageIcon = new ImageIcon(im);

        bombImage.setIcon(imageIcon);


        add(bombsRemaining);
        add(bombImage);
        add(movesTaken);
    }
}
