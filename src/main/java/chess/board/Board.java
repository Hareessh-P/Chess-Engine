package chess.board;

import chess.pieces.*;

public class Board {
    private volatile static Board uniqueInstance;
    private String[] displayBoard;
    private String space;

    Bitboard occupancyBitboard;        // TODO : See if its occupancy bitboard and change the entire codebase accordingly
    Bitboard whiteOccupancyBitboard;
    Bitboard blackOccupancyBitboard;
    Bitboard whitePawns;
    Bitboard whiteRooks;
    Bitboard whiteKnights;
    Bitboard whiteBishops;
    Bitboard whiteKing;
    Bitboard whiteQueen;
    Bitboard blackPawns;
    Bitboard blackRooks;
    Bitboard blackKnights;
    Bitboard blackBishops;
    Bitboard blackKing;
    Bitboard blackQueen;


    private Board() {
        //              POTENTIAL PROBLEM  --> Occupancy Bitboard colour is set to black ... :(
        this.occupancyBitboard = new Bitboard(0xFFFF00000000FFFFL, true);   //  <----------
        this.whiteOccupancyBitboard = new Bitboard(0xFFFF000000000000L, false);
        this.blackOccupancyBitboard = new Bitboard(0x000000000000L, true);
        this.space = "\u25AD";    //  Unicode escape sequence '\u25AD' can be replaced with '▭'
        this.displayBoard = new String[] {
//              0      1     2     3    4     5     6    7
                "♖", "♘", "♗", "♔", "♕", "♗", "♘", "♖",
                //8     9   10    11    12   13     14  15
                "♙", "♙", "♙", "♙", "♙", "♙", "♙", "♙",
                "▭", "▭", "▭", "▭", "▭", "▭", "▭", "▭",
                "▭", "▭", "▭", "▭", "▭", "▭", "▭", "▭",
                "▭", "▭", "▭", "▭", "▭", "▭", "▭", "▭",
                "▭", "▭", "▭", "▭", "▭", "▭", "▭", "▭",
                "♟", "♟", "♟", "♟", "♟", "♟", "♟", "♟",
               "♜", "♞", "♝", "♚", "♛", "♝", "♞", "♜",

        };
        this.whitePawns = new Bitboard(0x000000000000FF00L,false);
        this.whiteRooks = new Bitboard(0x0000000000000081L,false);
        this.whiteKnights = new Bitboard(0x0000000000000042L,false);
        this.whiteBishops = new Bitboard(0x0000000000000024L,false);
        this.whiteKing = new Bitboard(0x0000000000000008L,false);
        this.whiteQueen = new Bitboard(0x0000000000000010L,false);

        this.blackPawns = new Bitboard(0x00FF000000000000L,true);
        this.blackRooks = new Bitboard(0x8100000000000000L,true);
        this.blackKnights = new Bitboard(0x4200000000000000L,true);
        this.blackBishops = new Bitboard(0x2400000000000000L,true);
        this.blackKing = new Bitboard(0x8000000000000000L,true);
        this.blackQueen = new Bitboard(0x1000000000000000L,true);
    }
    public static Board getInstance() {
        if (uniqueInstance == null) {
            synchronized (Board.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Board();
                }
            }
        }
        return uniqueInstance;
    }

    public Bitboard getOccupancyBitboard() {
        return occupancyBitboard;
    }

    public void setOccupancyBitboard(int boxNo) {
        this.occupancyBitboard.setBitInOccupancyBitboard(boxNo);
    }

    public void unsetOccupancyBitboard(int boxNo) {
        this.occupancyBitboard.unsetBitInOccupancyBitboard(boxNo);
    }

    public Bitboard getWhiteOccupancyBitboard() {
        return whiteOccupancyBitboard;
    }

    public void setWhiteOccupancyBitboard(int boxNo) {
        this.whiteOccupancyBitboard.setBitInOccupancyBitboard(boxNo);
    }

    public void unsetWhiteOccupancyBitboard(int boxNo) {
        this.whiteOccupancyBitboard.unsetBitInOccupancyBitboard(boxNo);
    }

    public Bitboard getBlackOccupancyBitboard() {
        return blackOccupancyBitboard;
    }

    public void setBlackOccupancyBitboard(int boxNo) {
        this.blackOccupancyBitboard.setBitInOccupancyBitboard(boxNo);
    }

    public void unsetBlackOccupancyBitboard(int boxNo) {
        this.blackOccupancyBitboard.unsetBitInOccupancyBitboard(boxNo);
    }

    public void movePieceOnDisplayBoard(int fromBoxNumber, int toBoxNumber) {
        System.out.println("\nInside movePieceOnDisplayBoard : ");
        System.out.println("\nfromboxno : "+ fromBoxNumber + "toboxno" + toBoxNumber);
        System.out.println();
        System.out.println();
        this.displayBoard[toBoxNumber] = this.displayBoard[fromBoxNumber];
        this.displayBoard[fromBoxNumber] = this.space;
    }

    public String getPieceDisplayString(int boxNo) {
        return this.displayBoard[boxNo];
    }

    public void setPieceDisplayString(int boxNo, String pieceString) {
        this.displayBoard[boxNo] = pieceString;
    }

    public void setBlackPawnOccupancyBitboard(int boxNo) {
        this.blackPawns.setBitInOccupancyBitboard(boxNo);
    }

    public void unsetBlackPawnOccupancyBitboard(int boxNo) {
        this.blackPawns.unsetBitInOccupancyBitboard(boxNo);
    }

    public void setBlackRookOccupancyBitboard(int boxNo) {
        this.blackRooks.setBitInOccupancyBitboard(boxNo);
    }

    public void unsetBlackRookOccupancyBitboard(int boxNo) {
        this.blackRooks.unsetBitInOccupancyBitboard(boxNo);
    }

    public void setBlackBishopOccupancyBitboard(int boxNo) {
        this.blackBishops.setBitInOccupancyBitboard(boxNo);
    }

    public void unsetBlackBishopOccupancyBitboard(int boxNo) {
        this.blackBishops.unsetBitInOccupancyBitboard(boxNo);
    }

    public void setBlackKnightsOccupancyBitboard(int boxNo) {
        this.blackKnights.setBitInOccupancyBitboard(boxNo);
    }

    public void unsetBlackKnightsOccupancyBitboard(int boxNo) {
        this.blackKnights.unsetBitInOccupancyBitboard(boxNo);
    }

    public void setBlackKingOccupancyBitboard(int boxNo) {
        this.blackKing.setBitInOccupancyBitboard(boxNo);
    }

    public void unsetBlackKingOccupancyBitboard(int boxNo) {
        this.blackKing.unsetBitInOccupancyBitboard(boxNo);
    }

    public void setBlackQueenOccupancyBitboard(int boxNo) {
        this.blackQueen.setBitInOccupancyBitboard(boxNo);
    }

    public void unsetBlackQueenOccupancyBitboard(int boxNo) {
        this.blackQueen.unsetBitInOccupancyBitboard(boxNo);
    }

    public void unsetWhitePawnOccupancyBitboard(int boxNo) {
        this.whitePawns.unsetBitInOccupancyBitboard(boxNo);
    }

    public void setWhitePawnOccupancyBitboard(int boxNo) {
        this.whitePawns.setBitInOccupancyBitboard(boxNo);
    }

    public void setWhiteRookOccupancyBitboard(int boxNo) {
        this.whiteRooks.setBitInOccupancyBitboard(boxNo);
    }

    public void unsetWhiteRookOccupancyBitboard(int boxNo) {
        this.whiteRooks.unsetBitInOccupancyBitboard(boxNo);
    }

    public void setWhiteBishopOccupancyBitboard(int boxNo) {
        this.whiteBishops.setBitInOccupancyBitboard(boxNo);
    }

    public void unsetWhiteBishopOccupancyBitboard(int boxNo) {
        this.whiteBishops.unsetBitInOccupancyBitboard(boxNo);
    }

    public void setWhiteKnightsOccupancyBitboard(int boxNo) {
        this.whiteKnights.setBitInOccupancyBitboard(boxNo);
    }

    public void unsetWhiteKnightsOccupancyBitboard(int boxNo) {
        this.whiteKnights.unsetBitInOccupancyBitboard(boxNo);
    }

    public void setWhiteKingOccupancyBitboard(int boxNo) {
        this.whiteKing.setBitInOccupancyBitboard(boxNo);
    }

    public void unsetWhiteKingOccupancyBitboard(int boxNo) {
        this.whiteKing.unsetBitInOccupancyBitboard(boxNo);
    }

    public void setWhiteQueenOccupancyBitboard(int boxNo) {
        this.whiteQueen.setBitInOccupancyBitboard(boxNo);
    }

    public void unsetWhiteQueenOccupancyBitboard(int boxNo) {
        this.whiteQueen.unsetBitInOccupancyBitboard(boxNo);
    }




}