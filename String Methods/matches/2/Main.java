public class Main {
    public static void main(String[] args) {
        String email = "user@example.com";
        if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.println("Email address is valid.");
        } else {
            System.out.println("Invalid email address.");
        }
    }
}
