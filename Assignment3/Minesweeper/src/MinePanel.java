import javax.swing.*;
import java.awt.*;

/**
 * Created by kyle on 2/23/15.
 */
public class MinePanel extends JPanel {
    JButton buttons[][];
    Game game;
    MineFrame mineFrame;

    MinePanel(Game game, MineFrame mineFrame){
        this.game = game;
        this.mineFrame = mineFrame;

        buttons = new JButton[game.gameBoard.tiles.length][game.gameBoard.tiles.length];
        setLayout(new GridLayout(game.gameBoard.tiles.length, game.gameBoard.tiles.length));
        for(int i = 0; i < game.gameBoard.tiles.length; i++){
            for(int j = 0; j < game.gameBoard.tiles.length; j++){
                JButton button;
                if(!game.gameBoard.tiles[i][j].isCover()){
                    button = new JButton("" + game.gameBoard.tiles[i][j].getBombsAround());
                } else if(game.gameBoard.tiles[i][j].isFlag()){
                    button = new JButton("F");
                    repaint();
                } else {
                    button = new JButton("X");
                    button.setBackground(Color.black);
                    button.setForeground(Color.WHITE);
                }

                button.setToolTipText(i + ", " + j);

                button.addMouseListener(new MouseHandler(game, buttons, this, mineFrame));

                buttons[i][j] = button;
            }
        }
        for(JButton[] buttonRow : buttons){
            for(JButton buttonCol : buttonRow){
                add(buttonCol);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(game.movesTaken > 0) {
            for (int i = 0; i < game.gameBoard.tiles.length; i++) {
                for (int j = 0; j < game.gameBoard.tiles.length; j++) {
                    if (game.gameBoard.tiles[i][j].isFlag()) { //
                        buttons[i][j].setText("F");
                        buttons[i][j].setBackground(Color.red);
                        buttons[i][j].setForeground(Color.white);
                    } else if (game.gameBoard.tiles[i][j].getBombsAround() == 0 && !game.gameBoard.tiles[i][j].isBomb()) {
                        buttons[i][j].setText(" ");
                        buttons[i][j].setBackground(Color.white);
                    } else if (!game.gameBoard.tiles[i][j].isCover() && game.gameBoard.tiles[i][j].getBombsAround() != 0) {
                        buttons[i][j].setText("" + game.gameBoard.tiles[i][j].getBombsAround());
                        buttons[i][j].setBackground(Color.black);
                    } else {
                        buttons[i][j].setText("X");
                    }
                }
            }
        }
    }
}
