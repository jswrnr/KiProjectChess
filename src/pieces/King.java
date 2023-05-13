package pieces;

import java.util.LinkedList;
import chess.Move;
import chess.Board;
public class King extends Piece {

    public King(boolean white) {
        super(white);
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
