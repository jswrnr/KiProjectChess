package pieces;

import chess.Field;

public class Rook extends Piece {
    public Rook(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        return this.white ? "R" : "r";
    }

    @Override
    public String[] legalMoves(Field[][] board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'legalMoves'");
    }
}
