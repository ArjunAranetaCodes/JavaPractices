import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        double amount = 12345.67;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

        String formattedAmount = currencyFormatter.format(amount);
        System.out.println("Formatted Amount: " + formattedAmount);
    }
}
  