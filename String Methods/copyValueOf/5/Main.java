public class Main {
    public static void main(String[] args) {
        char[] charArray = {'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r', 'a', 'm'};
        String result = String.copyValueOf(charArray, 0, 4);
        System.out.println(result);
    }
}
