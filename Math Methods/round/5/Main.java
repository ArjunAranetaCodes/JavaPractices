import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        double number = 9.8765;
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#.##", symbols);
        String roundedNumber = decimalFormat.format(number);
        System.out.println("Original number: " + number);
        System.out.println("Rounded number: " + roundedNumber);
    }
}
