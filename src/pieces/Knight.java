package pieces;

import chess.Move;
import java.util.LinkedList;
import chess.Board;
public class Knight extends Piece {

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        return this.white ? "N" : "n";
    }

    @Override
    public LinkedList<Move> legalMoves(Board board, int x, int y) {
        return new LinkedList<Move>();
    }
}
