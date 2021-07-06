public class Main {
    public static void main(String[] args) {
        double dividend = 17.3;
        double divisor = 5.6;
        
        double result = Math.IEEEremainder(dividend, divisor);
        
        System.out.println("The IEEE remainder of " + dividend + " divided by " + divisor + " is: " + result);
    }
}
