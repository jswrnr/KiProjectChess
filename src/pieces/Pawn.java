package pieces;

import java.util.LinkedList;
import chess.Move;
import chess.Board;

public class Pawn extends Piece {
    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        return this.white ? "P" : "p";
    }

    @Override
    public LinkedList<Move> legalMoves(Board board, int x, int y) {
        LinkedList<Move> moves = new LinkedList<Move>();
        if (this.white) {
            //move up and left if there is a piece there
            if (board.onBoard(x-1, y-1) && board.getField(x-1, y-1) != null && board.getField(x-1, y-1).getPiece().isWhite() != this.white) {
                moves.add(new Move(new int[]{x, y} , new int[] {(x-1), (y-1)}, this.white ? 'P' : 'p'));
            }
            //move up and right if there is a piece there
            if (board.onBoard(x+1, y-1) && board.getField(x+1, y-1) != null && board.getField(x+1, y-1).getPiece().isWhite() != this.white) {
                moves.add(new Move(new int[]{x, y} , new int[] {(x+1), (y-1)}, this.white ? 'P' : 'p'));
            }
            //move up if there is no piece there
            if (board.onBoard(x, y-1) && board.getField(x, y-1) == null) {
                moves.add(new Move(new int[]{x, y} , new int[] {x, (y-1)}, this.white ? 'P' : 'p'));
            }
        } else {
            //move down and left if there is a piece there
            if (board.onBoard(x-1, y+1) && board.getField(x-1, y+1) != null && board.getField(x-1, y+1).getPiece().isWhite() != this.white) {
                moves.add(new Move(new int[]{x, y} , new int[] {(x-1), (y+1)}, this.white ? 'P' : 'p'));
                }
            //move down and right if there is a piece there
            if (board.onBoard(x+1, y+1) && board.getField(x+1, y+1) != null && board.getField(x+1, y+1).getPiece().isWhite() != this.white) {
                moves.add(new Move(new int[]{x, y} , new int[] {(x+1), (y+1)}, this.white ? 'P' : 'p'));
            }
            //move down if there is no piece there
            if (board.onBoard(x, y+1) && board.getField(x, y+1) == null) {
                moves.add(new Move(new int[]{x, y} , new int[] {x, (y+1)}, this.white ? 'P' : 'p'));
            }
        }
        return moves;
    }
}
