import java.util.AbstractMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class SimpleMap extends AbstractMap<String, String> {
    private Map<String, String> map = new HashMap<>();

    @Override
    public Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }

    @Override
    public String put(String key, String value) {
        return map.put(key, value);
    }

    @Override
    public String get(Object key) {
        return map.get(key);
    }

    public static void main(String[] args) {
        SimpleMap map = new SimpleMap();

        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        System.out.println("Simple map:");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}