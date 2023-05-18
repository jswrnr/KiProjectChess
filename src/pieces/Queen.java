package pieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

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
        //NorthEast
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
        //NorthWest
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

    @Override
    public boolean[][] attackSquares(Board board, int x, int y) {
        boolean[][] attackSquares = new boolean[8][8];
        //make all squares false
        for(int i = 0; i < 8; i++){
            Arrays.fill(attackSquares[i], false);
        }
        for(int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--){
            if(board.getField(i, j).getPiece() == null){
                attackSquares[i][j] = true;
            }
            else if(board.getField(i, j).getPiece().isWhite() != this.white){
                attackSquares[i][j] = true;
                break;
            }
            else{
                break;
            }
        }
        //SouthEast
        for(int i = x + 1, j = y - 1; i <= 7 && j >= 0; i++, j--){
            if(board.getField(i, j).getPiece() == null){
                attackSquares[i][j] = true;
            }
            else if(board.getField(i, j).getPiece().isWhite() != this.white){
                attackSquares[i][j] = true;
                break;
            }
            else{
                break;
            }          
        }
        //NorthEast
        for(int i = x + 1, j = y + 1; i <= 7 && j <= 7; i++, j++){
            if(board.getField(i, j).getPiece() == null){
                attackSquares[i][j] = true;
            }
            else if(board.getField(i, j).getPiece().isWhite() != this.white){
                attackSquares[i][j] = true;
                break;
            }
            else{
                break;
            }  
        }
        //NorthWest
        for(int i = x - 1, j = y + 1; i >= 0 && j <= 7; i--, j++){
            if(board.getField(i, j).getPiece() == null){
                attackSquares[i][j] = true;
            }
            else if(board.getField(i, j).getPiece().isWhite() != this.white){
                attackSquares[i][j] = true;
                break;
            }
            else{
                break;
            }
        }
        //North
        for(int i = y - 1; i >= 0; i--){
            if(board.getField(x, i).getPiece() == null){
                attackSquares[x][i] = true;
            }
            else if(board.getField(x, i).getPiece().isWhite() != this.white){
                attackSquares[x][i] = true;
                break;
            }
            else{
                break;
            }
        }
        //South
        for(int i = y + 1; i <= 7; i++){
            if(board.getField(x, i).getPiece() == null){
                attackSquares[x][i] = true;
            }
            else if(board.getField(x, i).getPiece().isWhite() != this.white){
                attackSquares[x][i] = true;
                break;
            }
            else{
                break;
            }
        }
        //East
        for(int i = x + 1; i <= 7; i++){
            if(board.getField(i, y).getPiece() == null){
                attackSquares[i][y] = true;
            }
            else if(board.getField(i, y).getPiece().isWhite() != this.white){
                attackSquares[i][y] = true;
                break;
            }
            else{
                break;
            }
        }
        //West
        for(int i = x - 1; i >= 0; i--){
            if(board.getField(i, y).getPiece() == null){
                attackSquares[i][y] = true;
            }
            else if(board.getField(i, y).getPiece().isWhite() != this.white){
                attackSquares[i][y] = true;
                break;
            }
            else{
                break;
            }
        }
        return attackSquares;
    }
}
