import java.util.LinkedList;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        String[] colorsArray = new String[colors.size()];
        colors.toArray(colorsArray);

        System.out.println("Array from LinkedList:");
        for (String color : colorsArray) {
            System.out.println(color);
        }
    }
}
