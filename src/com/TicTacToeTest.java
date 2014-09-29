package com;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Daniel on 9/22/2014.
 */
public class TicTacToeTest {

    private TicTacToe t;

    @Before
    public void setUp() throws Exception {
        t = new TicTacToe();
    }

    @Test
    public void test() {
        HumanWinColumn();
        ComputerWinColumn();

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
        assertTrue (!t.isWin(Constants.COMPUTER));
        assertTrue (t.isWin(Constants.HUMAN));
        assertTrue (!t.boardIsFull());

        t.clearBoard();
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

        // Human should win now
        assertTrue (t.isWin(Constants.COMPUTER));
        assertTrue (!t.isWin(Constants.HUMAN));
        assertTrue (!t.boardIsFull());

        t.clearBoard();
    }

}
