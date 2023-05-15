package pieces;

import chess.Move;

import java.util.Arrays;
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
        //generate all possible moves
        int[][] possibleMoves = {{x-2, y-1}, {x-2, y+1}, {x-1, y-2}, {x-1, y+2}, {x+1, y-2}, {x+1, y+2}, {x+2, y-1}, {x+2, y+1}};
        possibleMoves = Arrays.stream(possibleMoves)
            //filter moves that are off the board
            .filter(move -> board.onBoard(move[0], move[1]))
            //filter moves that are blocked by a piece of the same color
            .filter(move -> board.getField(move[0], move[1]).getPiece() == null || board.getField(move[0], move[1]).getPiece().isWhite() != this.white)
            .toArray(int[][]::new);

        //generate all possible moves if pinned (if piece is not pinned -> pinMoves = null)
        int[][] pinMoves = this.pinnedMoves(board, x, y);
        if(pinMoves != null) {
            possibleMoves = Arrays.stream(possibleMoves)
                //filter moves that are not legal for pinned piece
                .filter(move -> Arrays.stream(pinMoves).anyMatch(move::equals))
                .toArray(int[][]::new);
        }
        
        //add all possible moves to the list
        for(int[] move : possibleMoves){
            moves.add(new Move(new int[]{x,y}, move, this.white ? 'N' : 'n'));
        }
        return moves;
    }
}
