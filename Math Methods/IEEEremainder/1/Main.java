public class Main {
    public static void main(String[] args) {
        double dividend = 10.5;
        double divisor = 3.2;
        
        double result = Math.IEEEremainder(dividend, divisor);
        
        System.out.println("The IEEE remainder of " + dividend + " divided by " + divisor + " is: " + result);
    }
}
    