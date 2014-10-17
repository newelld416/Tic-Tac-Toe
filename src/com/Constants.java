package com;

/**
 * Created by Daniel on 9/22/2014.
 */
public class Constants {
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

    //Text shown to the user
    public static final String TITLE = "Tic Tac Toe Game";
    public static final String EXIT_BUTTON_TEXT = "Exit Game";
    public static final String INIT_BUTTON_TEXT = "Reset";
    public static final String INITIAL_SCORE_TEXT = "No Score";

    //Configuration Settings
    public static final boolean PRINT_BOARD = false;
    public static final int WIDTH=600;
    public static final int HEIGHT=800;
    public static final int MAX_NUMBER_OF_BUTTONS = 9;

}
