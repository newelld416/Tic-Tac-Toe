package com;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

/**
 * Created by Daniel on 9/29/2014.
 */
public class TicTacToeBoard extends JFrame{

    //Class Properties
    private JButton[][] cells;
    private JButton whosFirstButton;
    private JButton initButton;
    private JLabel score;
    private TicTacToe game;
    private Container content;

    /**
     * This is the constructor.
     */
    public TicTacToeBoard(){
        game = new TicTacToe();

        //Necessary initialization code
        setTitle(Constants.TITLE);
        setSize(Constants.WIDTH, Constants.HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        content = getContentPane();
        content.setLayout(new GridLayout(4,3));

        //Create cells
        cells=new JButton[Constants.BUTTONS_PER_ROW][Constants.BUTTONS_PER_ROW];
        for(int i = 0; i < Constants.BUTTONS_PER_ROW; i++) {
            for(int j = 0; j < Constants.BUTTONS_PER_ROW; j++) {
                cells[i][j] = new JButton();
                cells[i][j].addActionListener(new ActionButtonListener(i,j));
                content.add(cells[i][j]);
            }
        }

        //Initialize the Exit and Init Buttons
        whosFirstButton = new JButton();
        setWhoButtonText(Constants.HUMAN_FIRST_TEXT);
        whosFirstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(whosFirstButton.getText().contains(Constants.HUMAN_FIRST_TEXT)){
                    setWhoButtonText(Constants.COMPUTER_FIRST_TEXT);
                    game.setHumanGoesFirst(false);
                } else {
                    setWhoButtonText(Constants.HUMAN_FIRST_TEXT);
                    game.setHumanGoesFirst(false);
                }
                init();
            }
        });
        content.add(whosFirstButton);

        score = new JLabel();
        score.setHorizontalAlignment(SwingConstants.CENTER);
        score.setVerticalAlignment(SwingConstants.CENTER);
        content.add(score);

        initButton = new JButton();
        initButton.setText(Constants.INIT_BUTTON_TEXT);
        initButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.getNewBoard();
                init();
            }
        });
        content.add(initButton);

        init();
        setVisible(true);
    }

    /**
     * This method takes care of some basic initialization stuff on the form.
     */
    private void init() {
        game.getNewBoard();
        for (int i = 0; i < Constants.BUTTONS_PER_ROW; i++){
            for (int j = 0; j < Constants.BUTTONS_PER_ROW; j++) {
                cells[i][j].setIcon(null);
            }
        }

        setScoreText(-1);

        if (!game.getHumanGoesFirst()){
            Random r = new Random();
            int randomRow = r.nextInt(3);
            int randomColumn = r.nextInt(3);
            game.makeMove(Constants.COMPUTER, randomRow, randomColumn);
            setButtonImage(cells[randomRow][randomColumn], Constants.COMPUTER);
        }
    }

    /**
     * This method turn takes care of an entire turn, human and computer
     * @param x
     * @param y
     * @param button
     */
    public void turn(int x, int y, JButton button){
        int gameStatus = game.gameStatus();
        if (gameStatus== Constants.UNCLEAR) {
            boolean moveMade = makeHumanMove(x, y, button);
            if(!moveMade){
                return;
            }
            gameStatus = game.gameStatus();
            if (gameStatus != Constants.UNCLEAR) {
                setScoreText(gameStatus);
                return;
            }
            makeComputerMove();
        }
    }

    /**
     * This method makes a move for a human turn
     * @param x
     * @param y
     * @param button
     */
    private boolean makeHumanMove(int x, int y, JButton button) {
        //Moves for the human and checks to see if the game is over
        boolean moveMade = game.makeMove(Constants.HUMAN, x, y);
        if (!moveMade) {
            return moveMade;
        }
        setButtonImage(button, Constants.HUMAN);
        return moveMade;
    }

    /**
     * This method makes a move for a computer turn
     */
    private void makeComputerMove() {
        Position computerMove = game.chooseComputerMove(Constants.COMPUTER);
        boolean moveMade = game.makeMove(Constants.COMPUTER, computerMove.getRow(), computerMove.getColumn());
        if (!moveMade) {
            return;
        }
        setButtonImage(cells[computerMove.getRow()][computerMove.getColumn()], Constants.COMPUTER);
        int gameStatus = game.gameStatus();
        if (gameStatus != Constants.UNCLEAR) {
            setScoreText(gameStatus);
            return;
        }
    }

    /**
     * This method sets the score label if there is a winner or a draw.
     * @param gameStatus
     */
    private void setScoreText(int gameStatus){
        StringBuilder statusText = new StringBuilder("<html>");
        if (gameStatus  == Constants.HUMAN_WIN){
            game.setHumanGamesWon(game.getHumanGamesWon() + 1);
            statusText.append(Constants.HUMAN_WIN_TEXT);
        } else if (gameStatus == Constants.COMPUTER_WIN){
            game.setComputerGamesWon(game.getComputerGamesWon() + 1);
            statusText.append(Constants.COMPUTER_WIN_TEXT);
        } else if (gameStatus == Constants.DRAW){
            game.setDraws(game.getDraws() + 1);
            statusText.append(Constants.DRAW_TEXT);
        } else {
            statusText.append(Constants.IN_PROGRESS);
        }

        statusText.append("<br><br>");
        statusText.append("Computer Wins: " + game.getComputerGamesWon() + "<br>");
        statusText.append("Human Wins: " + game.getHumanGamesWon() + "<br>");
        statusText.append("Draws: " + game.getDraws() + "<br>");
        statusText.append("</html>");
        score.setText(statusText.toString());
    }

    /**
     * This method sets the text of the button whichdecides who goes first.
     * @param who
     */
    private void setWhoButtonText(String who){
        whosFirstButton.setText("<html>Click to Switch<br><br>" + who + "</html>");
    }

    /**
     * This method sets the correct image on the button piece
     * @param button
     * @param who
     */
    private void setButtonImage(JButton button, int who){
        try {
            String whoPicFile = who == Constants.HUMAN ? Constants.HUMAN_IMAGE : Constants.COMPUTER_IMAGE;
            Image img = ImageIO.read(new File(whoPicFile));
            button.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.toString());
        }
    }

    /**
     * This is the Main method building the GUI.
     * @param args
     */
    public static void main(String[] args){
        TicTacToeBoard newGame = new TicTacToeBoard();
    }

    /**
     * This class allows us to create the button listeners specific to an individual button
     */
    class ActionButtonListener implements ActionListener {
        private int row;
        private int column;

        /**
         * This is the constructor.
         */
        public ActionButtonListener(int row, int column) {
            super();
            this.row = row;
            this.column = column;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            turn(this.row, this.column, (JButton) e.getSource());
        }
    }
}


