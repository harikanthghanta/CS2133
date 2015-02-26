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
            if(game.gameBoard.tiles[row][col].getBombsAround() == 0){
                game.clickTile(row, col);
                game.gameBoard.findBombsAround();
                game.gameBoard.clearSpacesAround(row, col);
                if(game.isLoser){
                    mineFrame.showNew(false);
                }
            } else {
                game.clickTile(row, col);
                game.gameBoard.findBombsAround();
                //game.gameBoard.clearSpacesAround(row, col);
                if(game.isLoser){
                    mineFrame.showNew(false);
                }
            }
        } else if(SwingUtilities.isRightMouseButton(e)){
            game.flagTile(row, col);
            game.gameBoard.findBombsAround();
            game.gameBoard.clearSpacesAround(row, col);
            if(game.gameBoard.checkWinner()){
                mineFrame.showNew(true);
            }
        }

        minePanel.repaint();

        System.out.println(row + ", " + col);
    }
}
