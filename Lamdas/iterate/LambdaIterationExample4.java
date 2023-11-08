import java.util.Arrays;

public class LambdaIterationExample4 {
    public static void main(String[] args) {
        String[] languages = {"Java", "Python", "C++", "JavaScript"};

        // Using lambda expression to iterate through the array
        Arrays.asList(languages).forEach(language -> System.out.println("Programming Language: " + language));
    }
}
