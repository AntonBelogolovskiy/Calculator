package ru.hector.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Functions {

    private Functions() {
    }

    // метод возвращает список, где 0 и 2 элементы это аргументы, в 1 элемент - действие
    static List<String> checkLine(String input) throws CalcException {
        List<String> resList = new ArrayList<>();
        // в общем проверяем на правильный формат
        if (!input.matches("[\\dIXV]{1,4}\\s*[+-/*]\\s*[\\dIXV]{1,4}"))
            throw new CalcException("Неверный формат!!");

        // убираем все пробелы в строке
        String result = input.replaceAll("\\s", "");

        // разделяем строку на части по разделителю знака действия
        String[] temp = result.split("[+-/*]");
        // Проверим что оба аргумента одинакового типа чисел
        if ((!temp[0].matches("\\d{1,2}") && temp[1].matches("\\d{1,2}")) ||
                (!temp[1].matches("\\d{1,2}") && temp[0].matches("\\d{1,2}")))
            throw new CalcException("Числа должны быть одного типа!");

        // проверяем, что цифры арабские и значения чисел от 1 до 10
        if (temp[0].matches("\\d{1,2}")) {
            int arg1 = Integer.parseInt(temp[0]);
            int arg2 = Integer.parseInt(temp[1]);

            if (!(arg1 > 0 && arg1 <= 10) && !(arg2 > 0 && arg2 <= 10)) {
                throw new CalcException("Значение чисел должны быть от 1 до 10");
            }
            // проверяем римские цифры в диапазоне от I до X
        } else {
            getIntFromRoman(temp[0]);
            getIntFromRoman(temp[1]);
        }

        StringTokenizer stringTokenizer = new StringTokenizer(result, "+-*/", true);
        while (stringTokenizer.hasMoreTokens()) {
            resList.add(stringTokenizer.nextToken());
        }

        return resList;
    }
    static String intToRoman(int num) {
        var keys = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        var vals = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder ret = new StringBuilder();
        int ind = 0;

        while (ind < keys.length) {
            while (num >= vals[ind]) {
                var d = num / vals[ind];
                num = num % vals[ind];
                for (int i = 0; i < d; i++)
                    ret.append(keys[ind]);
            }
            ind++;
        }

        return ret.toString();
    }

    static int getIntFromRoman(String string) throws CalcException {
        try {
            return Roman.valueOf(string).getIndex();
        } catch (Exception e) {
            throw new CalcException("Римское число должно быть от I до X !!");
        }
    }

}
