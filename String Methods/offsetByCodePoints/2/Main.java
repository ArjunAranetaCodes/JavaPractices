public class Main {
    public static void main(String[] args) {
        String str = "Java is fun!";
        int index = str.offsetByCodePoints(5, 2);
        System.out.println("Offset of the eighth code point from the sixth code point: " + index);
    }
}
  