package com;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Daniel on 9/29/2014.
 */
public class TicTacToeBoard extends JFrame{

    private JButton[] cells;
    private JButton exitButton;
    private JButton initButton;
    private JLabel score;

    private Container content;
    /**
     * This is the constructor.
     */
    public TicTacToeBoard(){
        //Necessary initialization code
        setTitle(Constants.TITLE);
        setSize(Constants.WIDTH, Constants.HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        content = getContentPane();
        content.setLayout(new GridLayout(4,3));

        //Create cells and handlers
        cells=new JButton[9];
        for(int i=0; i<Constants.MAX_NUMBER_OF_BUTTONS; i++)
        {
            char ch=(char)('0'+i+1);
            cells[i]=new JButton(""+ch);
            cells[i].addActionListener(new ButtonHandler());
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

    private void init() {
        //Initialize text in buttons
        for(int i=0; i<9; i++){
            cells[i].setText(i + "");
        }

        //Initialize the other buttons text
        exitButton.setText(Constants.EXIT_BUTTON_TEXT);
        initButton.setText(Constants.INIT_BUTTON_TEXT);

        score.setText(Constants.INITIAL_SCORE_TEXT);

        setVisible(true);
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Get button pressed
            JButton pressed=(JButton)(e.getSource());
            pressed.setText("Happy");
        }
    }

    /**
     * This is the Main method building the GUI.
     * @param args
     */
    public static void main(String[] args){
        TicTacToeBoard newGame = new TicTacToeBoard();
    }
}


