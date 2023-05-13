package pieces;

import java.util.LinkedList;
import chess.Board;
import chess.Move;

public class Queen extends Piece {
    public Queen(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        return this.white ? "Q" : "q";
    }

    @Override
    public LinkedList<Move> legalMoves(Board board, int x, int y) {
        LinkedList<Move> moves = new LinkedList<Move>();
        //SouthWest
        for(int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--){
            if(board.getField(i, j).getPiece() != null){
                moves.add(new Move(new int[]{x,y}, new int[]{i,j}, this.white ? 'B' : 'b'));
            }
            else if(board.getField(i, j).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{i,j}, this.white ? 'B' : 'b'));
            }
            else{
                break;
            }
        }
        //SouthEast
        for(int i = x + 1, j = y - 1; i <= 7 && j >= 0; i++, j--){
            if(board.getField(i, j).getPiece() != null){
                moves.add(new Move(new int[]{x,y}, new int[]{i,j}, this.white ? 'B' : 'b'));
            }
            else if(board.getField(i, j).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{i,j}, this.white ? 'B' : 'b'));
            }
            else{
                break;
            }          
        }
        //NorthEast
        for(int i = x + 1, j = y + 1; i <= 7 && j <= 7; i++, j++){
            if(board.getField(i, j).getPiece() != null){
                moves.add(new Move(new int[]{x,y}, new int[]{i,j}, this.white ? 'B' : 'b'));
            }
            else if(board.getField(i, j).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{i,j}, this.white ? 'B' : 'b'));
            }
            else{
                break;
            }  
        }
        //NorthWest
        for(int i = x - 1, j = y + 1; i >= 0 && j <= 7; i--, j++){
            if(board.getField(i, j).getPiece() != null){
                moves.add(new Move(new int[]{x,y}, new int[]{i,j}, this.white ? 'B' : 'b'));
            }
            else if(board.getField(i, j).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{i,j}, this.white ? 'B' : 'b'));
            }
            else{
                break;
            }
        }

        //North
        for(int i = y - 1; i >= 0; i--){
            if(board.getField(x, i).getPiece() != null){
                moves.add(new Move(new int[]{x,y}, new int[]{x,i}, this.white ? 'K' : 'k'));
            }
            else if(board.getField(x, i).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{x,i}, this.white ? 'K' : 'k'));
            }
            else{
                break;
            }
        }
        //South
        for(int i = y + 1; i <= 7; i++){
            if(board.getField(x, i).getPiece() != null){
                moves.add(new Move(new int[]{x,y}, new int[]{x,i}, this.white ? 'K' : 'k'));
            }
            else if(board.getField(x, i).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{x,i}, this.white ? 'K' : 'k'));
            }
            else{
                break;
            }
        }
        //East
        for(int i = x + 1; i <= 7; i++){
            if(board.getField(i, y).getPiece() != null){
                moves.add(new Move(new int[]{x,y}, new int[]{i,y}, this.white ? 'K' : 'k'));
            }
            else if(board.getField(i, y).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{i,y}, this.white ? 'K' : 'k'));
            }
            else{
                break;
            }
        }
        //West
        for(int i = x - 1; i >= 0; i--){
            if(board.getField(i, y).getPiece() != null){
                moves.add(new Move(new int[]{x,y}, new int[]{i,y}, this.white ? 'K' : 'k'));
            }
            else if(board.getField(i, y).getPiece().isWhite() != this.white){
                moves.add(new Move(new int[]{x,y}, new int[]{i,y}, this.white ? 'K' : 'k'));
            }
            else{
                break;
            }
        }
        return moves;
    }
}
