## Map vs. FlatMap Example
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMapExample {
    public static void main(String[] args) {
        // Example for map()
        List<String> names = Arrays.asList("John", "Jane", "Bob", "Alice");
        List<Integer> nameLengths = names.stream()
                                         .map(String::length)
                                         .collect(Collectors.toList());
        System.out.println("Name lengths using map(): " + nameLengths); // [4, 4, 3, 5]

        // Example for flatMap()
        List<List<Integer>> numberSets = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        List<Integer> flattenedNumbers = numberSets.stream()
                                                   .flatMap(List::stream)
                                                   .collect(Collectors.toList());
        System.out.println("Flattened numbers using flatMap(): " + flattenedNumbers); // [1, 2, 3, 4, 5, 6, 7, 8, 9]

        // Another example for flatMap()
        List<String> words = Arrays.asList("Hello", "World", "Java", "Stream");
        List<String> characters = words.stream()
                                       .flatMap(word -> Arrays.stream(word.split("")))
                                       .filter(ch -> !ch.isEmpty())
                                       .distinct()
                                       .collect(Collectors.toList());
        System.out.println("Distinct characters using flatMap(): " + characters); // [H, e, l, o, W, r, d, J, a, v, S, t, m]
    }
}
```

**Output:**
```
Name lengths using map(): [4, 4, 3, 5]
Flattened numbers using flatMap(): [1, 2, 3, 4, 5, 6, 7, 8, 9]
Distinct characters using flatMap(): [H, e, l, o, W, r, d, J, a, v, S, t, m]
```

In the first example, the `map()` operation is used to transform each string in the `names` list to its length, resulting in a new list `nameLengths` containing the lengths of the names.

In the second example, the `flatMap()` operation is used to flatten a list of lists of integers (`numberSets`) into a single list `flattenedNumbers` containing all the integers.

The third example demonstrates another use case of `flatMap()`. It takes a list of words, splits each word into individual characters using the `split("")` method, and then flattens the resulting streams of characters into a single stream. Finally, it filters out empty strings, removes duplicates using `distinct()`, and collects the distinct characters into a list.

These examples illustrate the fundamental difference between `map()` and `flatMap()`: `map()` performs a one-to-one transformation, while `flatMap()` performs a one-to-many transformation and flattens the resulting streams.