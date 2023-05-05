package chess;

public class Move {
    private Field from;
    private Field to;

    public Move(Field from, Field to) {
        this.from = from;
        this.to = to;
    }

    public Field getFrom() {
        return from;
    }

    public Field getTo() {
        return to;
    }

    @Override
    public String toString() {
        return from.toString() + to.toString();
    }
}
