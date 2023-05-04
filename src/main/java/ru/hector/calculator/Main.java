package ru.hector.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws CalcException {

//        String input = ConsoleHelper.readLine();

        String input = "VIII *  X";
        // 1,2,3,4,5,6,7,8,9,10
        // I,II,III,IV,V,VI,VII,VIII,IX,X

        // Пример для вычислений в массиве: 0 и 2 элементы - аргументы, 1 элемент - действие
        List<String> inputArray = Functions.checkLine(input);
//        ConsoleHelper.printLine(String.valueOf(inputArray));

        if (inputArray.get(0).matches("\\d")) {
            ConsoleHelper.printLine(Calculator.calculateArabic(inputArray));
        } else ConsoleHelper.printLine(Calculator.calculateRoman(inputArray));
    }
}
