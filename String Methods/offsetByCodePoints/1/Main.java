public class Main {
    public static void main(String[] args) {
        String str = "Hello, 世界!";
        int index = str.offsetByCodePoints(2, 1);
        System.out.println("Offset of the third code point from the second code point: " + index);
    }
}
 