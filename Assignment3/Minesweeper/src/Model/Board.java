package Model;

import java.util.Random;

/**
 * Created by kyle on 2/15/15.
 */
public class Board {
    Tile[][] tiles;
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

    public int getBombs() {
        return bombs;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public Tile getTile(int r, int c){
        return tiles[r][c];
    }

    public void setFlag(int r, int c){
        tiles[r][c].setFlag(true);
    }

    public void removeFlag(int r, int c){
        tiles[r][c].setFlag(false);
    }

    public void setCover(int r, int c){
        tiles[r][c].setCover(true);
    }

    public void removeCover(int r, int c){
        tiles[r][c].setCover(false);
    }

    /**
     * Creates the game tiles consisting of a two dimensional array.
     * Also sets the class variables of number of bombs and debugging variables.
     *
     * @param difficulty the desired difficulty of the game checked against constants
     */
    public void makeBoard(int difficulty){
        switch(difficulty){
            case EASY:
                tiles = new Tile[10][10];
                bombs = 5;
                gameDifficulty = EASY;
                break;
            case MEDIUM:
                tiles = new Tile[10][10];
                bombs = 15;
                gameDifficulty = MEDIUM;
                break;
            case HARD:
                tiles = new Tile[25][25];
                bombs = 25;
                gameDifficulty = HARD;
                break;
            case BOMBASTIC:
                tiles = new Tile[25][25];
                bombs = 50;
                gameDifficulty = BOMBASTIC;
                break;
            default:
                tiles = new Tile[10][10];
                bombs = 5;
                gameDifficulty = EASY;
                break;
        }
        for(int r = 0; r < tiles.length; r++){
            for(int c = 0; c < tiles[r].length; c++){
                tiles[r][c] = new Tile();
            }
        }
    }

    /**
     * pints the tiles to the command line. Used for the CLI version of the game.
     *
     * TODO impliment a formatted version of the printout that prints the tiles within a numbered grid
     */
    public void printBoard(){
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                if (tiles[i][j].isBomb()) {
                    System.out.print("B ");
                } else if(tiles[i][j].isFlag()){
                    System.out.print("F ");
                } else if(!tiles[i][j].isCover()){
                    System.out.print(tiles[i][j].getBombsAround() + " ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Places the desired number of bombs on random squares of the tiles.
     */
    public void placeBombs(){
        for(int i = 0; i < this.bombs; i++){
            Random random = new Random();
            int r = random.nextInt(tiles.length);
            int c = random.nextInt(tiles[r].length);

            if(!tiles[r][c].isBomb()){
                tiles[r][c].setBomb(true);
            } else {
                i--;
            }
        }
    }

    public void clearBombsAround(){
        for (int r = 0; r < this.tiles.length; r++){
            for (int c = 0; c < this.tiles[r].length; c++){
                this.tiles[r][c].setBombsAround(0);
            }
        }
    }

    public void findBombsAround(){
        clearBombsAround();

        //loop through all the tiles
        for(int row = 0; row < this.tiles.length; row++){
            for(int col = 0; col < this.tiles[row].length; col++){
                //if we find a bomb, mak the tiles around it
                if(!this.tiles[row][col].isBomb()){
                    int count = 0;

                    //loop through all the tiles adjacent to the bomb
                    //TODO refactor this as a new method to clear all the tiles around the one clicked
                    for(int x = row - 1; x <= row + 1; x++){
                        for(int y = col - 1; y <= col + 1; y++){
                            if(x >= 0 && x < tiles.length && y >= 0 && y < tiles[row].length){
                                if(tiles[x][y].isBomb()){
                                    count++;
                                }
                            }
                        }
                    }
                    tiles[row][col].setBombsAround(count);
                }
            }
        }
    }

    public void clearSpacesAround(int row, int col) {
        for(int x = row - 1; x <= row + 1; x++){
            for(int y = col - 1; y <= col + 1; y++){
                if(x >= 0 && x < tiles.length && y >= 0 && y < tiles[row].length){
                    if(!tiles[x][y].isBomb() && tiles[x][y].isCover()){
                        tiles[x][y].setCover(false);
                        clearSpacesAround(x, y);
                    }
                }
            }
        }
    }
}
