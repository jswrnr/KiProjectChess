package pieces;

import chess.Board;
import chess.Move;

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

    public int[][] pinnedMoves(Board board, int x, int y) {
        int[][] pinMoves = new int[0][];
        int counter = 0;
        int KingX = 0;
        int KingY = 0;
        int xStep = 0;
        int yStep = 0;
        boolean diagonal = false;

        if(this.isWhite()) {
            KingX = board.getWhiteKingPosition()[0];
            KingY = board.getWhiteKingPosition()[1];
        }
        else {
            KingX = board.getBlackKingPosition()[0];
            KingY = board.getBlackKingPosition()[1];
        }

        if (Math.abs(KingX - x) == Math.abs(KingY - y)) {
            if(KingX > x) {
                xStep = 1;
            }
            else {
                xStep = -1;
            }
            if(KingY > y) {
                yStep = 1;
            }
            else {
                yStep = -1;
            }
            diagonal = true;
        }
        else if(KingX == x) {
            if(KingY > y) {
                yStep = 1;
            }
            else {
                yStep = -1;
            }
        }
        else if(KingY == y) {
            if(KingX > x) {
                xStep = 1;
            }
            else {
                xStep = -1;
            }
        }
        else{
            return null;
        }

        for(int i = x + xStep, j = y + yStep; i != KingX && j != KingY; i =+ xStep, j =+ yStep){
            if(board.getField(i, j).getPiece() == null) {
                pinMoves[counter] = new int[]{i,j};
                counter++;
            }
            else {
                return null;
            }
        }

        xStep *= -1;
        yStep *= -1;
        for(int i = x + xStep, j = y + yStep; i != -1 && i != 8 && j != -1 && j != 8; i =+ xStep, j =+ yStep) {
            if(diagonal) {
                if(board.getField(i, j).getPiece() == null) {
                    pinMoves[counter] = new int[]{i,j};
                    counter++;
                }
                else if((board.getField(i, j).getPiece() instanceof Bishop && board.getField(i, j).getPiece().white != this.white) || (board.getField(i, j).getPiece() instanceof Queen && board.getField(i, j).getPiece().white != this.white)){
                    //return pinMoves;
                    break;
                }
                else {
                    return null;
                }
            }
            else {
                if(board.getField(i, j).getPiece() == null) {
                    pinMoves[counter] = new int[]{i,j};
                    counter++;
                }
                else if((board.getField(i, j).getPiece() instanceof Rook && board.getField(i, j).getPiece().white != this.white) || (board.getField(i, j).getPiece() instanceof Queen && board.getField(i, j).getPiece().white != this.white)){
                    //return pinMoves;
                    break;
                }
                else {
                    return null;
                }
            }
        }
        return pinMoves;
    } 


    abstract public LinkedList<Move> legalMoves(Board board, int x, int y);

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
