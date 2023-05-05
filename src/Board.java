public class Board {
    private Field[][] board;

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
        //todo: create a board from a fen string
        return new Field[8][8];
    }

    public Field[][] getBoard() {
        return board;
    }
}
