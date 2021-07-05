public class Main {
    public static void main(String[] args) {
        double dividend = 25.6;
        double divisor = 7.3;
        
        double result = Math.IEEEremainder(dividend, divisor);
        
        System.out.println("The IEEE remainder of " + dividend + " divided by " + divisor + " is: " + result);
    }
}
