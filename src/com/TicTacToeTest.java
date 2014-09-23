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
        Position compMove;
        compMove = new Position (TicTacToe.COMPUTER, 0, 0);

        // computer plays a move first
        t.makeMove(TicTacToe.COMPUTER, compMove.row, compMove.column);
        // then the other side
        t.makeMove(TicTacToe.HUMAN, 1, 1);

        // computer plays a move again
        compMove = t.chooseMove(TicTacToe.COMPUTER);
        t.makeMove(TicTacToe.COMPUTER, compMove.row, compMove.column);
        // then the other side
        t.makeMove(TicTacToe.HUMAN, 1, 2);

        // computer plays a move again
        compMove = t.chooseMove(TicTacToe.COMPUTER);
        t.makeMove(TicTacToe.COMPUTER, compMove.row, compMove.column);

        // computer should win now
        assertTrue (t.isWin(TicTacToe.COMPUTER));
        assertTrue (!t.isWin(TicTacToe.HUMAN));
        assertTrue (!t.boardIsFull());
    }

}
