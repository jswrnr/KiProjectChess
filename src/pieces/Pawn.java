package pieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

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
            if (board.onBoard(x-1, y-1) 
                && board.getField(x-1, y-1).getPiece() != null 
                && board.getField(x-1, y-1).getPiece().isWhite() != this.white) {
                moves.add(new Move(new int[]{x, y} , new int[] {(x-1), (y-1)}, this.white ? 'P' : 'p'));
            }
            //move up and right if there is a piece there
            if (board.onBoard(x-1, y+1) 
                && board.getField(x-1, y+1).getPiece() != null
                && board.getField(x-1, y+1).getPiece().isWhite() != this.white) {
                moves.add(new Move(new int[]{x, y} , new int[] {(x+1), (y-1)}, this.white ? 'P' : 'p'));
            }
            //move up if there is no piece there
            if (board.onBoard(x-1, y)
                && board.getField(x-1, y).getPiece() == null) {
                moves.add(new Move(new int[]{x, y} , new int[] {x-1, (y)}, this.white ? 'P' : 'p'));
            }
            //move up two if there is no piece there and the pawn hasn't moved
            if (board.onBoard(x-2, y)
                && board.getField(x-1, y).getPiece() == null
                && board.getField(x-2, y).getPiece() == null
                && this.hasMoved == false) {
                moves.add(new Move(new int[]{x, y} , new int[] {x-2, y}, this.white ? 'P' : 'p'));
            }
        } else {
            //move down and left if there is a piece there
            if (board.onBoard(x+1, y-1)
                && board.getField(x+1, y-1).getPiece() != null
                && board.getField(x+1, y-1).getPiece().isWhite() != this.white) {
                moves.add(new Move(new int[]{x, y} , new int[] {x+1, y-1}, this.white ? 'P' : 'p'));
                }
            //move down and right if there is a piece there
            if (board.onBoard(x+1, y+1)
                && board.getField(x+1, y+1).getPiece() != null
                && board.getField(x+1, y+1).getPiece().isWhite() != this.white) {
                moves.add(new Move(new int[]{x, y} , new int[] {(x+1), (y+1)}, this.white ? 'P' : 'p'));
            }
            //move down if there is no piece there
            if (board.onBoard(x+1, y)
                && board.getField(x+1, y) == null) {
                moves.add(new Move(new int[]{x, y} , new int[] {x+1, y}, this.white ? 'P' : 'p'));
            }
            //move down two if there is no piece there and the pawn hasn't moved
            if (board.onBoard(x+2, y)
                && board.getField(x+2, y) == null
                && board.getField(x+1, y) == null
                && this.hasMoved == false) {
                moves.add(new Move(new int[]{x, y} , new int[] {x+2, y}, this.white ? 'P' : 'p'));
            }
        }

        //generate all possible moves if pinned (if piece is not pinned -> pinMoves = null)
        ArrayList<int[]> pinMoves = this.pinnedMoves(board, x, y);
        if(pinMoves != null) {
            moves = moves.stream()
                //filter moves that are not legal for pinned piece
                .filter(move -> pinMoves.stream().anyMatch(pMove -> Arrays.equals(pMove, move.getTo())))
                .collect(Collectors.toCollection(LinkedList::new));
            pinMoves.clear();
        }
        
        return moves;
    }

    @Override
    public boolean[][] getAttackSquares(Board board, int x, int y) {
        boolean[][] attackSquares = new boolean[8][8];
        //make all squares false
        for(int i = 0; i < 8; i++){
            Arrays.fill(attackSquares[i], false);
        }
        if (this.white) {
            //move up and left if there is a piece there
            if (board.onBoard(x-1, y-1) 
                && board.getField(x-1, y-1).getPiece() != null 
                && board.getField(x-1, y-1).getPiece().isWhite() != this.white) {
                attackSquares[x-1][y-1] = true;
            }
            //move up and right if there is a piece there
            if (board.onBoard(x-1, y+1) 
                && board.getField(x-1, y+1).getPiece() != null
                && board.getField(x-1, y+1).getPiece().isWhite() != this.white) {
                attackSquares[x-1][y+1] = true;
            }
        } else {
            //move down and left if there is a piece there
            if (board.onBoard(x+1, y-1)
                && board.getField(x+1, y-1).getPiece() != null
                && board.getField(x+1, y-1).getPiece().isWhite() != this.white) {
                attackSquares[x+1][y-1] = true;
                }
            //move down and right if there is a piece there
            if (board.onBoard(x+1, y+1)
                && board.getField(x+1, y+1).getPiece() != null
                && board.getField(x+1, y+1).getPiece().isWhite() != this.white) {
                attackSquares[x+1][y+1] = true;
            }
        }
        return attackSquares;
    }
}
