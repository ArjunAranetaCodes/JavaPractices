import java.util.*;

public class CustomList extends AbstractList<String> {
    private final List<String> delegate;

    public CustomList(List<String> delegate) {
        this.delegate = Objects.requireNonNull(delegate);
    }

    @Override
    public String get(int index) {
        return delegate.get(index);
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof List)) {
            return false;
        } else {
            List<?> other = (List<?>) obj;
            return delegate.equals(other);
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        for (String str : delegate) {
            result = 31 * result + ((str == null) ? 0 : str.hashCode());
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> original = Arrays.asList("apple", "banana", "cherry");
        CustomList customList = new CustomList(original);

        System.out.println("Original list: " + original);
        System.out.println("Custom list: " + customList);

        System.out.println("Equal?: " + original.equals(customList));
        System.out.println("Hash code equal?: " + (original.hashCode() == customList.hashCode()));

        Map<List<String>, Integer> map = new HashMap<>();
        map.put(original, 1);
        System.out.println("Map contains key?: " + map.containsKey(customList));
    }
}