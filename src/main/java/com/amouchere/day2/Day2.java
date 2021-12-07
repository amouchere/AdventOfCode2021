package com.amouchere.day2;


import com.amouchere.AdventOfCode;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Day2 extends AdventOfCode {

    List<String> inputs;


    public Day2(File inputFile) {
        inputs = getPath(inputFile);
    }

    public static void main(String[] args) throws IOException {
        Day2 day = new Day2(new File("src/main/resources/inputs_d2.txt"));
        day.run();
        day.run2();

    }

    // part 1
    public void run() {
        LOGGER.info(">>>>>>>> RUN1");

        Submarine submarine = new SubmarineRun1();

        moveSubmarine(submarine);
        LOGGER.info("value " + submarine.getSubmarineValue());
    }

    // part 1
    public void run2() {
        LOGGER.info(">>>>>>>> RUN2");
        Submarine submarine = new SubmarineRun2();

        moveSubmarine(submarine);
        LOGGER.info("value " + submarine.getSubmarineValue());

    }

    private void moveSubmarine(Submarine submarine) {
        for (String line : inputs) {
            String[] inputs = line.split(" ");
            Direction direction = Direction.fromString(inputs[0]);
            int value = Integer.parseInt(inputs[1]);

            // LOGGER.info(line);

            switch (direction) {
                case UP:
                    submarine.up(value);
                    break;
                case DOWN:
                    submarine.down(value);
                    break;
                case FORWARD:
                    submarine.forward(value);
                    break;
                default:
                    throw new IllegalArgumentException("Unknonw direction");
            }


        }
    }


}