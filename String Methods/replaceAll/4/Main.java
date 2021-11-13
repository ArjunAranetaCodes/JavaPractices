public class Main {
    public static void main(String[] args) {
        String input = "12345 is a number";
        String replacedString = input.replaceAll("\\d", "*");
        System.out.println(replacedString);
    }
}
