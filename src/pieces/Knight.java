package pieces;

import chess.Field;

public class Knight extends Piece {

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        return this.white ? "N" : "n";
    }

    @Override
    public String[] legalMoves(Field[][] board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'legalMoves'");
    }
}
