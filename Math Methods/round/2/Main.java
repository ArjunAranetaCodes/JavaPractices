import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        double number = 15.6789;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String roundedNumber = decimalFormat.format(number);
        System.out.println("Original number: " + number);
        System.out.println("Rounded number: " + roundedNumber);
    }
}
