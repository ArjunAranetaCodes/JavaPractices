public class Main {
    public static void main(String[] args) {
        double dividend = 15.8;
        double divisor = 4.2;
        
        double result = Math.IEEEremainder(dividend, divisor);
        
        System.out.println("The IEEE remainder of " + dividend + " divided by " + divisor + " is: " + result);
    }
}
