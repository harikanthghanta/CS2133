public class Main {

    public static void main(String[] args) {
        Game game1 = new Game(1);
        //game1.printTile(1, 2);
        game1.printGame();

        game1.flagTile(1, 1);
        game1.printGame();

        game1.clickTile(0, 0);
        game1.printGame();
    }
}
