package pieces;

import java.util.LinkedList;
import chess.Move;
import chess.Board;
public class King extends Piece {
    //if the king has moved, it can't castle
    boolean hasMoved = false;

    public King(boolean white) {
        super(white);
        this.hasMoved = false;
    }

    @Override
    public String toString() {
        return this.white ? "K" : "k";
    }

    @Override
    public LinkedList<Move> legalMoves(Board board, int x, int y) {
        return new LinkedList<Move>();
    }
}
