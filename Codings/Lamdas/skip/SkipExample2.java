import java.util.stream.IntStream;

public class SkipExample2 {
    public static void main(String[] args) {
        IntStream.range(1, 10)
                .skip(3)
                .limit(5)
                .forEach(System.out::println);
    }
}
