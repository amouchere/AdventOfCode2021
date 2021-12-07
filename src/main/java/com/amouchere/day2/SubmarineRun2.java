package com.amouchere.day2;

public class SubmarineRun2 implements Submarine {
    int horizontalPosition = 0;
    int verticalPosition = 0;
    int aim = 0;

    /*
    down X increases your aim by X units.
    up X decreases your aim by X units.
    forward X does two things:
        It increases your horizontal position by X units.
        It increases your depth by your aim multiplied by X.

     */
    public void forward(int value) {
        horizontalPosition += value;
        verticalPosition += aim * value;
    }

    public void down(int value) {
        aim += value;
    }

    public void up(int value) {
        aim -= value;
    }

    public int getSubmarineValue() {
        return verticalPosition * horizontalPosition;
    }
}
