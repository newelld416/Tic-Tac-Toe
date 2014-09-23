package com;

/**
 * Created by Daniel on 9/22/2014.
 */
public class Position {
    int row;
    int column;
    int value;

    public Position (int value) {
        this(value, 0, 0);
    }

    public Position (int value, int row, int colum) {
        this.value = value;
        this.row = row;
        this.column = colum;
    }
}