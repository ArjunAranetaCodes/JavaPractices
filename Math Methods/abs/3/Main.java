import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger number = new BigInteger("-987654321");
        BigInteger absoluteValue = number.abs();
        System.out.println("Absolute value of " + number + " is: " + absoluteValue);
    }
}
 