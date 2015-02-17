import java.util.Random;

/**
 * Created by kyle on 2/13/15.
 */

public class Game {
    Board gameBoard;

    /**
     * Creates the game object used to play, and places the bombs
     *
     * @param difficulty desired difficulty to pass to makeBoard
     */
    public Game(int difficulty){
        makeGameBoard(difficulty);
    }

    public void printGame(){
        gameBoard.printBoard();
    }

    public void makeGameBoard(int difficulty){
        Board gameBoard = new Board(difficulty);
    }

    public void printTile(int r, int c){
        System.out.println(gameBoard.getTile(r, c));
    }
}
