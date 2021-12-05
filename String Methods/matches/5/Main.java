public class Main {
    public static void main(String[] args) {
        String date = "2024-01-24";
        if (date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("Date format is valid.");
        } else {
            System.out.println("Invalid date format.");
        }
    }
}
  