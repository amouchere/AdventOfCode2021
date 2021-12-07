package com.amouchere.day1;


import com.amouchere.AdventOfCode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1 extends AdventOfCode {

    List<String> inputs;


    public Day1(File inputFile) {
        inputs = getPath(inputFile);
    }

    public static void main(String[] args) throws IOException {
        Day1 day = new Day1(new File("src/main/resources/inputs_d1.txt"));
        day.run2();

    }

    // part 1
    public void run() {
        LOGGER.info(">>>>>>>> RUN1");


        int increased = 0;
        int previous = 0;
        for (String line : inputs) {
            LOGGER.info(line);
            int current = Integer.parseInt(line);

            if (previous != 0 && current > previous) {
                increased++;
            }
            previous = current;

        }
        LOGGER.info("increased " + increased);
    }

    // part 1
    public void run2() {
        LOGGER.info(">>>>>>>> RUN2");


        int increased = 0;
        int previous = 0;

        List<SlidingMeasurement> slidingMeasurements = new ArrayList<>();
        for (int i = 0; i < inputs.size() - 2; i += 1) {

            SlidingMeasurement slidingMeasurement = new SlidingMeasurement();
            slidingMeasurement.addMeasure(Integer.parseInt(inputs.get(i)));
            slidingMeasurement.addMeasure(Integer.parseInt(inputs.get(i + 1)));
            slidingMeasurement.addMeasure(Integer.parseInt(inputs.get(i + 2)));

            slidingMeasurements.add(slidingMeasurement);
        }

        LOGGER.info("nb sliding " + slidingMeasurements.size());
        for (SlidingMeasurement line : slidingMeasurements) {

            if (previous != 0 && line.sum() > previous) {
                increased++;
            }
            previous = line.sum();

        }
        LOGGER.info("increased " + increased);
    }


}