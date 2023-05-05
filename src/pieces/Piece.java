package pieces;

import chess.Field;
public abstract class Piece {
    private boolean isWhite;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    abstract public String[] legalMoves(Field[][] board);
}
