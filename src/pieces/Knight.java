package pieces;

import chess.Field;

public class Knight extends Piece {

    private boolean hasMoved;

    public Knight(boolean white) {
        super(white);
        this.hasMoved = false;
    }

    @Override
    public String[] legalMoves(Field[][] board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'legalMoves'");
    }
}
