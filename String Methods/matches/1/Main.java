public class Main {
    public static void main(String[] args) {
        String input = "Hello123";
        if (input.matches("^[a-zA-Z0-9]*$")) {
            System.out.println("Input matches the pattern.");
        } else {
            System.out.println("Input does not match the pattern.");
        }
    }
}
  