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