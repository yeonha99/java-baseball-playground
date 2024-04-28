package calculator;

public class Calculator {
    public static int calculate(String[] operator) {
        validate(operator);
        int result = Integer.parseInt(operator[0]);
        for (int i = 1; i < operator.length; i += 2) {
            switch (operator[i]) {
                case "+":
                    result = add(result, Integer.parseInt(operator[i + 1]));
                    break;
                case "-":
                    result = subtract(result, Integer.parseInt(operator[i + 1]));
                    break;
                case "*":
                    result = multiply(result, Integer.parseInt(operator[i + 1]));
                    break;
                case "/":
                    result = divide(result, Integer.parseInt(operator[i + 1]));
                    break;
                default:
                    throw new IllegalArgumentException("연산자가 유효하지 않습니다.");
            }
        }
        return result;
    }

    private static void validate(String[] operator) {
        if (operator.length < 3 || operator.length % 2 != 1) {
            throw new IllegalArgumentException("연산식이 유효하지 않습니다.");
        }
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static int divide(int a, int b) {
        return a / b;
    }
}
