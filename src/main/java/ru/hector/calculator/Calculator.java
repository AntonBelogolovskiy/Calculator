package ru.hector.calculator;

import java.util.List;

public class Calculator {

    private Calculator() {
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }

    public static int diff(int a, int b) {
        return a - b;
    }

    static String calculateRoman(List<String> inputArray) throws CalcException {
        int arg1 = Functions.getIntFromRoman(inputArray.get(0));
        int arg2 = Functions.getIntFromRoman(inputArray.get(2));
        return Functions.intToRoman(calc(arg1, arg2, inputArray.get(1)));
    }

    static int calculateArabic(List<String> inputArray) throws CalcException {
        int arg1 = Integer.parseInt(inputArray.get(0));
        int arg2 = Integer.parseInt(inputArray.get(2));
        return calc(arg1, arg2, inputArray.get(1));
    }

    private static int calc(int a, int b, String method) throws CalcException {
        int res;
        switch (method) {
            case "+":
                res = Calculator.sum(a, b);
                break;
            case "-":
                res = Calculator.diff(a, b);
                break;
            case "*":
                res = Calculator.multiply(a, b);
                break;
            case "/":
                res = Calculator.divide(a, b);
                break;
            default:
                throw new CalcException("Что-то пошло не так");
        }
        return res;
    }
}
