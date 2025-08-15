public class SwitchUnnamedPattern {
    public static void main(String[] args) {
        Object obj = 42;

        String result = switch (obj) {
            case String _ -> "It's a string!";
            case Integer _ -> "It's an integer!";
            case null, default -> "Unknown type or null";
        };

        System.out.println(result);
    }
} 