import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        double pi = 3.141592653589793;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        String formattedPi = decimalFormat.format(pi);
        System.out.println("Formatted Pi: " + formattedPi);
    }
}
