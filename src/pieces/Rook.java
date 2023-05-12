package pieces;

import java.util.LinkedList;
import chess.Board;
import chess.Move;

public class Rook extends Piece {
    //if the rook has moved, it can't castle
    boolean hasMoved = false;

    public Rook(boolean white) {
        super(white);
        this.hasMoved = false;
    }

    @Override
    public String toString() {
        return this.white ? "R" : "r";
    }

    @Override
    public LinkedList<Move> legalMoves(Board board, int x, int y) {
        return new LinkedList<Move>();
    }
}
