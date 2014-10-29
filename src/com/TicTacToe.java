package com;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import sun.text.resources.CollationData_sk;

import javax.swing.*;

/**
 * Created by Daniel on 9/22/2014.
 */
public class TicTacToe {

    private int[][] board = new int[Constants.NUM_OF_ROWS][Constants.NUM_OF_COLS];
    private int computerGamesWon;
    private int humanGamesWon;

    /**
     * This is the constructor.
     */
    public TicTacToe () {
        getNewBoard();
    }

    /**
     * Clear the board.
     */
    public void getNewBoard() {
        for(int i = 0; i < Constants.NUM_OF_ROWS; i++){
            for (int j = 0; j < Constants.NUM_OF_COLS; j++){
                board[i][j] = Constants.EMPTY;
            }
        }
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
                    break;
                }
            }
            if(boardHasEmpty){ break; }
        }
        return !boardHasEmpty;
    }

    /**\
     * Compute the optimal move for a side
     * @param side
     * @return
     */
    public Position chooseComputerMove (int side) {
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

        for (int row = 0; row < Constants.NUM_OF_ROWS; row++) {
            for (int column = 0; column < Constants.NUM_OF_COLS; column++) {
                if (board[row][column] == Constants.EMPTY) {
                    board[row][column] = side;
                    reply = chooseComputerMove(opp);
                    board[row][column] = Constants.EMPTY;
                    if (side == Constants.COMPUTER && reply.value > value || side == Constants.HUMAN && reply.value < value) {
                        value = reply.value;
                        bestRow = row;
                        bestColumn = column;
                    }
                }
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
        if (board[row][column] == Constants.EMPTY){
            board[row][column] = side;
            return true;
        }
        return false;
    }

    /**
     * Returns and int describing who won or empty if there is no winner
     * @return
     */
    public int isWin()  {
        if(board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][2] != Constants.EMPTY) {
            return board[0][0];
        } else if(board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][2] != Constants.EMPTY) {
            return board[1][0];
        } else if(board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][2] != Constants.EMPTY) {
            return board[2][0];
        } else if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[2][0] != Constants.EMPTY) {
            return board[0][0];
        } else if(board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[2][1] != Constants.EMPTY) {
            return board[0][1];
        } else if(board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[2][2] != Constants.EMPTY) {
            return board[0][2];
        } else if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] != Constants.EMPTY) {
            return board[0][0];
        } else if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[0][2] != Constants.EMPTY) {
            return board[2][0];
        }

        return Constants.EMPTY;
    }

    /**
     * Compute and return static values for the game status
     * @return
     */
    public int gameStatus () {
        int winner = isWin();
        if (winner == Constants.HUMAN){
            return Constants.HUMAN_WIN;
        } else if (winner == Constants.COMPUTER){
            return Constants.COMPUTER_WIN;
        } else if (boardIsFull()){
            return Constants.DRAW;
        }
        return Constants.UNCLEAR;
    }
}
