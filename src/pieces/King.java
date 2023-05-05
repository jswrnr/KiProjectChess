package pieces;

import chess.Field;
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
    public String[] legalMoves(Field[][] board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'legalMoves'");
    }
}
