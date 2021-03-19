public class Main {
    public static void main(String[] args) {
        Calculator<Integer> intCalculator = new IntegerCalculator();
        System.out.println(intCalculator.add(5, 3));  // Output: 8
        System.out.println(intCalculator.subtract(5, 3)); // Output: 2

        Calculator<Double> doubleCalculator = new DoubleCalculator();
        System.out.println(doubleCalculator.multiply(2.5, 3.0)); // Output: 7.5
        System.out.println(doubleCalculator.divide(8.0, 2.0));   // Output: 4.0
    }
}

interface Calculator<T> {
    T add(T a, T b);

    T subtract(T a, T b);

    T multiply(T a, T b);

    T divide(T a, T b);
}

class IntegerCalculator implements Calculator<Integer> {
    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    public Integer subtract(Integer a, Integer b) {
        return a - b;
    }

    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    public Integer divide(Integer a, Integer b) {
        return a / b;
    }
}

class DoubleCalculator implements Calculator<Double> {
    public Double add(Double a, Double b) {
        return a + b;
    }

    public Double subtract(Double a, Double b) {
        return a - b;
    }

    public Double multiply(Double a, Double b) {
        return a * b;
    }

    public Double divide(Double a, Double b) {
        return a / b;
    } 
