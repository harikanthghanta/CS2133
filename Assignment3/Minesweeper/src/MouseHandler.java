import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by kyle on 2/25/15.
 */
public class MouseHandler extends MouseAdapter {
    Game game;
    JButton[][] buttons;
    MinePanel minePanel;
    MineFrame mineFrame;


    public MouseHandler(Game game, JButton[][] buttons, MinePanel minePanel, MineFrame mineFrame){
        this.game = game;
        this.buttons = buttons;
        this.minePanel = minePanel;
        this.mineFrame = mineFrame;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        JButton button = (JButton) e.getSource();

        String[] getParams = button.getToolTipText().split(", ");
        int row = Integer.parseInt(getParams[0]);
        int col = Integer.parseInt(getParams[1]);

        if(SwingUtilities.isLeftMouseButton(e)){
            game.clickTile(row, col);
            if(game.isLoser){
                mineFrame.showLoser();
            }
        } else if(SwingUtilities.isRightMouseButton(e)){
            game.flagTile(row, col);
            if(game.gameBoard.checkWinner()){

                mineFrame.showWinner();
            }
        }

        minePanel.repaint();

        System.out.println(row + ", " + col);
    }
}
