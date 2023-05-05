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
        Piece p;
        //takes a fen string and returns a 8x8 Field array with the pieces set according to the fen string
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
                    p = getPieceFromFenChar(c);
                    //looks stupid. fix later
                    board[i/8][i%8].setPiece(p);
                } catch (IncorrectFenException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return new Field[8][8];
    }

    private Piece getPieceFromFenChar(char c) throws IncorrectFenException {
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
}
