import java.util.Random;

/**
 * Created by kyle on 2/13/15.
 */

public class Game {

    /**
     * Creates the game object used to play, and places the bombs
     *
     * @param difficulty desired difficulty to pass to makeBoard
     */
    public Game(int difficulty){
        Board board = new Board(difficulty);
        board.placeBombs();
        board.printBoard();
    }
}
