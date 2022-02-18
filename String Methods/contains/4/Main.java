public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Java Programming");

        String keyword = "Programming";

        if (sb.toString().contains(keyword)) {
            System.out.println("The StringBuilder contains the keyword.");
        } else {
            System.out.println("The StringBuilder does not contain the keyword.");
        }
    }
}
