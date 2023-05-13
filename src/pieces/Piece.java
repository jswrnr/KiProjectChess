package pieces;

import chess.Board;
import chess.Move;

import java.util.LinkedList;

import Exceptions.IncorrectFenException;
public abstract class Piece {
    protected boolean white;
    protected boolean hasMoved = false;

    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return this.white;
    }

    public boolean hasMoved() {
        return this.hasMoved;
    }

    abstract public LinkedList<Move> legalMoves(Board board, int x, int y);

    public static Piece getPieceFromChar(char c) throws IncorrectFenException {
        //take a single character and return the corresponding piece
        switch (c) {
            case 'p':
                return new Pawn(false);
            case 'P':
                return new Pawn(true);
            case 'r':
                return new Rook(false);
            case 'R':
                return new Rook(true);
            case 'n':
                return new Knight(false);
            case 'N':
                return new Knight(true);
            case 'b':
                return new Bishop(false);
            case 'B':
                return new Bishop(true);
            case 'q':
                return new Queen(false);
            case 'Q':
                return new Queen(true);
            case 'k':
                return new King(false);
            case 'K':
                return new King(true);
            default:
                throw new IncorrectFenException("the provided character doesnt correspond to a piece");
        }
    }

}
