package pieces;

import java.util.LinkedList;
import chess.Board;
import chess.Move;

public class Queen extends Piece {
    public Queen(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        return this.white ? "Q" : "q";
    }

    @Override
    public LinkedList<Move> legalMoves(Board board, int x, int y) {
        return new LinkedList<Move>();
    }
}
