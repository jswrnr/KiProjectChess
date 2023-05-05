package pieces;

import chess.Field;

public class Queen extends Piece {
    public Queen(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        return this.white ? "Q" : "q";
    }

    @Override
    public String[] legalMoves(Field[][] board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'legalMoves'");
    }
}
