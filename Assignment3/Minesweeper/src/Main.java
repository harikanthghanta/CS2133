public class Main {

    public static void main(String[] args) {
        Game game1 = new Game(1);
        System.out.println("\n" + game1.difficultyPrintout + "\n");
        game1.printBoard();

        Game game2 = new Game(2);
        System.out.println("\n" + game2.difficultyPrintout + "\n");
        game2.printBoard();

        Game game3 = new Game(3);
        System.out.println("\n" + game3.difficultyPrintout + "\n");
        game3.printBoard();

        Game game4 = new Game(4);
        System.out.println("\n" + game4.difficultyPrintout + "\n");
        game4.printBoard();

        Board board1 = new Board(1);
        board1.printBoard();

        Board board2 = new Board(2);
        board2.printBoard();
    }
}
