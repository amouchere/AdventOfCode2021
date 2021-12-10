package com.amouchere.day4;

import java.util.List;

public class Bingo {
    private final int GRID_SIZE = 5;
    private final Entry[][] grid;

    public Bingo() {
        this.grid = new Entry[GRID_SIZE][GRID_SIZE];
    }

    public void init(List<Integer> init) {
        int listIndex = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = new Entry(init.get(listIndex));
                listIndex++;
            }
        }
    }

    public int sumOfUnmark() {
        int result = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                Entry entry = grid[i][j];
                if (!entry.marked) {
                    result += entry.number;
                }
            }
        }
        return result;
    }

    public void processNumber(int number) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                Entry entry = grid[i][j];
                entry.mark(number);
            }
        }
    }

    public boolean hasWin() {
        // Vérification des lignes
        for (int i = 0; i < GRID_SIZE; i++) {
            boolean hasWin = true;
            for (int j = 0; j < GRID_SIZE; j++) {
                Entry entry = grid[i][j];
                if (!entry.marked) {
                    hasWin = false;
                }
            }
            if (hasWin) {
                return true;
            }
        }

        // Vérification des colonnes
        for (int i = 0; i < GRID_SIZE; i++) {
            boolean hasWin = true;
            for (int j = 0; j < GRID_SIZE; j++) {
                Entry entry = grid[j][i];
                if (!entry.marked) {
                    hasWin = false;
                }
            }
            if (hasWin) {
                return true;
            }
        }
        return false;
    }


    /**
     * An entry
     */
    public class Entry {
        private int number;
        private boolean marked;

        public Entry(int number) {
            this.number = number;
            marked = false;
        }

        public void mark(int number) {
            if (this.number == number) {
                marked = true;
            }
        }

    }
}
