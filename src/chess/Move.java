package chess;
import pieces.Piece;

public class Move {
    private Field from;
    private Field to;
    private Piece movingPiece;

    public Move(Field from, Field to, Piece movingPiece) {
        this.from = from;
        this.to = to;
        this.movingPiece = movingPiece;
    }

    public Field getFrom() {
        return from;
    }

    public Field getTo() {
        return to;
    }

    public Piece getMovingPiece() {
        return movingPiece;
    }

    @Override
    public String toString() {
        return from.toString() + to.toString();
    }
}
