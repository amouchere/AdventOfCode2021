package com.amouchere.day3;

import java.util.logging.Logger;

public class Rate2 {
    int[] counter;
    int[] bitCriterias;
    Logger LOGGER;


    public Rate2(int i, Logger LOGGER) {
        counter = new int[i];
        bitCriterias = new int[i];
        this.LOGGER = LOGGER;
    }

    void analyseLine(String line) {
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if ("0".charAt(0) == aChar) {
                counter[i]--;
            } else {
                counter[i]++;
            }
        }
    }

    public void computeOxygenBitCriteria() {
        for (int i = 0; i < counter.length; i++) {

            if (counter[i] < 0) {
                bitCriterias[i] = 0;
            } else if (counter[i] > 0) {
                bitCriterias[i] = 1;
            } else {
                bitCriterias[i] = 1;

            }
        }
    }

    public void computeCO2BitCriteria() {
        for (int i = 0; i < counter.length; i++) {

            if (counter[i] < 0) {
                bitCriterias[i] = 1;
            } else if (counter[i] > 0) {
                bitCriterias[i] = 0;
            } else {
                bitCriterias[i] = 0;
            }
        }
    }
}
