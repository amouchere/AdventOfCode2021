package com.amouchere.day3;

import java.util.logging.Logger;

public class Rate {
    int[] counter;
    String gammaRate = "";
    String epsilonRate = "";
    Logger LOGGER;

    public Rate(int i, Logger LOGGER) {
        counter = new int[i];
        this.LOGGER = LOGGER;
    }

    public void computeGammaRate() {
        for (int j : counter) {
            if (j > 0) {
                gammaRate = gammaRate.concat("1");
            } else {
                gammaRate = gammaRate.concat("0");
            }
        }
    }


    public void computeEpsilonRate() {
        for (int j : counter) {
            if (j > 0) {
                epsilonRate = epsilonRate.concat("0");
            } else {
                epsilonRate = epsilonRate.concat("1");
            }
        }
    }

    public int getEpsilonRateAsDecimal() {
        return binaryToInt(epsilonRate);
    }

    public int getGammaRateAsDecimal() {
        return binaryToInt(gammaRate);
    }

    private int binaryToInt(String string) {
        return Integer.parseInt(string, 2);
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
}
