import java.util.Random;

/**
 * Created by kyle on 2/13/15.
 */
//TODO make board class that contains tiles, game that handles play logic
public class Game {
    //TODO replace the int array with an array of tiles that contain bombs, flags, ets
    int[][] board;

    int bombs;
    int gameDifficulty;

    public String difficultyPrintout;

    public static final char CLEARED = '0';
    public static final char UNCLEARED = '?';
    public static final char FLAGGED = 'F';

    //difficulty constants
    public static final int EASY = 1;
    public static final int MEDIUM = 2;
    public static final int HARD = 3;
    public static final int BOMBASTIC = 4;

    //grid identifiers
    public static final int EMPTY = 0;
    public static final int BOMB = 1;

    /**
     * Creates the game object used to play, and places the bombs
     *
     * @param difficulty desired difficulty to pass to makeBoard
     */
    public Game(int difficulty){
        makeBoard(difficulty);
        this.placeBombs();
    }

    /**
     * Creates the game board consisting of a two dimensional array.
     * Also sets the class variables of number of bombs and debugging variables.
     *
     * @param difficulty the desired difficulty of the game checked against constants
     */
    public void makeBoard(int difficulty){
        switch(difficulty){
            case EASY:
                board = new int[10][10];
                bombs = 5;
                difficultyPrintout = "EASY";
                gameDifficulty = EASY;
                break;
            case MEDIUM:
                board = new int[10][10];
                bombs = 15;
                difficultyPrintout = "MEDIUM";
                gameDifficulty = MEDIUM;
                break;
            case HARD:
                board = new int[25][25];
                bombs = 25;
                difficultyPrintout = "HARD";
                gameDifficulty = HARD;
                break;
            case BOMBASTIC:
                board = new int[25][25];
                bombs = 50;
                difficultyPrintout = "BOMBASTIC";
                gameDifficulty = BOMBASTIC;
                break;
            default:
                board = new int[10][10];
                bombs = 5;
                difficultyPrintout = "EASY";
                gameDifficulty = EASY;
                break;
        }
    }

    /**
     * pints the board to the command line. Used for the CLI version of the game.
     *
     * TODO impliment a formatted version of the printout that prints the board within a numbered grid
     */
    public void printBoard(){
        int bombCount = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1) {
                    System.out.print("B" + " ");
                    bombCount++;
                } else {
                    System.out.print("X" + " ");
                }
            }
            System.out.println();
        }
        System.out.println("bomb count of level is " + bombCount);
    }

    /**
     * Places the desired number of bombs on random squares of the board.
     */
    public void placeBombs(){
        for(int i = 0; i < this.bombs; i++){
            Random random = new Random();
            int r = random.nextInt(board.length);
            int c = random.nextInt(board[r].length);

            if(board[r][c] == 0){
                board[r][c] = 1;
            } else {
                i--;
            }
        }
    }
}
