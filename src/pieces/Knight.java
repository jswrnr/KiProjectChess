package pieces;

import chess.Move;
import java.util.LinkedList;
import chess.Board;
public class Knight extends Piece {

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        return this.white ? "N" : "n";
    }

    @Override
    public LinkedList<Move> legalMoves(Board board, int x, int y) {
        LinkedList<Move> moves = new LinkedList<Move>();
        //North
        for(int i = y - 1; i >= 0; i--){
            if(board.getField(x, i).getPiece() == null){
                moves.add(new Move(new int[]{x,y}, new int[]{x,i}, this.white ? 'K' : 'k'));
            }
            else if(board.getField(x, i).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{x,i}, this.white ? 'K' : 'k'));
                break;
            }
            else{
                break;
            }
        }
        //South
        for(int i = y + 1; i <= 7; i++){
            if(board.getField(x, i).getPiece() == null){
                moves.add(new Move(new int[]{x,y}, new int[]{x,i}, this.white ? 'K' : 'k'));
            }
            else if(board.getField(x, i).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{x,i}, this.white ? 'K' : 'k'));
                break;
            }
            else{
                break;
            }
        }
        //East
        for(int i = x + 1; i <= 7; i++){
            if(board.getField(i, y).getPiece() == null){
                moves.add(new Move(new int[]{x,y}, new int[]{i,y}, this.white ? 'K' : 'k'));
            }
            else if(board.getField(i, y).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{i,y}, this.white ? 'K' : 'k'));
                break;
            }
            else{
                break;
            }
        }
        //West
        for(int i = x - 1; i >= 0; i--){
            if(board.getField(i, y).getPiece() == null){
                moves.add(new Move(new int[]{x,y}, new int[]{i,y}, this.white ? 'K' : 'k'));
            }
            else if(board.getField(i, y).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{i,y}, this.white ? 'K' : 'k'));
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
