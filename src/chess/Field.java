package chess;
import pieces.Piece;

public class Field {
    private Piece piece;  

    public Field(Piece piece) {
        this.piece = piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece p) {
        this.piece = p;
    }

    @Override
    public String toString() {
        return isEmpty() ? "0" : piece.toString();
    }
}