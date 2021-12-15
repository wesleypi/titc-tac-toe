package tictactoe.model;

import java.util.Arrays;

public class Board {
    private final char[][] elements;

    public Board (int size){
        elements = new char[size][size];
        init();
    }

    private void init() {
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                elements[i][j] = Character.MIN_VALUE;
            }
        }
    }

    public void setElement(int line, int column, char player) {
        this.elements[line][column] = player;
    }

    public char[][] getElements() {
        return elements;
    }
    public char getElement(int row, int column){
        return this.elements[row][column];
    }

    public boolean isEmptyElement(int row, int column){
        return isEmptyElement(getElement(row, column));
    }

    public boolean isEmptyElement(char element){
        return element == Character.MIN_VALUE;
    }

    public int size(){
        return elements.length;
    }

    public boolean isInvalidPosition(int row, int column){
        return isInvalid(row) || isInvalid(column);
    }

    private boolean isInvalid(int position) {
        return position < 0 || position >= size();
    }

    public boolean isFull() {
        for (int i = 0; i < size(); i++ ) {
            for (int j = 0; j < size(); j++) {
                if (this.elements[i][j] == '\0') return false;
            }
        }
        return true;
    }
}