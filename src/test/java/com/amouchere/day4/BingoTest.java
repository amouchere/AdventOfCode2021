package com.amouchere.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BingoTest {

    @Test
    void bingo_should_not_win() {
        Bingo bingo = new Bingo();
        List<Integer> initList = new ArrayList<>();
        for (int i = 1; i < 26; i++) {
            initList.add(i);
        }

        bingo.init(initList);

        Assertions.assertFalse(bingo.hasWin());

        bingo.processNumber(1);
        bingo.processNumber(2);
        bingo.processNumber(7);
        bingo.processNumber(8);
        bingo.processNumber(20);

        Assertions.assertFalse(bingo.hasWin());
    }

    @Test
    void bingo_should_win_line() {
        Bingo bingo = new Bingo();
        List<Integer> initList = new ArrayList<>();
        for (int i = 1; i < 26; i++) {
            initList.add(i);
        }

        bingo.init(initList);

        Assertions.assertFalse(bingo.hasWin());

        bingo.processNumber(1);
        Assertions.assertFalse(bingo.hasWin());
        bingo.processNumber(2);
        Assertions.assertFalse(bingo.hasWin());
        bingo.processNumber(3);
        Assertions.assertFalse(bingo.hasWin());
        bingo.processNumber(4);
        Assertions.assertFalse(bingo.hasWin());
        bingo.processNumber(5);
        Assertions.assertTrue(bingo.hasWin());
    }

    @Test
    void bingo_should_win_column() {
        Bingo bingo = new Bingo();
        List<Integer> initList = new ArrayList<>();
        for (int i = 1; i < 26; i++) {
            initList.add(i);
        }

        bingo.init(initList);

        Assertions.assertFalse(bingo.hasWin());

        bingo.processNumber(1);
        Assertions.assertFalse(bingo.hasWin());
        bingo.processNumber(6);
        Assertions.assertFalse(bingo.hasWin());
        bingo.processNumber(11);
        Assertions.assertFalse(bingo.hasWin());
        bingo.processNumber(16);
        Assertions.assertFalse(bingo.hasWin());
        bingo.processNumber(21);

        Assertions.assertTrue(bingo.hasWin());

    }

}