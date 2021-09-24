public class Main {
    public static void main(String[] args) {
        String numericInput = "12345";
        if (numericInput.matches("\\d+")) {
            System.out.println("Input is a valid numeric value.");
        } else {
            System.out.println("Input is not a valid numeric value.");
        }
    }
}
 