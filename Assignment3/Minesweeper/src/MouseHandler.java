import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by kyle on 2/25/15.
 */
public class MouseHandler extends MouseAdapter {
    Game game;
    JButton[][] buttons;
    MinePanel minePanel;
    ScorePanel scorePanel;

    public MouseHandler(Game game, JButton[][] buttons){
        this.game = game;
        this.buttons = buttons;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        JButton button = (JButton) e.getSource();

        String[] getParams = button.getToolTipText().split(", ");
        int row = Integer.parseInt(getParams[0]);
        int col = Integer.parseInt(getParams[1]);

        System.out.println(row + ", " + col);

    }
}
