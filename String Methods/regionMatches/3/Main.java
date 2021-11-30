public class Main {
    public static void main(String[] args) {
        String str = "Coding in Java is awesome!";
        int index = str.offsetByCodePoints(10, 3);
        System.out.println("Offset of the fourteenth code point from the eleventh code point: " + index);
    }
}
