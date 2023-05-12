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
        this.board = createEmptyBoard();
        // if a fen string is provided, set the pieces on the board according to the fen string
        // if no fen string is provided, the board will be initialized with the default starting position
        this.board = fillBoardWithFen(fen, this.board);
    }

    // return a 8x8 Field array with all piece values set to null
    private Field[][] createEmptyBoard() {
        Field[][] board = new Field[8][8];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Field(i, j, null);
            }
        }
        return board;
    } 

    private Field[][] fillBoardWithFen(String fen, Field[][] board) {
        //if no fen string is provided, use the default starting position
        if (fen == null) {
            fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
        }
        //split fen string so we only use the part that describes the pieces
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
                    p = Piece.getPieceFromChar(c);
                    //looks stupid. fix later
                    board[x][y].setPiece(p);
                } catch (IncorrectFenException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return board;
    }

    public Field[][] getBoard() {
        return board;
    }

    public Field getField(int x, int y) {
        return board[x][y];
    }

    public boolean onBoard(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    @Override
    public String toString() {
        String s = "";
        for (Field[] row : board) {
            for (Field f : row) {
                s += f.toString();
            }
            //after each row, add a slash
            s += "/";
        }
        //remove the last slash
        s = s.substring(0, s.length()-1);
        //replace groups of zeros with the number of zeros
        s = s.replaceAll("0{8}", "8");
        s = s.replaceAll("0{7}", "7");
        s = s.replaceAll("0{6}", "6");
        s = s.replaceAll("0{5}", "5");
        s = s.replaceAll("0{4}", "4");
        s = s.replaceAll("0{3}", "3");
        s = s.replaceAll("0{2}", "2");
        s = s.replaceAll("0{1}", "1");
        return s;
    }
}
