/**
 * Created by kyle on 2/13/15.
 */
public class Game {
    int[][] board;
    int bombs;

    public static final char CLEARED = '0';
    public static final char UNCLEARED = '?';
    public static final char FLAGGED = 'F';

    public static final int EASY = 0;
    public static final int MEDIUM = 1;
    public static final int HARD = 2;
    public static final int BOMBASTIC = 3;
    public static final int CUSTOM = 4;

    public Game(int difficulty){
        makeBoard(difficulty);
    }

    public void makeBoard(int difficulty){
        switch(difficulty){
            case (EASY):
                board = new int[10][10];
                bombs = 5;
            case (MEDIUM):
                board = new int[10][10];
                bombs = 15;
            case (HARD):
                board = new int[25][25];
                bombs = 25;
            case (BOMBASTIC):
                board = new int[25][25];
                bombs = 50;
        }

    }

    public void printBoard(){
        for(int i = 0; i < board.length; i++){
            System.out.print((i + 1) + " ");
            for(int j = 0; j < board[i].length; j++){
                System.out.print("X" + " ");
            }
            System.out.println();
        }
    }

    public void placeMines(){

    }
}
