public class Main {
    public static void main(String[] args) {
        double dividend = 8.9;
        double divisor = 2.5;
        
        double result = Math.IEEEremainder(dividend, divisor);
        
        System.out.println("The IEEE remainder of " + dividend + " divided by " + divisor + " is: " + result);
    }
}
