import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //new MineFrame();

        Game game = new Game(0);
        //this works!
        game.saveGame("/home/kyle/game.obj");

        game.loadGame("/home/kyle/game.obj");

        //TODO fix this
        //game.saveGame();
    }
}
