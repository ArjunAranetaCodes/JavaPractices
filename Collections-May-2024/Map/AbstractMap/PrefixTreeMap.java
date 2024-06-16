import java.util.AbstractMap;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Set;

public class PrefixTreeMap extends AbstractMap<String, String> {
    private Map<String, String> map = new HashMap<>();
    private TreeMap<String, String> prefixMap = new TreeMap<>();

    @Override
    public Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }

    @Override
    public String put(String key, String value) {
        map.put(key, value);
        for (int i = 1; i < key.length(); i++) {
            prefixMap.put(key.substring(0, i), key);
        }
        return value;
    }

    @Override
    public String get(Object key) {
        return map.get(key);
    }

    public Map<String, String> getPrefixMap(String prefix) {
        TreeMap<String, String> result = new TreeMap<>();
        for (Map.Entry<String, String> entry : prefixMap.subMap(prefix, prefix + "~")) {
            result.put(entry.getValue(), map.get(entry.getValue()));
        }
        return result;
    }

    public static void main(String[] args) {
        PrefixTreeMap map = new PrefixTreeMap();

        map.put("apple", "fruit");
        map.put("app", "application");
        map.put("banana", "fruit");

        System.out.println("Prefix tree map:");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Prefix map for 'app':");
        for (Map.Entry<String, String> entry : map.getPrefixMap("app").entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}