package chess;
import pieces.Piece;

public class Field {
    private int x;
    private int y;
    private Piece piece;  

    public Field(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
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
}
