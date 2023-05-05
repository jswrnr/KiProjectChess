import chess.Board;
//import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        //Scanner scanner = new Scanner(System.in);
        //String input = scanner.nextLine();
        String input = "8/8/r3k3/8/8/3K4/8/8 b - - 0 31";
        Board board = new Board(input);
        System.out.println(board);
}
}
