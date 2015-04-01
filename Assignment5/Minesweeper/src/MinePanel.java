import javax.swing.*;
import java.awt.*;

/**
 * Created by kyle on 2/23/15.
 *
 * The panel containing the grid of buttons representing the tiles.
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
                    button = new JButton("");
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

        for (int i = 0; i < game.gameBoard.tiles.length; i++) {
            for (int j = 0; j < game.gameBoard.tiles.length; j++) {
                //Flags have to be red and print an F
                //Covered Spaces are black
                //uncovered spaces are white unless they have a bombs around > 0

                //flag is highest precidence
                if(game.gameBoard.tiles[i][j].isFlag()){
                    buttons[i][j].setText("F");
                    buttons[i][j].setBackground(Color.RED);
                    buttons[i][j].setForeground(Color.black);
                }
                //check if it's covered
                else if(!game.gameBoard.tiles[i][j].isCover()){

                    game.gameBoard.findBombsAround();


                    if(game.gameBoard.tiles[i][j].getBombsAround() > 0){
                        buttons[i][j].setText("" + game.gameBoard.tiles[i][j].getBombsAround());
                        buttons[i][j].setForeground(Color.white);
                        buttons[i][j].setBackground(Color.blue);
                    } else {
                        buttons[i][j].setText("" + game.gameBoard.tiles[i][j].getBombsAround());
                        buttons[i][j].setForeground(Color.white);
                        buttons[i][j].setBackground(Color.white);
                    }



                }
                //if it's covered, keep it black

                else if(game.gameBoard.tiles[i][j].isCover()){
                    buttons[i][j].setBackground(Color.black);
                    buttons[i][j].setText("");
                }

                //just to test
                /*
                if(game.gameBoard.tiles[i][j].isBomb()){
                    buttons[i][j].setText("B");
                    buttons[i][j].setBackground(Color.YELLOW);
                    buttons[i][j].setForeground(Color.black);
                }
                */
            }
        }

    }
}
