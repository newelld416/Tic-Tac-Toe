package com;

/**
 * Created by Daniel on 9/22/2014.
 */
public class Constants {
    //Constant for the board size
    public static final int NUM_OF_ROWS  = 3;
    public static final int NUM_OF_COLS  = 3;

    //Value for side or piece
    public static final int HUMAN        = 0;
    public static final int COMPUTER     = 1;
    public static final int EMPTY        = 2;

    //Value for game status
    public static final int HUMAN_WIN    = 0;
    public static final int DRAW         = 1;
    public static final int UNCLEAR      = 2;
    public static final int COMPUTER_WIN = 3;

    //User displayed text
    public static final String HUMAN_WIN_TEXT = "Human Win";
    public static final String COMPUTER_WIN_TEXT = "Computer Win";
    public static final String DRAW_TEXT = "Draw";
    public static final String IN_PROGRESS = "Game in Progress";
    public static final String SCORE_TOOL_TIP = "This section describes the score of the match";
    public static final String COMPUTER_FIRST_TEXT = "Computer Moves First";
    public static final String HUMAN_FIRST_TEXT = "Human Moves First";
    public static final String TITLE = "Tic Tac Toe Game";
    public static final String INIT_BUTTON_TEXT = "Reset";

    //Configuration Settings
    public static final int WIDTH=600;
    public static final int HEIGHT=800;
    public static final int BUTTONS_PER_ROW = 3;

    //Image names
    public static String HUMAN_IMAGE = "Human_Image.jpg";
    public static String COMPUTER_IMAGE = "Computer_Image.jpg";

}
