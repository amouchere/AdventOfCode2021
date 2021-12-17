package com.amouchere.day3;


import com.amouchere.AdventOfCode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 extends AdventOfCode {

    List<String> inputs;

    public Day3(File inputFile) {
        inputs = getPath(inputFile);
    }

    public static void main(String[] args) throws IOException {
        Day3 day = new Day3(new File("src/main/resources/inputs_d3.txt"));
        day.run1();
    }

    // part 1
    public void run1() {
        LOGGER.info(">>>>>>>> RUN1");

        Rate rate = new Rate(inputs.get(0).length(), LOGGER);

        for (String line : inputs) {
            LOGGER.info(line);
            rate.analyseLine(line);
        }

        rate.computeGammaRate();
        LOGGER.info("response : " + rate.gammaRate);
        rate.computeEpsilonRate();
        LOGGER.info("response : " + rate.epsilonRate);
        LOGGER.info("response : " + rate.getGammaRateAsDecimal() * rate.getEpsilonRateAsDecimal());

    }

    // part 2
    public void run2() {
        int i = 0;
        List<String> oxygenList = new ArrayList(inputs);
        while (oxygenList.size() != 1) {
            Rate2 rate = new Rate2(oxygenList.get(0).length(), LOGGER);

            for (String line : oxygenList) {
                LOGGER.info(line);
                rate.analyseLine(line);
            }
            rate.computeOxygenBitCriteria();

            int finalI = i;
            LOGGER.info("bitCriterias is " + rate.bitCriterias[finalI]);
            oxygenList = oxygenList.stream().filter(line -> {
                char[] chars = line.toCharArray();
                return (Integer.parseInt(chars[finalI] + "") == (rate.bitCriterias[finalI]));
            }).collect(Collectors.toList());

            LOGGER.info(oxygenList.size() + "");
            LOGGER.info(String.join(",", oxygenList));
            i++;
        }

        LOGGER.info("===================");
        List<String> co2List = new ArrayList(inputs);
        i = 0;
        while (co2List.size() != 1) {
            Rate2 rate = new Rate2(co2List.get(0).length(), LOGGER);

            for (String line : co2List) {
                LOGGER.info(line);
                rate.analyseLine(line);
            }
            rate.computeCO2BitCriteria();

            int finalI = i;
            LOGGER.info("bitCriterias is " + rate.bitCriterias[finalI]);
            co2List = co2List.stream().filter(line -> {
                char[] chars = line.toCharArray();
                return (Integer.parseInt(chars[finalI] + "") == (rate.bitCriterias[finalI]));
            }).collect(Collectors.toList());

            LOGGER.info(co2List.size() + "");
            LOGGER.info(String.join(",", co2List));
            i++;
        }
        LOGGER.info("response oxygen: " + oxygenList.get(0));
        LOGGER.info("response CO2   : " + co2List.get(0));
        LOGGER.info("response : " + binaryToInt(oxygenList.get(0)) * binaryToInt(co2List.get(0)));

    }

    private int binaryToInt(String string) {
        return Integer.parseInt(string, 2);
    }
}