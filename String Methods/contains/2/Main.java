import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        String keyword = "Banana";

        if (list.contains(keyword)) {
            System.out.println("The ArrayList contains the keyword.");
        } else {
            System.out.println("The ArrayList does not contain the keyword.");
        }
    }
}
