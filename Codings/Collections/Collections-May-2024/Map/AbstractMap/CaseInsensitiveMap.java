import java.util.AbstractMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class CaseInsensitiveMap extends AbstractMap<String, String> {
    private Map<String, String> map = new HashMap<>();

    @Override
    public Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }

    @Override
    public String put(String key, String value) {
        return map.put(key.toLowerCase(), value);
    }

    @Override
    public String get(Object key) {
        return map.get(((String) key).toLowerCase());
    }

    public static void main(String[] args) {
        CaseInsensitiveMap map = new CaseInsensitiveMap();

        map.put("John", "Doe");
        map.put("Alice", "Smith");

        System.out.println("Case-insensitive map:");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Getting value for key 'JOHN': " + map.get("JOHN"));
    }
}