public class Main {
    public static void main(String[] args) {
        String str = "level";
        char[] charArray = str.toCharArray();

        boolean isPalindrome = true;
        for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
            if (charArray[i] != charArray[j]) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Is \"" + str + "\" a palindrome? " + isPalindrome);
    }
}
  