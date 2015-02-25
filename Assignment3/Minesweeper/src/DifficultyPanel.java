import javax.swing.*;
import java.awt.*;

/**
 * Created by kyle on 2/24/15.
 */
public class DifficultyPanel extends JPanel {
    JButton easyButton, mediumButton, hardButton, bombasticButton;
    JLabel messageLabel;

    DifficultyPanel(){
        messageLabel = new JLabel("Select a difficulty.");

        add(messageLabel);

        easyButton = new JButton("EASY");
        mediumButton = new JButton("MEDIUM");
        hardButton = new JButton("HARD");
        bombasticButton = new JButton("BOMBASTIC");

        add(easyButton);
        add(mediumButton);
        add(hardButton);
        add(bombasticButton);
    }
}
