public class Main {
    public static void main(String[] args) {
        String str = "OpenAI GPT-3";
        int index = str.offsetByCodePoints(6, -2);
        System.out.println("Offset of the fourth code point from the fourth code point (backward): " + index);
    }
}
