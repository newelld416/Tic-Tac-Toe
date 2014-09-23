package com;

/**
 * Created by Daniel on 9/22/2014.
 */
public class TicTacToe {

    private int[][] board = new int[Constants.NUM_OF_ROWS][Constants.NUM_OF_COLS];

    /**
     * This is the constructor.
     */
    public TicTacToe () {
        clearBoard();
    }

    /**
     * Clear the board.
     */
    public void clearBoard() {
        for(int i = 0; i < Constants.NUM_OF_ROWS; i++){
            for (int j = 0; j < Constants.NUM_OF_COLS; j++){
                board[i][j] = Constants.EMPTY;
            }
        }
    }

    /**
     * Get the board.
     * @return
     */
    public int[][] getNewBoard () {
        return new int[Constants.NUM_OF_ROWS][Constants.NUM_OF_COLS];
    }

    /**
     * Test if the position is empty.
     * @param row
     * @param column
     * @return
     */
    private boolean isEmpty (int row, int column) {
        return board[row][column] == 2;
    }

    /**
     * Compute and return static values for the game status
     * @return
     */
    private int gameStatus () {
        int returnVal = Constants.UNCLEAR;
        if (isWin(Constants.COMPUTER)){
            returnVal = Constants.COMPUTER_WIN;
        } else {
            if (isWin(Constants.HUMAN)){
                returnVal = Constants.HUMAN_WIN;
            } else {
                returnVal = Constants.DRAW;
            }
        }
        return returnVal;
    }

    /**
     * Return true if the board is full
     * @return
     */
    public boolean boardIsFull () {
        boolean boardHasEmpty = false;
        for(int i = 0; i < Constants.NUM_OF_ROWS; i++){
            for (int j = 0; j < Constants.NUM_OF_COLS; j++){
                if (board[i][j] == Constants.EMPTY) {
                    boardHasEmpty = true;
                }
            }
        }

        return !boardHasEmpty;
    }

    /**\
     * Compute the optimal move for a side
     * @param side
     * @return
     */
    public Position chooseMove (int side) {
        int opp, simpleEvaluation, value;
        int bestRow = 0, bestColumn = 0;
        Position reply;

        if ((simpleEvaluation = gameStatus()) != Constants.UNCLEAR){
            return new Position(simpleEvaluation);
        }

        if(side == Constants.COMPUTER) {
            opp = Constants.HUMAN;
            value = Constants.HUMAN_WIN;
        } else {
            opp = Constants.COMPUTER;
            value = Constants.COMPUTER_WIN;
        }

        for (int row = 0; row < Constants.NUM_OF_ROWS; row++)
            for (int column = 0; column < Constants.NUM_OF_COLS; column++)
                if (isEmpty(row, column)) {
                    placePiece (row, column, side);
                    reply = chooseMove(opp);
                    placePiece (row, column, Constants.EMPTY);
                    if(side == Constants.COMPUTER && reply.value > value || side == Constants.HUMAN && reply.value < value) {
                        value = reply.value;
                        bestRow = row;
                        bestColumn = column;
                    }
                }

        return new Position (value, bestRow, bestColumn);
    }

    /**
     * Play a move, after checking its legality return true if the intended position is within the boundary of the board and is empty.
     * @param side
     * @param row
     * @param column
     * @return
     */
    public boolean makeMove (int side, int row, int column) {
        return false;
    }

    /**
     * Place a piece in a position, possibly clearing a position a private method � no need to check legality
     * @param row
     * @param column
     * @param piece
     */
    private void placePiece (int row, int column, int piece) {
        //TODO: To complete
    }

    /**
     * Return true if the board shows a win for the side
     * @param side
     * @return
     */
    public boolean isWin(int side)  {
        return false;
    }
}
