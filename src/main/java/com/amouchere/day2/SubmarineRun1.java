package com.amouchere.day2;

public class SubmarineRun1 implements Submarine {
    int horizontalPosition = 0;
    int verticalPosition = 0;

    @Override
    public void forward(int value) {
        horizontalPosition += value;
    }

    @Override
    public void down(int value) {
        verticalPosition += value;
    }

    @Override
    public void up(int value) {
        verticalPosition -= value;
    }

    @Override
    public int getSubmarineValue() {
        return verticalPosition * horizontalPosition;
    }
}
