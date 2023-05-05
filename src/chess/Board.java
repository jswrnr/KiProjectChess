package chess;
import pieces.*;
import Exceptions.IncorrectFenException;
public class Board {
    private Field[][] board;

    public Board () {
        this(null);
    }

    public Board (String fen) {

        // initialize the board with empty Fields
        this.board = createDefaultBoard();

        if (fen != null) {
            this.board = createBoardFromFen(fen);
        }
    }

    // return a 8x8 Field array with all piece values set to null
    private Field[][] createDefaultBoard() {
        Field[][] board = new Field[8][8];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Field(i, j, null);
            }
        }
        return board;
    } 

    private Field[][] createBoardFromFen(String fen) {
        //split fen string so we only use the part that describes the pieces
        Field[][] board = createDefaultBoard();
        System.out.println(fen);
        fen = fen.split(" ")[0];
        //take the fen string and replace every number with the corresponding amount of empty fields
        fen = fen.replaceAll("1", "0");
        fen = fen.replaceAll("2", "00");
        fen = fen.replaceAll("3", "000");
        fen = fen.replaceAll("4", "0000");
        fen = fen.replaceAll("5", "00000");
        fen = fen.replaceAll("6", "000000");
        fen = fen.replaceAll("7", "0000000");
        fen = fen.replaceAll("8", "00000000");
        //remove all slashes
        fen = fen.replaceAll("/", "");
        Piece p;
        //takes a fen string and returns a 8x8 Field array with the pieces set according to the fen string
        int x, y;
        for (int i = 0; i < fen.length(); i++) {
            char c = fen.charAt(i);
            if (c == '/') {
                // skip to next line
                continue;
            } else if (Character.isDigit(c)) {
                // skip the number of empty fields
                continue;
            } else {
                // set the piece on the board
                try {
                    y = i % 8;
                    //if i is less than 8, we are on the first line, so we dont need to divide by 8
                    //if i is greater than 8, we need to divide by 8 to get the correct line
                    x = i>8 ? (i-y) / 8 : 0;
                    p = getPieceFromFenChar(c, x, y);
                    //looks stupid. fix later
                    board[x][y].setPiece(p);
                } catch (IncorrectFenException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return board;
    }

    private Piece getPieceFromFenChar(char c, int x, int y) throws IncorrectFenException {
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

    public Field[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        String s = "";
        for (Field[] row : board) {
            for (Field f : row) {
                s += f.toString();
            }
            s += "\n";
        }
        return s;
    }
}
