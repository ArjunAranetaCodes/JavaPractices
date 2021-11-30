public class Main {
    public static void main(String[] args) {
        String str = "Programming is fascinating!";
        int index = str.offsetByCodePoints(0, 5);
        System.out.println("Offset of the sixth code point from the first code point: " + index);
    }
}
  