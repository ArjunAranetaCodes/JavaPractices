//Exercise 3: Functional Calculator
//Description: Implement a functional calculator that performs basic arithmetic operations using lambdas.

public class FunctionalCalculator {
    public static void main(String[] args) {
        Calculator addition = (a, b) -> a + b;
        Calculator subtraction = (a, b) -> a - b;
        Calculator multiplication = (a, b) -> a * b;
        Calculator division = (a, b) -> a / b;

        int resultAdd = addition.calculate(10, 5);
        int resultSub = subtraction.calculate(15, 7);
        int resultMul = multiplication.calculate(6, 4);
        int resultDiv = division.calculate(20, 4);

        System.out.println("Addition: " + resultAdd);
        System.out.println("Subtraction: " + resultSub);
        System.out.println("Multiplication: " + resultMul);
        System.out.println("Division: " + resultDiv);
    }

    interface Calculator {
        int calculate(int a, int b);
    }
}
