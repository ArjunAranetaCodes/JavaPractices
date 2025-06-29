public class PatternMatchingInstanceof {
    public static void main(String[] args) {
        Object obj = "Hello";
        if (obj instanceof String s) {
            System.out.println("obj is a String: " + s);
        }
    }
}