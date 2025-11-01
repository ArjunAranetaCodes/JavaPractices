import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal value = new BigDecimal("-123.456");
        BigDecimal absoluteValue = value.abs();
        System.out.println("Absolute value of " + value + " is: " + absoluteValue);
    }
}
    