package com.amouchere;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public abstract class AdventOfCode {

    public static Logger LOGGER = null;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
        LOGGER = Logger.getLogger(AdventOfCode.class.getName());
    }


    public List<String> getPath(File input) {
        List<String> path = new ArrayList<>();
        try {
            Scanner sc = new Scanner(input);
            while (sc.hasNextLine()) {
                path.add(sc.nextLine());
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}