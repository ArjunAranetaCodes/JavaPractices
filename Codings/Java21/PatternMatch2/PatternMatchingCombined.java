public class PatternMatchingCombined {
    public static void main(String[] args) {
        Object obj = "Hello";
        switch (obj) {
            case String s -> System.out.println("obj is a String: " + s);
            case Integer i -> System.out.println("obj is an Integer: " + i);
            default -> System.out.println("obj is something else");
        }
    }
}