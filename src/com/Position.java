package com;

/**
 * Created by Daniel on 9/22/2014.
 */
public class Position {
    //Private class properties
    private int row;
    private int column;
    private int value;

    /**
     * Constructor containing only value.
     * @param value
     */
    public Position (int value) {
        this(value, 0, 0);
    }

    /**
     * Constructor containing all parameters.
     * @param value
     * @param row
     * @param column
     */
    public Position (int value, int row, int column) {
        this.value = value;
        this.row = row;
        this.column = column;
    }

    /**
     * Method used to get the row
     * @return
     */
    public int getRow() {
        return row;
    }

    /**
     * Method used to set the row
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Method used to get the column
     * @return
     */
    public int getColumn() {
        return column;
    }

    /**
     * Method used to set the column
     * @param column
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Method used to get the value
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * Method used to set the value
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }
}