public class Main {

    public static void main(String[] args) {
        Game game1 = new Game(1);
        game1.printGame();

        game1.flagTile(1, 1);
        //game1.printGame();

        game1.testBomb(0, 1);
        game1.testBomb(1, 0);

        game1.clickTile(0, 0);
        //game1.printGame();
    }
}
