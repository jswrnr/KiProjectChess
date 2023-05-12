package pieces;

import chess.Move;
import java.util.LinkedList;
import chess.Board;

public class Bishop extends Piece {
    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        return this.white ? "B" : "b";
    }

    @Override
    public LinkedList<Move> legalMoves(Board board, int x, int y) {
        return new LinkedList<Move>();
    }
}
