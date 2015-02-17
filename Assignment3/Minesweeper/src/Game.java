import java.util.Random;

/**
 * Created by kyle on 2/13/15.
 */

public class Game {
    Board gameBoard;
    int movesTaken = 0;

    /**
     * Creates the game object used to play, and places the bombs
     *
     * @param difficulty desired difficulty to pass to makeBoard
     */
    public Game(int difficulty){
        this.gameBoard = makeGameBoard(difficulty);
    }

    public void flagTile(int r, int c){
        if(gameBoard.tiles[r][c].isFlag()){
            gameBoard.removeFlag(r, c);
            moveTaken();
        } else if(!gameBoard.tiles[r][c].isFlag()){
            gameBoard.setFlag(r, c);
            moveTaken();
        } else {
            System.out.println("Null tile");
        }
    }

    public void clickTile(int r, int c){
        if(gameBoard.tiles[r][c].isBomb()){
            System.out.println("Game Over");
            System.exit(0);
        } else if(gameBoard.tiles[r][c].isCover()){
            this.gameBoard.removeCover(r, c);
        }
    }

    public void moveTaken(){
        this.movesTaken++;
    }

    public void printGame(){
        System.out.println("Move: " + this.movesTaken + "\n-------------------\n");
        gameBoard.printBoard();
    }

    public Board makeGameBoard(int difficulty){
        return new Board(difficulty);
    }

    public void printTile(int r, int c){
        System.out.println(gameBoard.getTile(r, c));
    }
}
