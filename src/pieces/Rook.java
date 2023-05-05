package pieces;

import chess.Field;

public class Rook extends Piece {
    //if the rook has moved, it can't castle
    boolean hasMoved = false;

    public Rook(boolean white) {
        super(white);
        this.hasMoved = false;
    }

    @Override
    public String toString() {
        return this.white ? "R" : "r";
    }

    @Override
    public String[] legalMoves(Field[][] board) {
        return new String[] {};
    }
}
