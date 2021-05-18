import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        double number = 123.456789;
        BigDecimal originalValue = new BigDecimal(number);
        BigDecimal roundedValue = originalValue.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("Original number: " + originalValue);
        System.out.println("Rounded number: " + roundedValue);
    }
}
