package pieces;

import chess.Field;
public abstract class Piece {
    protected boolean white;

    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return this.white;
    }

    abstract public String[] legalMoves(Field[][] board);
}
