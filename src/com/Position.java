package com;

/**
 * Created by Daniel on 9/22/2014.
 */
public class Position {
    int row;
    int column;
    int value;

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
}