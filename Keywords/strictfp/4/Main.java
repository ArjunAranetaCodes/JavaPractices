interface Calculator {
    strictfp double calculate(double num1, double num2);
}

public class Main implements Calculator {
    public strictfp double calculate(double num1, double num2) {
        return num1 / num2;
    }

    public static void main(String[] args) {
        Main calculator = new Main();
        double result = calculator.calculate(15.0, 3.0);
        System.out.println("Result: " + result);
    }
}
