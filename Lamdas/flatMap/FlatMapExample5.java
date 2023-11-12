import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample5 {
    public static void main(String[] args) {
        List<Optional<String>> names = Arrays.asList(
                Optional.of("John"),
                Optional.empty(),
                Optional.of("Jane"),
                Optional.of("Bob")
        );

        List<String> nonEmptyNames = names.stream()
                .flatMap(opt -> opt.map(Stream::of).orElseGet(Stream::empty))
                .collect(Collectors.toList());

        System.out.println(nonEmptyNames);
    }
}
