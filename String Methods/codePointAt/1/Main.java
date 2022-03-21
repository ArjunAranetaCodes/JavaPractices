public class Main {
    public static void main(String[] args) {
        String str = "Hello";
        int index = 2;
        int codePoint = str.codePointAt(index);
        System.out.println("Code point at index " + index + ": " + codePoint);
    }
}
