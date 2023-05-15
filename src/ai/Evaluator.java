package ai;
import chess.Move;

public class Evaluator {
    public Move chooseMove(Move[] moves) {
        //chose a move from the list of moves
        //this is where the AI will be implemented
        return moves[(int) (Math.random() * moves.length)];
    }
}
