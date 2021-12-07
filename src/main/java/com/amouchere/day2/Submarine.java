package com.amouchere.day2;

public class Submarine {
    int horizontalPosition = 0;
    int verticalPosition = 0;

    public void forward(int value) {
        horizontalPosition += value;
    }

    public void down(int value) {
        verticalPosition += value;
    }

    public void up(int value) {
        verticalPosition -= value;
    }

    public int getSubmarineValue() {
        return verticalPosition * horizontalPosition;
    }
}
