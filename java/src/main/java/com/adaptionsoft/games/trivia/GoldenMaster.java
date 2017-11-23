package com.adaptionsoft.games.trivia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GoldenMaster {


    private static String goldenMaster = "golden-master.txt";;

    public static String readNext() throws IOException {
        return new String(Files.readAllBytes(Paths.get(goldenMaster)));

    }

    public static void write(int seed, String actual) throws FileNotFoundException {

        PrintWriter printWriter = new PrintWriter(goldenMaster);
        printWriter.print(actual);
        printWriter.flush();
        printWriter.close();
    }
}
