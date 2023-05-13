package pieces;

import java.util.LinkedList;
import chess.Move;
import chess.Board;
import java.util.Arrays;
public class King extends Piece {

    public King(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        return this.white ? "K" : "k";
    }

    @Override
    public LinkedList<Move> legalMoves(Board board, int x, int y) {
        LinkedList<Move> moves = new LinkedList<Move>();
        //generate all possible moves
        int[][] possibleMoves = {{x-1, y-1}, {x-1, y}, {x-1, y+1}, {x, y-1}, {x, y+1}, {x+1, y-1}, {x+1, y}, {x+1, y+1}};
        possibleMoves = Arrays.stream(possibleMoves)
            //filter moves that are off the board
            .filter(move -> board.onBoard(move[0], move[1]))
            //filter moves that are blocked by a piece of the same color
            .filter(move -> board.getField(move[0], move[1]).getPiece() == null || board.getField(move[0], move[1]).getPiece().isWhite() != this.white)
            .toArray(int[][]::new);
        
        //add all possible moves to the list
        for(int[] move : possibleMoves){
            moves.add(new Move(new int[]{x,y}, move, this.white ? 'K' : 'k'));
        }
        return moves;

        //todo: castling
    }
}
