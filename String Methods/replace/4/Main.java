public class Main {
    public static void main(String[] args) {
        String text = "Replace all digits 123 with X";
        String replacedText = text.replaceAll("\\d", "X");
        System.out.println(replacedText);
    }
}
 