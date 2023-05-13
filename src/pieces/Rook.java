package pieces;

import java.util.LinkedList;
import chess.Board;
import chess.Move;

public class Rook extends Piece {

    public Rook(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        return this.white ? "R" : "r";
    }

    @Override
    public LinkedList<Move> legalMoves(Board board, int x, int y) {
        LinkedList<Move> moves = new LinkedList<Move>();
        //North
        for(int i = y - 1; i >= 0; i--){
            if(board.getField(x, i).getPiece() == null){
                moves.add(new Move(new int[]{x,y}, new int[]{x,i}, this.white ? 'R' : 'r'));
            }
            else if(board.getField(x, i).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{x,i}, this.white ? 'R' : 'r'));
                break;
            }
            else{
                break;
            }
        }
        //South
        for(int i = y + 1; i <= 7; i++){
            if(board.getField(x, i).getPiece() == null){
                moves.add(new Move(new int[]{x,y}, new int[]{x,i}, this.white ? 'R' : 'r'));
            }
            else if(board.getField(x, i).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{x,i}, this.white ? 'R' : 'r'));
                break;
            }
            else{
                break;
            }
        }
        //East
        for(int i = x + 1; i <= 7; i++){
            if(board.getField(i, y).getPiece() == null){
                moves.add(new Move(new int[]{x,y}, new int[]{i,y}, this.white ? 'R' : 'r'));
            }
            else if(board.getField(i, y).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{i,y}, this.white ? 'R' : 'r'));
                break;
            }
            else{
                break;
            }
        }
        //West
        for(int i = x - 1; i >= 0; i--){
            if(board.getField(i, y).getPiece() == null){
                moves.add(new Move(new int[]{x,y}, new int[]{i,y}, this.white ? 'R' : 'r'));
            }
            else if(board.getField(i, y).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{i,y}, this.white ? 'R' : 'r'));
                break;
            }
            else{
                break;
            }
        }
        return moves;
        

        // TODO: Castle?
    }
}
