package chess;
import enums.Gamestate;

public class GameManager {
    private Board board;
    //not tracked right now
    private Gamestate gamestate = Gamestate.WHITESTURN;
    private boolean whitesTurn;
    private int fullMoveCounter;
    private int halfMoveCounter;
    private String canWhiteCastle;
    private String canBlackCastle;

    public GameManager(String fen) {
        if (fen == null) {
            this.board = new Board();
            this.whitesTurn = true;
            this.canWhiteCastle = "K" + "Q";
            this.canBlackCastle = "k" + "q";
            this.fullMoveCounter = 1;
            this.halfMoveCounter = 0;
        } else {
            String fenParts[] = fen.split(" ");
            this.board = new Board(fenParts[0]);
            //check if the fen string is correct. should ideally be done somewhere else
            this.whitesTurn = fenParts.length>0 ? fenParts[1].equals("w") : true;
            this.canWhiteCastle = fenParts.length>1 ? fenParts[2] : "K" + "Q";
            this.canBlackCastle = fenParts.length>1 ? fenParts[3] : "k" + "q";
            this.halfMoveCounter = fenParts.length>3 ? Integer.parseInt(fenParts[4]) : 0;
            this.fullMoveCounter = fenParts.length>4 ? Integer.parseInt(fenParts[5]) : 1;
        }
    }

    @Override
    public String toString() {
        return board.toString() + " " + (whitesTurn ? "w" : "b") + " " + canWhiteCastle +" "+ canBlackCastle+ " " + halfMoveCounter + " " + fullMoveCounter;
    }
}