package com;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Daniel on 9/22/2014.
 * All tests are designed to work on a board that is 3 X 3
 */
public class TicTacToeTest {

    private TicTacToe t;
    private int winner;

    @Before
    public void setUp() throws Exception {
        t = new TicTacToe();
    }

    @Test
    public void test() {
        HumanWinColumn();
        HumanWinRow();
        HumanWinDiagonal();
        ComputerWinColumn();
        ComputerWinRow();
        ComputerWinReverseDiagonal();
        BoardIsFull();
    }

    private void HumanWinColumn(){
        t.makeMove(Constants.COMPUTER, 0, 0);
        t.makeMove(Constants.HUMAN, 0, 1);
        t.makeMove(Constants.COMPUTER, 0, 2);
        t.makeMove(Constants.HUMAN, 1, 0);
        t.makeMove(Constants.COMPUTER, 1,2);
        t.makeMove(Constants.HUMAN,1,1);
        t.makeMove(Constants.COMPUTER, 2,0);
        t.makeMove(Constants.HUMAN, 2,1);

        // Human should win now
        winner = t.isWin();
        assertTrue(winner != Constants.COMPUTER);
        assertTrue(winner == Constants.HUMAN);
        assertTrue(!t.boardIsFull());

        t.getNewBoard();
    }

    private void ComputerWinColumn(){
        t.makeMove(Constants.HUMAN, 0, 0);
        t.makeMove(Constants.COMPUTER, 0, 1);
        t.makeMove(Constants.HUMAN, 0, 2);
        t.makeMove(Constants.COMPUTER, 1, 0);
        t.makeMove(Constants.HUMAN, 1,2);
        t.makeMove(Constants.COMPUTER,1,1);
        t.makeMove(Constants.HUMAN, 2,0);
        t.makeMove(Constants.COMPUTER, 2,1);

        // Computer should win now
        winner = t.isWin();
        assertTrue(winner == Constants.COMPUTER);
        assertTrue(winner != Constants.HUMAN);
        assertTrue(!t.boardIsFull());

        t.getNewBoard();
    }

    private void ComputerWinRow(){
        t.makeMove(Constants.COMPUTER, 0, 0);
        t.makeMove(Constants.HUMAN, 1, 1);
        t.makeMove(Constants.COMPUTER, 0, 1);
        t.makeMove(Constants.HUMAN, 1, 0);
        t.makeMove(Constants.COMPUTER, 1,2);
        t.makeMove(Constants.HUMAN,2,1);
        t.makeMove(Constants.COMPUTER, 0,2);
        t.makeMove(Constants.HUMAN, 2,2);

        // Computer should win now
        winner = t.isWin();
        assertTrue(t.isWin() == Constants.COMPUTER);
        assertTrue(t.isWin() != Constants.HUMAN);
        assertTrue(!t.boardIsFull());

        t.getNewBoard();
    }

    private void HumanWinRow(){
        t.makeMove(Constants.HUMAN, 0, 0);
        t.makeMove(Constants.COMPUTER, 1, 1);
        t.makeMove(Constants.HUMAN, 0, 1);
        t.makeMove(Constants.COMPUTER, 1, 0);
        t.makeMove(Constants.HUMAN, 1,2);
        t.makeMove(Constants.COMPUTER,2,1);
        t.makeMove(Constants.HUMAN, 0,2);
        t.makeMove(Constants.COMPUTER, 2,2);

        // Human should win now
        winner = t.isWin();
        assertTrue(winner != Constants.COMPUTER);
        assertTrue(winner == Constants.HUMAN);
        assertTrue(!t.boardIsFull());

        t.getNewBoard();
    }

    private void HumanWinDiagonal(){
        t.makeMove(Constants.HUMAN, 0, 0);
        t.makeMove(Constants.COMPUTER, 2, 1);
        t.makeMove(Constants.HUMAN, 1, 1);
        t.makeMove(Constants.COMPUTER, 0, 1);
        t.makeMove(Constants.HUMAN, 1,2);
        t.makeMove(Constants.COMPUTER,2,0);
        t.makeMove(Constants.HUMAN, 2,2);
        t.makeMove(Constants.COMPUTER, 0,2);

        // Human should win now
        winner = t.isWin();
        assertTrue(winner != Constants.COMPUTER);
        assertTrue(winner == Constants.HUMAN);
        assertTrue(!t.boardIsFull());

        t.getNewBoard();
    }

    private void ComputerWinReverseDiagonal(){
        t.makeMove(Constants.HUMAN, 0, 0);
        t.makeMove(Constants.COMPUTER, 2, 0);
        t.makeMove(Constants.HUMAN, 1, 0);
        t.makeMove(Constants.COMPUTER, 1, 1);
        t.makeMove(Constants.HUMAN, 1,2);
        t.makeMove(Constants.COMPUTER,2,0);
        t.makeMove(Constants.HUMAN, 2,2);
        t.makeMove(Constants.COMPUTER, 0,2);

        // Computer should win now
        winner = t.isWin();
        assertTrue(winner == Constants.COMPUTER);
        assertTrue(winner != Constants.HUMAN);
        assertTrue(!t.boardIsFull());

        t.getNewBoard();
    }

    private void BoardIsFull(){
        t.makeMove(Constants.HUMAN, 0, 0);
        t.makeMove(Constants.COMPUTER, 0, 1);
        t.makeMove(Constants.COMPUTER, 0, 2);
        t.makeMove(Constants.COMPUTER, 1, 0);
        t.makeMove(Constants.HUMAN, 1,1);
        t.makeMove(Constants.HUMAN,1,2);
        t.makeMove(Constants.HUMAN, 2,0);
        t.makeMove(Constants.COMPUTER, 2,1);
        t.makeMove(Constants.COMPUTER,2,2);

        // This should be a draw
        winner = t.isWin();
        assertTrue(winner != Constants.COMPUTER);
        assertTrue(winner != Constants.HUMAN);
        assertTrue(t.boardIsFull());

        t.getNewBoard();
    }
    
}
