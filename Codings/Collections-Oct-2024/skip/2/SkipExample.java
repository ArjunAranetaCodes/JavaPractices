import java.util.stream.Stream;

public class SkipExample {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape"};
        Stream<String> wordStream = Stream.of(words);
        wordStream.skip(2) // skip the first 2 words
                .limit(3) // take the next 3 words
                .forEach(System.out::println);
    }
}