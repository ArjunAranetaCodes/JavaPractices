public class Main {
    public static void main(String[] args) {
        double number = 3.14159;
        double roundedNumber = customRound(number, 2);
        System.out.println("Original number: " + number);
        System.out.println("Rounded number: " + roundedNumber);
    }

    private static double customRound(double value, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(value * scale) / scale;
    }
}
