package com.amouchere.dayXX;


import com.amouchere.AdventOfCode;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DayX extends AdventOfCode {

    List<String> inputs;

    public DayX(File inputFile) {
        inputs = getPath(inputFile);
    }

    public static void main(String[] args) throws IOException {
        DayX day = new DayX(new File("src/main/resources/inputs_XX.txt"));
        day.run2();
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