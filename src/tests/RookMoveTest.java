package tests;

import pieces.Rook;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import chess.Move;
import java.util.LinkedList;
import chess.Board;

public class RookMoveTest {
    Rook rook = new Rook(true);

    @Test
    public void testDefaultBoard() {
        Board board = new Board();
        LinkedList<Move> moves = new LinkedList<Move>();
        //iterate through the board and add all moves to the list if the piece is a rook
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board.getField(i, j).getPiece() instanceof Rook){
                    moves.addAll(board.getField(i, j).getPiece().legalMoves(board, i, j));
                }
            }
        }
        assertEquals(moves.toString(), 0, moves.size());
    }
}
