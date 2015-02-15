import java.util.Random;

/**
 * Created by kyle on 2/15/15.
 */
public class Board {
    Tile[][] board;
    int bombs;
    int gameDifficulty;

    //difficulty constants
    public static final int EASY = 1;
    public static final int MEDIUM = 2;
    public static final int HARD = 3;
    public static final int BOMBASTIC = 4;

    public Board(int gameDifficulty) {
        makeBoard(gameDifficulty);
        this.placeBombs();
    }

    public void makeBoard(int difficulty){
        switch(difficulty){
            case EASY:
                board = new Tile[10][10];
                bombs = 5;
                gameDifficulty = EASY;
                break;
            case MEDIUM:
                board = new Tile[10][10];
                bombs = 15;
                gameDifficulty = MEDIUM;
                break;
            case HARD:
                board = new Tile[25][25];
                bombs = 25;
                gameDifficulty = HARD;
                break;
            case BOMBASTIC:
                board = new Tile[25][25];
                bombs = 50;
                gameDifficulty = BOMBASTIC;
                break;
            default:
                board = new Tile[10][10];
                bombs = 5;
                gameDifficulty = EASY;
                break;
        }
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                board[r][c] = new Tile();
            }
        }
    }

    public void printBoard(){
        int bombCount = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if (board[i][j].isBomb()) {
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

    public void placeBombs(){
        for(int i = 0; i < this.bombs; i++){
            Random random = new Random();
            int r = random.nextInt(board.length);
            int c = random.nextInt(board[r].length);

            if(!board[r][c].isBomb()){
                board[r][c].setBomb(true);
            } else {
                i--;
            }
        }
    }
}
