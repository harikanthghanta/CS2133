import javax.swing.*;
import java.awt.*;

/**
 * Created by kyle on 2/23/15.
 */
public class MinePanel extends JPanel {
    JButton buttons[][];

    MinePanel(Board board){
        buttons = new JButton[board.tiles.length][board.tiles.length];
        setLayout(new GridLayout(board.tiles.length, board.tiles.length));
        for(int i = 0; i < board.tiles.length; i++){
            for(int j = 0; j < board.tiles.length; j++){
                JButton button = new JButton("Button " + i + ", " + j);
                buttons[i][j] = button;
            }
        }
        for(JButton[] buttonRow : buttons){
            for(JButton buttonCol : buttonRow){
                add(buttonCol);
            }
        }
    }
}
