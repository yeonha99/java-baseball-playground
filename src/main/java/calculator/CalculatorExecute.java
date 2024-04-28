package calculator;

import java.util.Scanner;

public class CalculatorExecute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] operator = line.split(" ");
        int result = Calculator.calculate(operator);
        System.out.println(result);
    }
}
