package NewCalc;

import java.io.IOException;
import java.util.Scanner;

public class Main {

     static char operation;
     static int number1;
     static int number2;
     static int result;

    public static void main(String[] args) throws IOException {
        System.out.println("Калькулятор предназначен для вычисления выражений с использованием арабских и римских чисел от 1 (I) до 10 (X)");
        System.out.println("Введите данные для вычисления");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Введена пустая строка. Подсчет невозможен");
        } else{
            System.out.println(calc(input));
            }

}
    public static String calc(String input) throws IOException {
        char[] lineChar = new char[10];
        for (int i = 0; i < input.length(); i++) {
            lineChar[i] = input.charAt(i);
            if (lineChar[i] == '+') {
                operation = '+';
            }
            if (lineChar[i] == '-') {
                operation = '-';
            }
            if (lineChar[i] == '*') {
                operation = '*';
            }
            if (lineChar[i] == '/') {
                operation = '/';
            }

        }
        String lineCharString = String.valueOf(lineChar);
        String[] parts = lineCharString.split("[+-/*]");
        String operand01 = parts[0];
        String string02 = parts[1];
        String operand02 = string02.trim();
        try {
            String string03 = parts[2];
            string03 = string03.trim();
            throw new IOException("Ведены символы за пределами допустимых параметров");
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        try {
            int i1 = Integer.parseInt(operand01);
            int i2 = Integer.parseInt(operand02);
            if(i1<11 && i2<11 && i1>0 && i2>0 ) {
                int result = calculated(i1, i2, operation);
                input = String.valueOf(result);
             } else {
                throw new IllegalArgumentException("Введены цифры за пределами допустимых значений");
            }
        } catch (NumberFormatException exception) {
            number1 = romanToNumber(operand01);
            number2 = romanToNumber(operand02);
            result = calculated(number1, number2, operation);
                if (result <= 0) {
                    throw new IOException("Римские цифры могут быть только положительными");
                } else {
                    String resultRoman = arabRome(result);
                    input = resultRoman;
                }
            }
          return input;
    }
     static int romanToNumber (String operand) throws  IllegalArgumentException  {
         switch (operand) {
             case "I":
                 return 1;
             case "II":
                 return 2;
             case "III":
                 return 3;
             case "IV":
                 return 4;
             case "V":
                 return 5;
             case "VI":
                 return 6;
             case "VII":
                 return 7;
             case "VIII":
                 return 8;
             case "IX":
                 return 9;
             case "X":
                 return 10;
             default:
                 throw new IllegalArgumentException("Введенные данные не соответствуют заданным параметрам");
         }

     }
         static String arabRome (int Rome) {
             String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII",
                     "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI",
                     "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
                     "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                     "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                     "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII",
                     "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII",
                     "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII",
                     "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
             String s = roman[Rome];
             return s;
             }

     static int calculated (int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }
        return result;
    }
}








