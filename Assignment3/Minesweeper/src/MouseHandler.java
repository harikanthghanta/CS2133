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

    public MouseHandler(Game game, JButton[][] buttons, MinePanel minePanel){
        this.game = game;
        this.buttons = buttons;
        this.minePanel = minePanel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        JButton button = (JButton) e.getSource();

        String[] getParams = button.getToolTipText().split(", ");
        int row = Integer.parseInt(getParams[0]);
        int col = Integer.parseInt(getParams[1]);

        //TODO change action based on left and right click
        //TODO take action on specific tile based on click location

        if(SwingUtilities.isLeftMouseButton(e)){
            game.clickTile(row, col);
        } else if(SwingUtilities.isRightMouseButton(e)){
            game.flagTile(row, col);
        }

        minePanel.repaint();
        System.out.println(row + ", " + col);
    }
}
