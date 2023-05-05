public class Board {
    Field[][] board;

    public Board () {
        this(null);
    }

    public Board (String fen) {

        if (fen != null) {
            this.board = createBoardFromFen(fen);
        } else {
            this.board = new Field[8][8];
        }
    }

    private Field[][] createBoardFromFen(String fen) {
        return new Field[8][8];
    }
}
