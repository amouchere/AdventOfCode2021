package com.amouchere.day7;


import com.amouchere.AdventOfCode;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Day7 extends AdventOfCode {

    List<String> inputs;

    public Day7(File inputFile) {
        inputs = getPath(inputFile);
    }

    public static void main(String[] args) throws IOException {
        Day7 day = new Day7(new File("src/main/resources/inputs_dX.txt"));
        day.run();
    }

    // part 1
    public void run() {
        LOGGER.info(">>>>>>>> RUN1");


        for (String line : inputs) {
            LOGGER.info(line);


        }
        LOGGER.info("response : ");
    }

    // part 2
    public void run2() {
        for (String line : inputs) {
            LOGGER.info(line);

        }
        LOGGER.info("response : ");
    }
}