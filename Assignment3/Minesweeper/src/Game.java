import java.io.*;

/**
 * Created by kyle on 2/13/15.
 */

public class Game implements Serializable {
    Board gameBoard;
    int movesTaken = 0;
    int bombsRemaining = 0;
    boolean isWinner = false;
    boolean isLoser = false;

    /**
     * Creates the game object used to play, and places the bombs
     *
     * @param difficulty desired difficulty to pass to makeBoard
     */
    public Game(int difficulty){
        this.gameBoard = makeGameBoard(difficulty);
    }

    public void newGame(int difficulty){
        this.gameBoard = makeGameBoard(difficulty);
        this.calculateBombsRemaining();
        this.movesTaken = 0;
    }

    public void saveGame(){
        String filePath = "~/";
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
            outputStream.writeObject(this);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveGame(String filePath) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
            outputStream.writeObject(this);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flagTile(int r, int c){
        if(gameBoard.tiles[r][c].isFlag()){
            gameBoard.removeFlag(r, c);
        } else if(!gameBoard.tiles[r][c].isFlag()){
            gameBoard.setFlag(r, c);
        }
        moveTaken();
    }

    public void clickTile(int r, int c){
        if(gameBoard.tiles[r][c].isBomb()){
            System.out.println("Game Over");
            isLoser = true;
        } else if(gameBoard.tiles[r][c].isCover()){
            this.gameBoard.removeCover(r, c);
            this.gameBoard.clearSpacesAround(r, c);
        }
        moveTaken();
    }

    public void testBomb(int r, int c){
        this.gameBoard.tiles[r][c].setBomb(true);
    }

    public void clearBomb(int r, int c){
        this.gameBoard.tiles[r][c].setBomb(false);
    }

    public void moveTaken(){
        this.gameBoard.findBombsAround();
        this.movesTaken++;
        calculateBombsRemaining();
        isWinner = gameBoard.checkWinner();
        printGame();
    }

    public void printGame(){
        System.out.println("Move: " + this.movesTaken + "\n-------------------");
        gameBoard.printBoard();
        System.out.println();
    }

    public Board makeGameBoard(int difficulty){
        return new Board(difficulty);
    }

    public void printTile(int r, int c){
        System.out.println(gameBoard.getTile(r, c));
    }

    public void calculateBombsRemaining(){
        int temp = 0;
        for(int row = 0; row < this.gameBoard.tiles.length; row++) {
            for (int col = 0; col < this.gameBoard.tiles[row].length; col++) {
                if(this.gameBoard.tiles[row][col].isBomb() && this.gameBoard.tiles[row][col].isFlag()){
                    temp++;
                }
            }
        }

        bombsRemaining = gameBoard.bombs - temp;
    }
}
