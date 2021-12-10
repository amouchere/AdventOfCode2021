package com.amouchere.day4;


import com.amouchere.AdventOfCode;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Day4 extends AdventOfCode {

    List<String> inputs;

    public Day4(File inputFile) {
        inputs = getPath(inputFile);
    }

    public static void main(String[] args) throws IOException {
        Day4 day = new Day4(new File("src/main/resources/inputs_d4.txt"));
        day.run2();
    }

    // part 1
    public void run1() {
        LOGGER.info(">>>>>>>> RUN1");

        List<Integer> numberList = initNumberList();
        List<Bingo> bingoList = initBingoGrids();


        int result = play(numberList, bingoList);

        LOGGER.info("response : " + result);
    }


    // part 2
    public void run2() {
        LOGGER.info(">>>>>>>> RUN2");

        List<Integer> numberList = initNumberList();
        List<Bingo> bingoList = initBingoGrids();


        int result = findLastBingoToWin(numberList, bingoList);

        LOGGER.info("response : " + result);
    }

    private List<Integer> initNumberList() {
        String numberListAsString = inputs.get(0);
        List<Integer> numberList =
                Arrays.stream(numberListAsString.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        LOGGER.info("number =" +
                numberList.stream().map(integer -> Integer.toString(integer))
                        .collect(Collectors.joining(" ")));
        return numberList;
    }

    private List<Bingo> initBingoGrids() {
        List<List<Integer>> numbersForBoard = new ArrayList<>();

        List<Integer> numbersForOneBoard = new ArrayList<>();
        for (int i = 2; i < inputs.size(); i++) {
            if (!"".equals(inputs.get(i))) {
                numbersForOneBoard.addAll(
                        Arrays.stream(inputs.get(i).split(" "))
                                .filter(s -> !s.isEmpty())
                                .map(Integer::parseInt
                                )
                                .collect(Collectors.toList())
                );
            } else {
                numbersForBoard.add(new ArrayList<>(numbersForOneBoard));
                numbersForOneBoard = new ArrayList<>();
            }
        }
        numbersForBoard.add(new ArrayList<>(numbersForOneBoard));

        List<Bingo> bingoList = new ArrayList<>();
        for (List<Integer> list : numbersForBoard) {
            Bingo b = new Bingo();
            b.init(list);
            bingoList.add(b);
        }
        return bingoList;
    }

    private int play(List<Integer> numberList, List<Bingo> bingoList) {
        for (Integer drawnNumber : numberList) {
            for (Bingo bingo : bingoList) {
                bingo.processNumber(drawnNumber);
                if (bingo.hasWin()) {
                    return bingo.sumOfUnmark() * drawnNumber;
                }
            }
        }
        return 0;
    }

    private int findLastBingoToWin(List<Integer> numberList, List<Bingo> bingoList) {
        Set<Integer> bingoIdHasWin = new HashSet<>();
        for (Integer drawnNumber : numberList) {
            for (Bingo bingo : bingoList) {
                bingo.processNumber(drawnNumber);
                if (bingo.hasWin()) {
                    bingoIdHasWin.add(bingo.hashCode());
                    if (bingoList.size() == bingoIdHasWin.size()) {
                        return bingo.sumOfUnmark() * drawnNumber;
                    }
                }
            }
        }
        return 0;
    }

}