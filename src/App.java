import chess.GameManager;
//import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        //Scanner scanner = new Scanner(System.in);
        //String input = scanner.nextLine();
        String input = "1n1qkbnr/2pppppp/p7/p2P4/6Q1/8/PPPP1PPP/R1B1K1NR b KQ k- 0 6";
        GameManager gm = new GameManager(input);
        System.out.println(gm);
        gm.play();
}
}
