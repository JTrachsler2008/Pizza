package Calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        ResourceBundle messages = ResourceBundle.getBundle("properties.Messages", Locale.GERMANY);
        Calculator calc = new Calculator();
        calc.calculator(messages);
    }

    public void calculator(ResourceBundle messages) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(messages.getString("num1"));
            BigDecimal num1 = scanner.nextBigDecimal();

            System.out.print(messages.getString("num2"));
            BigDecimal num2 = scanner.nextBigDecimal();

            System.out.print(messages.getString("operator"));
            String operator = scanner.next();

            BigDecimal result;
            switch (operator) {
                case "+":
                    result = num1.add(num2);
                    System.out.println(messages.getString("result") + " " + result);
                    break;
                case "-":
                    result = num1.subtract(num2);
                    System.out.println(messages.getString("result") + " " + result);
                    break;
                case "*":
                    result = num1.multiply(num2);
                    System.out.println(messages.getString("result") + " " + result);
                    break;
                case "%":
                    result = num1.remainder(num2);
                    System.out.println(messages.getString("result") + " " + result);
                    break;
                case "++":
                    num1 = num1.add(BigDecimal.ONE);
                    num2 = num2.add(BigDecimal.ONE);
                    System.out.println(messages.getString("result") + " Nummer 1: " + num1);
                    System.out.println(messages.getString("result") + " Nummer 2: " + num2);
                  break;
                case "--":
                    num1 = num1.subtract(BigDecimal.ONE);
                    num2 = num2.subtract(BigDecimal.ONE);
                    System.out.println(messages.getString("result") + " Nummer 1: " + num1);
                    System.out.println(messages.getString("result") + " Nummer 2: " + num2);
                    break;
                case "/":
                    if (num2.compareTo(BigDecimal.ZERO) != 0) {
                        result = num1.divide(num2, MathContext.DECIMAL128);
                        System.out.println(messages.getString("result") + " " + result);
                    } else {
                        System.out.println(messages.getString("error_zero_division"));
                    }
                    break;

                default:
                    System.out.println(messages.getString("invalid_operator"));
            }
        }
    }
}

