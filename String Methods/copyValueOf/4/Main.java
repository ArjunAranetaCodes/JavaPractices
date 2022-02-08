public class Main {
    public static void main(String[] args) {
        char[] charArray = {'C', 'o', 'p', 'y', 'V', 'a', 'l', 'u', 'e', 'O', 'f'};
        String result = String.copyValueOf(charArray, 4, 6);
        System.out.println(result);
    }
}
