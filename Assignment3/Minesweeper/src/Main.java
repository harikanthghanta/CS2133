public class Main {

    public static void main(String[] args) {
        Game game1 = new Game(1);
        game1.printGame();

        game1.flagTile(1, 1);


        game1.testBomb(0, 1);
        game1.testBomb(1, 0);

        game1.testBomb(0, 9);
        game1.testBomb(1, 9);
        game1.testBomb(0, 8);
        game1.testBomb(1, 8);

        game1.clickTile(0, 0);

        game1.clearBomb(0 ,9);
        game1.clearBomb(1 ,9);
        game1.clearBomb(0 ,8);
        game1.clearBomb(1 ,8);

        game1.clickTile(0, 9);

        MineFrame mineFrame = new MineFrame(game1.gameBoard);
    }
}
