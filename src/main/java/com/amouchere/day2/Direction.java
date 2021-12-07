package com.amouchere.day2;

public enum Direction {
    FORWARD("forward"),
    UP("up"),
    DOWN("down");

    private String label;

    Direction(String label) {
        this.label = label;
    }

    public static Direction fromString(String text) {
        for (Direction b : Direction.values()) {
            if (b.label.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
