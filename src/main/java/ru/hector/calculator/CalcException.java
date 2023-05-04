package ru.hector.calculator;

public class CalcException extends Exception {
    public CalcException(String message) {
        System.out.println("Error in program: " + message);
    }
}
