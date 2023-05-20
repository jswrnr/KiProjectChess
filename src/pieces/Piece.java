package pieces;

import chess.Board;
import chess.Move;

import java.util.ArrayList;
import java.util.LinkedList;

import java.lang.Math;

import Exceptions.IncorrectFenException;
public abstract class Piece {
    protected boolean white;
    protected boolean hasMoved = false;

    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return this.white;
    }

    public boolean hasMoved() {
        return this.hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public ArrayList<int[]> pinnedMoves(Board board, int x, int y) {
        ArrayList<int[]> pinMoves = new ArrayList<>();
        int KingX = 0;
        int KingY = 0;
        int xStep = 0;
        int yStep = 0;
        boolean diagonal = false;

        if(this.white) {
            KingX = board.getWhiteKingPosition()[0];
            KingY = board.getWhiteKingPosition()[1];
        }
        else {
            KingX = board.getBlackKingPosition()[0];
            KingY = board.getBlackKingPosition()[1];
        }

        if (Math.abs(KingX - x) == Math.abs(KingY - y)) {
            xStep = KingX > x ? 1 : -1;
            yStep = KingY > y ? 1 : -1;
            diagonal = true;
        }
        else if(KingX == x) {
            yStep = KingY > y ? 1 : -1;
        }
        else if(KingY == y) {
            xStep = KingX > x ? 1 : -1;
        }
        else{
            return null;
        }

        for(int i = x + xStep, j = y + yStep; i != KingX && j != KingY; i += xStep, j += yStep){
            if(board.getField(i, j).getPiece() == null) {
                pinMoves.add(new int[]{i,j});
            }
            else {
                return null;
            }
        }

        xStep *= -1;
        yStep *= -1;
        for(int i = x + xStep, j = y + yStep; i >=0 && i<8 && j>=0 && j<8; i += xStep, j += yStep) {
            if(diagonal) {
                //if the field is empty add it to the list
                if(board.getField(i, j).getPiece() == null) {
                    pinMoves.add(new int[]{i,j});
                }
                //if the field is occupied by a piece of the opposite color check if it is a bishop or queen
                else if((board.getField(i, j).getPiece() instanceof Bishop 
                && board.getField(i, j).getPiece().isWhite() != this.white) 
                || (board.getField(i, j).getPiece() instanceof Queen 
                && board.getField(i, j).getPiece().isWhite() != this.white)){
                    pinMoves.add(new int[]{x,y});
                    return pinMoves;
                }

            }
            else {
                //if the field is empty add it to the list
                if(board.getField(i, j).getPiece() == null) {
                    pinMoves.add(new int[]{i,j});
                }
                //if the field is occupied by a piece of the opposite color check if it is a rook or queen
                else if((board.getField(i, j).getPiece() instanceof Rook 
                && board.getField(i, j).getPiece().isWhite() != this.white) 
                || (board.getField(i, j).getPiece() instanceof Queen 
                && board.getField(i, j).getPiece().isWhite() != this.white)){
                    pinMoves.add(new int[]{x,y});
                    return pinMoves;
                }
            }
        }
        //if we got here the piece is not pinned
        return null;
    } 


    abstract public LinkedList<Move> legalMoves(Board board, int x, int y);

    abstract public boolean[][] getAttackSquares(Board board, int x, int y);

    public static Piece getPieceFromChar(char c) throws IncorrectFenException {
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

}
