public class Main {
    public static void main(String[] args) {
        char ch = '7';

        if (Character.isDigit(ch)) {
            System.out.println("The character is a digit.");
        } else if (Character.isLetter(ch)) {
            System.out.println("The character is a letter.");
        } else {
            System.out.println("The character is neither a digit nor a letter.");
        }
    }
}
