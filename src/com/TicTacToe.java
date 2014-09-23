package com;

/**
 * Created by Daniel on 9/22/2014.
 */
public class TicTacToe {

    // constant for the board size
    public static final int NUM_OF_ROWS  = 3;
    public static final int NUM_OF_COLS  = 3;


    // static value for side or piece 
    public static final int HUMAN        = 0;
    public static final int COMPUTER     = 1;
    public static final int EMPTY        = 2;

    // static value for game status
    public static final int HUMAN_WIN    = 0;
    public static final int DRAW         = 1;
    public static final int UNCLEAR      = 2;
    public static final int COMPUTER_WIN = 3;

    private int[][] board = new int[NUM_OF_ROWS][NUM_OF_COLS];

    public TicTacToe () {
        clearBoard();
    }

    // make the board empty
    public void clearBoard() {
        // to complete
    }

    // return the board
    public int[][] getBoard () {
        return new int[5][5];
    }

    // test if a position is empty
    private boolean isEmpty (int row, int column) {
        return false;
    }

    // compute and return static value for current game status
    private int gameStatus () {
        return isWin(COMPUTER) ? COMPUTER_WIN :
                isWin(HUMAN)    ? HUMAN_WIN :
                        boardIsFull()   ? DRAW : UNCLEAR;
    }

    // return true if the board is full
    public boolean boardIsFull () {
        return false;
    }

    // computer the optimal move for a side
    public Position chooseMove (int side) {
        int opp;              // The other side
        Position reply;       // Opponent's best reply
        int simpleEval;       // Result of an immediate evaluation
        int bestRow = 0;
        int bestColumn = 0;
        int value;

        if ((simpleEval = gameStatus()) != UNCLEAR)
            return new Position(simpleEval);

        if(side == COMPUTER) {
            opp = HUMAN; value = HUMAN_WIN;
        }
        else  {
            opp = COMPUTER; value = COMPUTER_WIN;
        }

        for (int row = 0; row < NUM_OF_ROWS; row++)
            for (int column = 0; column < NUM_OF_COLS; column++)
                if (isEmpty(row, column)) {
                    placePiece (row, column, side);
                    reply = chooseMove(opp);
                    placePiece (row, column, EMPTY);
                    if(side == COMPUTER && reply.value > value ||
                            side == HUMAN && reply.value < value)     {
                        if(side == COMPUTER)
                            value = reply.value;
                        else
                            value = reply.value;

                        bestRow = row; bestColumn = column;
                    }
                }

        return new Position (value, bestRow, bestColumn);
    }

    // play a move, after checking its legality
    // return true if the intended position is within the 
    // boundary of the board and is empty
    public boolean makeMove (int side, int row, int column) {
        return false;
    }

    // place a piece in a position, possibly clearing a position
    // a private method � no need to check legality
    private void placePiece (int row, int column, int piece) {
        //TODO: To complete
    }

    // return true if the board shows a win for the side
    public boolean isWin(int side)  {
        return false;
    }
}
