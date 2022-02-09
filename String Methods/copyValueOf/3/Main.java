public class Main {
    public static void main(String[] args) {
        char[] charArray = {'1', '2', '3', '4', '5'};
        String result = String.copyValueOf(charArray, 1, 3);
        System.out.println(result);
    }
}
   