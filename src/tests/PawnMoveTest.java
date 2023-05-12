package tests;

import pieces.Pawn;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import chess.Board;

public class PawnMoveTest {
    Pawn pawn = new Pawn(true);
    @Test
    public void testPawnMove() {
        //create a FEN string with only a white pawn at a1
        String FEN = "8/8/8/8/8/8/P7/8";
        Board board = new Board(FEN);
        //test that the pawn can move up one space
        assertEquals(2, pawn.legalMoves(board, 0, 6).size());
    }
}
