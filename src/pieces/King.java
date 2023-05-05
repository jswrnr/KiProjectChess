package pieces;

import chess.Field;

public class King extends Piece {
    public King(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        return this.white ? "K" : "k";
    }

    @Override
    public String[] legalMoves(Field[][] board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'legalMoves'");
    }
}
