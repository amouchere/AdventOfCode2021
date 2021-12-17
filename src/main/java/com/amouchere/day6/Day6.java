package com.amouchere.day6;


import com.amouchere.AdventOfCode;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 extends AdventOfCode {

    List<String> inputs;

    public Day6(File inputFile) {
        inputs = getPath(inputFile);
    }

    public static void main(String[] args) throws IOException {
        Day6 day = new Day6(new File("src/main/resources/inputs_d6.txt"));
        day.run();
    }

    // part 1
    public void run() {
        LOGGER.info(">>>>>>>> RUN1");

        String inputLine = inputs.get(0);
        List<LanternFish> lanternFishList =
                Arrays.stream(inputLine.split(","))
                        .map(Integer::parseInt)
                        .map(LanternFish::new)
                        .collect(Collectors.toList());
        printListOfFish(lanternFishList);
        for (int i = 0; i < 80; i++) {
            int newFishToAddNb = 0;
            for (LanternFish lanternFish : lanternFishList) {
                if (lanternFish.isReady()) {
                    lanternFish.resetTimer();
                    newFishToAddNb++;
                } else {
                    lanternFish.decreaseTimer();
                }
            }
            while (newFishToAddNb > 0) {
                lanternFishList.add(new LanternFish());
                newFishToAddNb--;
            }
            //printListOfFish(newLanternFishList);
            LOGGER.info(i + "response : " + lanternFishList.size());
        }
    }

    private void printListOfFish(List<LanternFish> newLanternFishList) {
        LOGGER.info(newLanternFishList.stream().map(LanternFish::print)
                .collect(Collectors.joining(",")));
    }

    // part 2
    public void run2() {
        LOGGER.info("https://media.giphy.com/media/bPCwGUF2sKjyE/giphy.gif");

    }
}