interface Calculator {
    int calculate(int x, int y);
}

public class Main {
    public static void main(String[] args) {
        Calculator addition = (var x, var y) -> x + y;
        System.out.println("Sum: " + addition.calculate(5, 3));
    }
}
 