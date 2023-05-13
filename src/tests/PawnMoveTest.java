package tests;

import pieces.Pawn;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import chess.Move;
import java.util.LinkedList;

import chess.Board;

public class PawnMoveTest {
    Pawn pawn = new Pawn(true);
    @Test
    public void testPawnMove() {
        Board board = new Board();
        //test that the pawn has 2 moves in default board setup
        LinkedList<Move> moves = pawn.legalMoves(board, 6, 0);
        assertEquals(moves.toString(), 2, moves.size());
    }
}
