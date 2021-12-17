package com.amouchere.day6;

public class LanternFish {
    public static final int RESET_TIMER = 6;
    public static final int DEFAULT_TIMER = 8;
    private int timer;

    public LanternFish(int timer) {
        this.timer = timer;
    }

    public LanternFish() {
        this.timer = DEFAULT_TIMER;
    }

    public void decreaseTimer() {
        timer--;
    }

    public boolean isReady() {
        return timer == 0;
    }

    public void resetTimer() {
        this.timer = RESET_TIMER;
    }

    public String print() {
        return String.valueOf(timer);
    }

}
