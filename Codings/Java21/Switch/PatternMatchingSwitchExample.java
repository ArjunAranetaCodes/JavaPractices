public class PatternMatchingSwitchExample {

    public static void main(String[] args) {
        Object value = "Hello, Java 21!";

        // Using pattern matching for switch
        String result = switch (value) {
            case String s -> "It's a String: " + s;
            case Integer i -> "It's an Integer: " + i;
            case Double d -> "It's a Double: " + d;
            case null -> "It's null";
            default -> "Unknown type: " + value.getClass().getName();
        };

        System.out.println(result);

        Integer num1 = 2;

        String result2 = switch (num1) {
            case 1 -> "One";
            case 2 -> "Two";
            default -> "Error";
            };
        
        System.out.println(result2);

    }
}