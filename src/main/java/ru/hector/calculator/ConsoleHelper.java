package ru.hector.calculator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    public static String readLine() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printLine(String line) {
        System.out.println(line);
    }

    public static void printLine(int i) {
        System.out.println(i);
    }
}
