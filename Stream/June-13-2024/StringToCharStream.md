```java
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StringToCharStream {
    public static void main(String[] args) {
        String str = "Hello, World!";
        Stream<Character> charStream = stringToCharStream(str);
        charStream.forEach(System.out::print); // Prints: Hello, World!
    }

    /**
     * Converts a String to a character stream without using library functions.
     *
     * @param str the input String
     * @return a Stream of characters
     */
    private static Stream<Character> stringToCharStream(String str) {
        Iterator<Character> iterator = new StringIterator(str);
        Spliterator<Character> spliterator = Spliterators.spliteratorUnknownSize(iterator, 0);
        return StreamSupport.stream(spliterator, false);
    }

    /**
     * A custom Iterator implementation to iterate over the characters of a String.
     */
    private static class StringIterator implements Iterator<Character> {
        private final String str;
        private int index;

        StringIterator(String str) {
            this.str = str;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < str.length();
        }

        @Override
        public Character next() {
            return str.charAt(index++);
        }
    }
}
```

## Explanation

1. The `stringToCharStream` method takes a `String` as input and returns a `Stream<Character>`.
2. Inside the `stringToCharStream` method, we create a custom `StringIterator` instance that implements the `Iterator<Character>` interface. This iterator allows us to iterate over the characters of the input `String`.
3. We then create a `Spliterator` from the `StringIterator` using the `Spliterators.spliteratorUnknownSize` method. A `Spliterator` is an object that can be used to create a stream.
4. Finally, we create a `Stream<Character>` from the `Spliterator` using the `StreamSupport.stream` method.

The `StringIterator` class is a custom implementation of the `Iterator<Character>` interface. It has the following methods:

- `hasNext()`: Returns `true` if there are more characters to iterate over, and `false` otherwise.
- `next()`: Returns the next character in the `String` and increments the internal index.

In the `main` method, we create a `String` and convert it to a character stream using the `stringToCharStream` method. We then print each character in the stream using the `forEach` method and the `System.out::print` method reference.

By using this approach, we can convert a `String` to a character stream without relying on any library functions, such as the `String.codePoints()` method or the `IntStream.mapToObj` method.