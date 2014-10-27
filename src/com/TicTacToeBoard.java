package com;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Daniel on 9/29/2014.
 */
public class TicTacToeBoard extends JFrame{

    private JButton[] cells;
    private JButton exitButton;
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
        cells=new JButton[9];
        cells[0]=new JButton(Constants.EXIT_BUTTON_TEXT);
        cells[1]=new JButton(Constants.EXIT_BUTTON_TEXT);
        cells[2]=new JButton(Constants.EXIT_BUTTON_TEXT);
        cells[3]=new JButton(Constants.EXIT_BUTTON_TEXT);
        cells[4]=new JButton(Constants.EXIT_BUTTON_TEXT);
        cells[5]=new JButton(Constants.EXIT_BUTTON_TEXT);
        cells[6]=new JButton(Constants.EXIT_BUTTON_TEXT);
        cells[7]=new JButton(Constants.EXIT_BUTTON_TEXT);
        cells[8]=new JButton(Constants.EXIT_BUTTON_TEXT);

        //Add Handlers to the cells
        cells[0].addActionListener(new ButtonHandler0());
        cells[1].addActionListener(new ButtonHandler1());
        cells[2].addActionListener(new ButtonHandler2());
        cells[3].addActionListener(new ButtonHandler3());
        cells[4].addActionListener(new ButtonHandler4());
        cells[5].addActionListener(new ButtonHandler5());
        cells[6].addActionListener(new ButtonHandler6());
        cells[7].addActionListener(new ButtonHandler7());
        cells[8].addActionListener(new ButtonHandler8());

        for (int i = 0; i< Constants.MAX_NUMBER_OF_BUTTONS; i++){
            cells[i].setFont(new Font("Arial", Font.BOLD, 24));
        }

        //Initialize the Exit and Init Buttons
        exitButton = new JButton();
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        initButton = new JButton();
        initButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.getNewBoard();
                init();
            }
        });

        score = new JLabel();

        //Add elements to the grid content pane
        for(int i=0; i< Constants.MAX_NUMBER_OF_BUTTONS; i++) {
            content.add(cells[i]);
        }

        content.add(exitButton);
        content.add(score);
        content.add(initButton);

        init();
    }

    /**
     * This method takes care of some basic initialization stuff on the form.
     */
    private void init() {
        //Initialize text in buttons
        for(int i=0; i< Constants.MAX_NUMBER_OF_BUTTONS; i++){
            cells[i].setText(Constants.EMPTY + "");
        }

        //Initialize the other buttons text
        exitButton.setText(Constants.EXIT_BUTTON_TEXT);
        initButton.setText(Constants.INIT_BUTTON_TEXT);
        score.setText(Constants.INITIAL_SCORE_TEXT);
        score.setHorizontalAlignment(SwingConstants.CENTER);
        score.setVerticalAlignment(SwingConstants.CENTER);
        setVisible(true);
    }

    /**
     * This method turn takes care of an entire turn, human and computer
     * @param x
     * @param y
     * @param button
     */
    public void turn(int x, int y, JButton button){
        //Moves for the human and checks to see if the game is over
        boolean moveMade = game.makeMove(Constants.HUMAN,x,y);
        if (!moveMade) { return; }
        button.setText(Constants.HUMAN_PRESSED);
        int gameStatus = game.gameStatus();
        if(gameStatus != Constants.UNCLEAR){
            SetWinnerStatus(gameStatus);
            return;
        }

        //Moves for the computer and checks to see if the game is over
        Position computerMove = game.chooseComputerMove(Constants.COMPUTER);
        game.makeMove(Constants.COMPUTER, computerMove.row, computerMove.column);
        SetComputerPressedText(computerMove);
        gameStatus = game.gameStatus();
        if(gameStatus != Constants.UNCLEAR){
            SetWinnerStatus(gameStatus);
            return;
        }
    }

    /**
     * This method sets the score label if there is a winner or a draw.
     * @param gameStatus
     */
    private void SetWinnerStatus(int gameStatus){
        if (gameStatus  == Constants.HUMAN_WIN){
            score.setText(Constants.HUMAN_WIN_TEXT);
        } else if (gameStatus == Constants.COMPUTER_WIN){
            score.setText(Constants.COMPUTER_WIN_TEXT);
        } else if (gameStatus == Constants.DRAW){
            score.setText(Constants.DRAW_TEXT);
        }
    }

    /**
     * This method set the text of the correct button chosen by the computer.
     * @param computerMove
     */
    private void SetComputerPressedText(Position computerMove){
        if(computerMove.row == 0){
            if(computerMove.column == 0){
                cells[0].setText(Constants.COMPUTER_PRESSED);
            } else if(computerMove.column == 1){
                cells[1].setText(Constants.COMPUTER_PRESSED);
            } else if(computerMove.column == 2){
                cells[2].setText(Constants.COMPUTER_PRESSED);
            }
        } else if(computerMove.row == 1){
            if(computerMove.column == 0){
                cells[3].setText(Constants.COMPUTER_PRESSED);
            } else if(computerMove.column == 1){
                cells[4].setText(Constants.COMPUTER_PRESSED);
            } else if(computerMove.column == 2){
                cells[5].setText(Constants.COMPUTER_PRESSED);
            }
        } else if(computerMove.row == 2){
            if(computerMove.column == 0){
                cells[6].setText(Constants.COMPUTER_PRESSED);
            } else if(computerMove.column == 1){
                cells[7].setText(Constants.COMPUTER_PRESSED);
            } else if(computerMove.column == 2){
                cells[8].setText(Constants.COMPUTER_PRESSED);
            }
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
     * Button Handler for button number 0
     */
    private class ButtonHandler0 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            turn(0, 0, (JButton) e.getSource());
        }
    }

    /**
     * Button Handler for button number 1
     */
    private class ButtonHandler1 implements ActionListener {
        public void actionPerformed(ActionEvent e) { turn(0,1,(JButton)e.getSource()); }
    }

    /**
     * Button Handler for button number 2
     */
    private class ButtonHandler2 implements ActionListener {
        public void actionPerformed(ActionEvent e) { turn(0,2,(JButton)e.getSource()); }
    }

    /**
     * Button Handler for button number 3
     */
    private class ButtonHandler3 implements ActionListener {
        public void actionPerformed(ActionEvent e) { turn(1,0,(JButton)e.getSource()); }
    }

    /**
     * Button Handler for button number 4
     */
    private class ButtonHandler4 implements ActionListener {
        public void actionPerformed(ActionEvent e) { turn(1,1,(JButton)e.getSource()); }
    }

    /**
     * Button Handler for button number 5
     */
    private class ButtonHandler5 implements ActionListener {
        public void actionPerformed(ActionEvent e) { turn(1,2,(JButton)e.getSource()); }
    }

    /**
     * Button Handler for button number 6
     */
    private class ButtonHandler6 implements ActionListener {
        public void actionPerformed(ActionEvent e) { turn(2,0,(JButton)e.getSource()); }
    }

    /**
     * Button Handler for button number 7
     */
    private class ButtonHandler7 implements ActionListener {
        public void actionPerformed(ActionEvent e) { turn(2,1,(JButton)e.getSource()); }
    }

    /**
     * Button Handler for button number 8
     */
    private class ButtonHandler8 implements ActionListener {
        public void actionPerformed(ActionEvent e) { turn(2,2,(JButton)e.getSource()); }
    }
}


