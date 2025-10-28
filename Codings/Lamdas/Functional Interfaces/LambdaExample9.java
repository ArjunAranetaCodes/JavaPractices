import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class LambdaExample9 {
    public static void main(String[] args) {
        List<String> keys = Arrays.asList("One", "Two", "Three");
        List<Integer> values = Arrays.asList(1, 2, 3);

        Map<String, Integer> map = combineLists(keys, values, (k, v) -> new HashMap.SimpleEntry<>(k, v));
        System.out.println(map);
    }

    private static <K, V, R> Map<K, V> combineLists(List<K> keys, List<V> values, BiFunction<K, V, R> combiner) {
        Map<K, V> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }
}
