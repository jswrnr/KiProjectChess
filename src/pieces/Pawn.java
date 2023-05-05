package pieces;

import chess.Field;

public class Pawn extends Piece {
    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        return this.white ? "P" : "p";
    }

    @Override
    public String[] legalMoves(Field[][] board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'legalMoves'");
    }
}
