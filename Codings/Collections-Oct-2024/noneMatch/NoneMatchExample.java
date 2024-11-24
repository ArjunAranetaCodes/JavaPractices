import java.util.Arrays;
import java.util.List;

public class NoneMatchExample {
    public static void main(String[] args) {
        List<String> colors = Arrays.asList("red", "green", "blue", "yellow");

        boolean noneMatchResult = colors.stream()
                .noneMatch(color -> color.startsWith("z"));

        System.out.println("Does none of the colors start with 'z'? " + noneMatchResult);
    }
}