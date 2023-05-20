package chess;

public class Move {
    private int[] from;
    private int[] to;
    private char movingPiece;

    public Move(int[] from, int[] to, char movingPiece) {
        this.from = from;
        this.to = to;
        this.movingPiece = movingPiece;
    }

    public int[] getFrom() {
        return from;
    }

    public int[] getTo() {
        return to;
    }

    public char getPiece() {
        return movingPiece;
    }

    @Override
    public String toString() {
        return movingPiece + " [" + from[0] + ", " + from[1] + "] [" + to[0] + ", " + to[1] + "]";
    }
}
