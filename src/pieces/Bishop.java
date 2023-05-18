package pieces;

import chess.Move;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

import chess.Board;

public class Bishop extends Piece {
    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        return this.white ? "B" : "b";
    }

    @Override
    public LinkedList<Move> legalMoves(Board board, int x, int y) {
        LinkedList<Move> moves = new LinkedList<Move>();
        //NorthWest
        for(int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--){
            if(board.getField(i, j).getPiece() == null){
                moves.add(new Move(new int[]{x,y}, new int[]{i,j}, this.white ? 'B' : 'b'));
            }
            else if(board.getField(i, j).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{i,j}, this.white ? 'B' : 'b'));
                break;
            }
            else{
                break;
            }
        }
        //SouthWest
        for(int i = x + 1, j = y - 1; i <= 7 && j >= 0; i++, j--){
            if(board.getField(i, j).getPiece() == null){
                moves.add(new Move(new int[]{x,y}, new int[]{i,j}, this.white ? 'B' : 'b'));
            }
            else if(board.getField(i, j).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{i,j}, this.white ? 'B' : 'b'));
                break;
            }
            else{
                break;
            }          
        }
        //SouthEast
        for(int i = x + 1, j = y + 1; i <= 7 && j <= 7; i++, j++){
            if(board.getField(i, j).getPiece() == null){
                moves.add(new Move(new int[]{x,y}, new int[]{i,j}, this.white ? 'B' : 'b'));
            }
            else if(board.getField(i, j).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{i,j}, this.white ? 'B' : 'b'));
                break;
            }
            else{
                break;
            }  
        }
        //NorthEast
        for(int i = x - 1, j = y + 1; i >= 0 && j <= 7; i--, j++){
            if(board.getField(i, j).getPiece() == null){
                moves.add(new Move(new int[]{x,y}, new int[]{i,j}, this.white ? 'B' : 'b'));
            }
            else if(board.getField(i, j).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{i,j}, this.white ? 'B' : 'b'));
                break;
            }
            else{
                break;
            }
        }
        
        //generate all possible moves if pinned (if piece is not pinned -> pinMoves = null)
        ArrayList<int[]> pinMoves = this.pinnedMoves(board, x, y);
        if(pinMoves != null) {
            moves = moves.stream()
                //filter moves that are not legal for pinned piece
                .filter(move -> pinMoves.stream().anyMatch(pMove -> Arrays.equals(pMove, move.getTo())))
                .collect(Collectors.toCollection(LinkedList::new));
        }
        return moves;
    }
}
